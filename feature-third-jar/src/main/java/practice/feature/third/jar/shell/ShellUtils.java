package practice.feature.third.jar.shell;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;

/**
 * @author Quenton
 */
public class ShellUtils {

    public static ShellExecResult exec(String cmd) throws Exception {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(cmd);

            RuntimeStreamConsumer c1 = new RuntimeStreamConsumer(p.getInputStream());
            c1.start();
            RuntimeStreamConsumer c2 = new RuntimeStreamConsumer(p.getErrorStream());
            c2.start();

            Integer exitcode;
            try {
                exitcode = p.waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return new ShellExecResult(exitcode, c1.getOutput(), c2.getOutput());
        } finally {
            if (null != p) {
                p.destroy();
            }
        }
    }

    public static class ShellExecResult {
        public final Integer exitCode;
        public final String stdout;
        public final String stderr;

        public ShellExecResult(Integer exitCode, String stdout, String stderr) {
            this.exitCode = exitCode;
            this.stdout = stdout;
            this.stderr = stderr;
        }
    }

    public static class RuntimeStreamConsumer {

        private final InputStream inputStream;
        private final ExecutorService exec;

        private Future<String> result;

        public RuntimeStreamConsumer(InputStream inputStream) {
            this.inputStream = inputStream;
            this.exec = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        }

        public void start() {
            this.result = this.exec.submit(() -> {
                try {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buff = new byte[2048];
                    int len;
                    while ((len = inputStream.read(buff)) != -1) {
                        baos.write(buff, 0, len);
                    }
                    return baos.toString("UTF-8");
                } finally {
                    IOUtils.closeQuietly(inputStream);
                }
            });
            this.exec.shutdown();
        }

        public String getOutput() throws Exception {
            return this.result.get();
        }
    }
}

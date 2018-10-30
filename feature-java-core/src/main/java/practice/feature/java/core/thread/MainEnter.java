package practice.feature.java.core.thread;

import java.io.File;
import java.io.FileWriter;

public class MainEnter {

    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            WriteFile file1 = new WriteFile("WriteFile" + i + ".txt");
            new Thread(file1).start();
        }
    }

    static class WriteFile implements Runnable {
        private String name;

        public WriteFile(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Long now = System.currentTimeMillis();
            File file = new File(name);
            try {
                file.createNewFile();
                FileWriter versionWriter = new FileWriter(file, true);
                for (long i = 0; i < 1000000L; i++) {
                    versionWriter.write(name + "****" + i);
                    versionWriter.write(System.getProperty("line.separator"));

                }
                versionWriter.flush();
                versionWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Long newnow1 = System.currentTimeMillis();
            System.out.println(name + "导出时间：" + (newnow1 - now));
        }
    }
}

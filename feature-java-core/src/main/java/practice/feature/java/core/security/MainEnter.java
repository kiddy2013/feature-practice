package practice.feature.java.core.security;

import java.io.File;
import java.net.URL;

/**
 * 程序主要入口
 * 或者启动的手增加 -Djava.security.manager 来启动沙箱
 * 与System.setSecurityManager(new SecurityManager());等价
 *
 * @author jack
 */
public class MainEnter {

    public static void main(String[] args) throws Exception {
        System.setSecurityManager(new SecurityManager());

        LocalFileReader fileReader = new LocalFileReader();
        URL url = MainEnter.class.getClassLoader().getResource("localFile.txt");
        File file = new File(url.getFile());
        fileReader.readFile(file);

        // 读取系统文件，与读取classpath文件，权限不一样
        File file1 = new File("unExist.txt");
        fileReader.readFile(file1);
    }
}

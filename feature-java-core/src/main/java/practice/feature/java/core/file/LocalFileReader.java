package practice.feature.java.core.file;

import java.io.File;
import java.io.FileReader;

/**
 * @author jack
 */
public class LocalFileReader {

    /**
     * 读取本地文件
     *
     * @throws Exception
     */
    public void readFile(File file) throws Exception {
        FileReader fileReader = new FileReader(file);
        char[] readChar = new char[1024];
        while (fileReader.read(readChar) != -1) {
            System.out.println(new String(readChar));
        }
    }
}

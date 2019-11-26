package learnio;

/**
 * Created by momoko on 2019/11/25
 *
 * @author momoko
 */

import java.io.*;

/**
 * InputStream并不是一个接口，而是一个抽象类，它是所有输入流的超类
 */
public class LearnInputStream {
    //使用FileInputStream读取文件中的内容
    public static void readWriteFile(String inputName, String outputName) throws IOException {
        InputStream fin = null;
        OutputStream fout = null;
        try {
            fin = new FileInputStream(inputName);
            fout = new FileOutputStream(outputName);
            byte[] buffer = new byte[4096];
            while (fin.read(buffer) != -1) {
                fout.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null && fout != null) {
                fout.close();
                fin.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        readWriteFile("src/main/java/learnio/IO.md","/Users/momoko/Downloads/test.md");
    }

}

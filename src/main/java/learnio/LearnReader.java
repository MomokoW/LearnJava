package learnio;

/**
 * Created by momoko on 2019/12/3
 *
 * @author momoko
 */

import java.io.*;

/**
 * java.io.Reader是所有字符输入流的超类，它最主要的方法是：
 * public int read() throws IOException;
 */
public class LearnReader {
    public static void main(String[] args) throws IOException {
        readFile();

        //CharArrayReader可以在内存中模拟一个Reader，它的作用实际上是把一个char[]数组变成一个Reader
        try(Reader reader = new CharArrayReader("hello".toCharArray())) {

        }
        //StringReader可以直接把String作为数据源
        try(Reader reader = new StringReader("hello")){}

        /**
         * 除了特殊的CharArrayReader和StringReader，
         * 普通的Reader实际上是基于InputStream构造的，
         * 因为Reader需要从InputStream中读入字节流（byte），
         * 然后，根据编码设置，再转换为char就可以实现字符流。
         * 如果我们查看FileReader的源码，它在内部实际上持有一个FileInputStream。
         */

        InputStream input = new FileInputStream("src/");
        Reader byteToChar = new InputStreamReader(input);

    }


    public static void readFile () {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/momoko/Downloads/重生之将门毒后.txt"))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                count ++;
//                System.out.println(line);
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

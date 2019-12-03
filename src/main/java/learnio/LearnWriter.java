package learnio;

/**
 * Created by momoko on 2019/12/3
 *
 * @author momoko
 */

import utils.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Reader是带编码转换器的InputStream，它把byte转换为char
 * 而Writer就是带编码转换器的OutputStream，它把char转换为byte并输出
 */
public class LearnWriter {

    public static void main(String[] args) throws IOException {
        writeToFile("/Users/momoko/Downloads/readme.txt");
    }

    public static void writeToFile(String fileName) throws IOException {
        if(StringUtils.isEmpty(fileName)) return ;
        try(Writer writer = new FileWriter(fileName)) {
            writer.write("H");
            writer.write("E");
            writer.write("L");
            writer.write("L");
            writer.write("O");
        }
    }


}

package learnio;

import java.io.File;
import java.io.IOException;

/**
 * Created by momoko on 2019/11/25
 *
 * @author momoko
 */
public class LearnFile {
    public static void main(String[] args) throws IOException {

        //要构造一个File对象，需要传入文件路径
        File f = new File("/Users/momoko/Downloads/ProfilePhoto");
        System.out.println(f);

        //构造File对象时，既可以传入绝对路径，也可以传入相对路径。绝对路径是以根目录开头的完整路径
        //传入相对路径时，相对路径前面加上当前目录就是绝对路径：
        File f1 = new File("src/main/java/learnio/IO.md");
        System.out.println(f1.exists());
        System.out.println(f1.getAbsolutePath());

        //规范路径就是把.和..转换成标准的绝对路径后的路径
        File f2 = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());

        System.out.println(File.separator);

        //File对象既可以表示文件，也可以表示目录
        File f3 = new File(".");
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());
        System.out.println(f3.getAbsolutePath());


        //当File对象表示一个文件时，可以通过createNewFile()创建一个新文件，用delete()删除该文件
        File f4 = new File("/Users/momoko/Downloads/ProfilePhoto");
        if (f4.createNewFile()) {
            System.out.println("创建文件成功");
            if (f4.delete()) {
                System.out.println("删除文件成功");
            }
        }

        //遍历文件和目录
        File f5 = new File("./src");
        System.out.println(f5.isDirectory());
        File[] fs1 = f5.listFiles();
        printFiles(fs1);
        //仅列出.java文件
        File[] files = f5.listFiles((dir, name) -> name.endsWith(".java"));
        printFiles(files);

    }

    private static void printFiles(File[] fs1) {
//        System.out.println("=========");
        if (fs1 != null) {
            for (File f : fs1) {
                if(f.isDirectory()) {
                    File[] files = f.listFiles();
                    printFiles(files);
                }
                System.out.println(f);
            }
        }
//        System.out.println("=========");

    }


}

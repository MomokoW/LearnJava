package learnio;

/**
 * Created by momoko on 2019/11/26
 *
 * @author momoko
 */

import java.io.*;

/**
 * 序列化是指把一个Java对象变成二进制内容，本质上就是一个byte[]数组。
 * 一个Java对象要能序列化，必须实现一个特殊的java.io.Serializable接口
 * Serializable接口没有定义任何方法，它是一个空接口
 */
public class LearnSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "/Users/momoko/Downloads/text.txt";
        OutputStream buffer = new FileOutputStream(fileName);
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)){
        // 写入int:
        output.writeInt(12345);
        // 写入String:
        output.writeUTF("Hello");
        // 写入Object:
        output.writeObject(123.456);
    }
        System.out.println("输出成功");

        //和ObjectOutputStream相反，ObjectInputStream负责从一个字节流读取Java对象

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName) {
        })) {
            int n = input.readInt();
            String s = input.readUTF();
            Double d = (Double) input.readObject();

            System.out.println(s + n + d.toString());
        }
    }
}

package javabasic.day14;

/**
 * Created by momoko on 2020/12/10.
 */
public class MainTest {
    public static void main(String[] args) {
        Main.main(new String[100]);
    }
}

class Main {
    public static void main(String[] args) {
        args = new String[100];
        for (int i = 0; i < args.length; i++) {
            System.out.println("args_" + i);
        }
    }
}
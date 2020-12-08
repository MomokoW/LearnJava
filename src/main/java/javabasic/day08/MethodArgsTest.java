package javabasic.day08;

/**
 * Created by momoko on 2020/11/9.
 */
public class MethodArgsTest {
    public static void main(String[] args) {
        MethodArgsTest test = new MethodArgsTest();
        test.show("hello", "world");
    }

    public void show(int i) {
        System.out.println(i);
    }

    public void show(String s) {
        System.out.println(s);
    }

    public void show(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }

    }

    /**
     * swap two datas in the array
     * @param arr an array
     * @param i data index
     * @param j data index
     *
     */
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
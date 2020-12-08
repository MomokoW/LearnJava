package javabasic.day07;

/**
 * Created by momoko on 2020/11/6.
 */
public class ArrayDupRev {
    public static void main(String[] args) {
        //数组的复制
        String[] arr = new String[]{"Sun","Mon","Tus","Wed","Thur","Fri","Sat"};

        String[] arr1 = new String[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            arr1[i] = arr[i];
        }

        for (String s : arr) {
            System.out.print(s + " ");
        }

        System.out.println();
        //数组的反转
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i -1];
            arr[arr.length - i - 1] = temp;
        }
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
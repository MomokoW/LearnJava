package javabasic.day06;
import java.util.Scanner;

/**
 * Created by momoko on 2020/11/6.
 */

public class ArrayTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入学生的数量:");
        int number = scan.nextInt();
        int[] arr = new int[number];
        int maxScore = 0;
        System.out.println("请输入" + number + "个学生的成绩:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
            if (maxScore < arr[i])
                maxScore = arr[i];
        }
        char level;
        for (int i = 0; i < arr.length; i++) {
            if (maxScore - arr[i] <= 10)
                level = 'A';
            else if (maxScore - arr[i] <= 20)
                level ='B';
            else if (maxScore - arr[i] <= 30)
                level = 'C';
            else
                level = 'D';
            System.out.println("第" + i + "个学生的成绩为" + arr[i] + "等级是" + level);
        }


        //类型推断
        String[] names = {"sunny","bob"};


    }
}
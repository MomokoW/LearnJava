package javabasic.day07;

/**
 * Created by momoko on 2020/11/6.
 * 随机获取[a,b]之间的整数值
 * (int)(Math.random() * (b - a + 1) + a)
 */
public class ArrayMaxMinSum {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (99 - 10 + 1) + 10);
        }

        //求数组元素的最大值
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        System.out.println("最大值为： " + maxValue);

        //求数组元素的最小值
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }
        System.out.println("最小值为： " + minValue);

        //求数组元素的总和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("总和为: " + sum);

        //求数组元素的平均值
        int avgValue = sum / arr.length;
        System.out.println("平均值为： " + avgValue);


    }
}
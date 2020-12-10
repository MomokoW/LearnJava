package javabasic.day07;

/**
 * Created by momoko on 2020/11/6.
 * 杨辉三角
 */
public class YangHuiTria {
    public static void main(String[] args) {
        //1.声明并初始化二维数组
        int[][] yanghui = new int[10][];

        //2.给数组的元素赋值
        for (int i = 0; i < yanghui.length; i++) {
            yanghui[i] = new int[i + 1];

            //给首末元素赋值
            yanghui[i][0] = 1;
            yanghui[i][i] = 1;

            //给每行的非首末元素赋值

            for (int j = 1; j < yanghui[i].length - 1; j++) {
                yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];

            }
        }

        //3/遍历
        for (int i = 0; i < yanghui.length; i++) {
            for (int k = 0; k < yanghui.length - 1 - i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < yanghui[i].length; j++) {
                System.out.print(yanghui[i][j] + " ");
            }
            System.out.println();
        }
    }
}
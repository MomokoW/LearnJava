package javabasic.day05;

/**
 * Created by momoko on 2020/11/3.
 */
public class WanShu {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 1000; i++){
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0){
                    sum += j;
                    if (j != 1) {
                        sum += i / j;
                    }
                }

            }
            if (sum == i) {
                System.out.print(i + " ");
            }
            sum = 0;
        }
    }
}
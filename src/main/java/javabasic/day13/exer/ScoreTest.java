package javabasic.day13.exer;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by momoko on 2020/12/9.
 */
public class ScoreTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Vector v = new Vector();
        int maxScore = 0;
        for(; ;) {
            System.out.println("请输入学生成绩(以负数代表输入结束)");
            int score = scan.nextInt();
            if (score < 0) {
                break;
            }

            if(score > 100) {
                continue;
            }
            v.addElement(score);

            if(maxScore < score) {
                maxScore = score;
            }

        }

        char level;
        for (int i = 0; i < v.size(); i++) {
            Object obj = v.elementAt(i);
            int score = (int) obj;

            if(maxScore - score <= 10) {
                level = 'A';
            } else if(maxScore - score <= 20) {
                level = 'B';
            } else if(maxScore - score <= 30) {
                level = 'C';
            } else {
                level = 'D';
            }

            System.out.println("Student-" + i + " score is " + score + ", level is " + level);
        }


    }

}
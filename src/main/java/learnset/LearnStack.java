package learnset;

import java.util.Stack;

/**
 * Created by momoko on 2019/11/22
 *
 * @author momoko
 */
public class LearnStack {
    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    /**
     * 十进制转换16进制
     * @param n
     * @return
     */
    static String toHex(int n) {
        Stack<String> hexNum = new Stack<>();
        int num = n % 16;
        while (n != 0) {
            if (num < 10)
                hexNum.push(String.valueOf(num));
            else {
                switch (num) {
                    case 10:
                        hexNum.push("A");
                        break;
                    case 11:
                        hexNum.push("B");
                        break;
                    case 12:
                        hexNum.push("C");
                        break;
                    case 13:
                        hexNum.push("D");
                        break;
                    case 14:
                        hexNum.push("E");
                        break;
                    case 15:
                        hexNum.push("F");
                        break;
                }
            }
            n=n/16;
            num = n % 16;
        }
        StringBuffer sb = new StringBuffer();
        while (!hexNum.empty()) {
            String pop = hexNum.pop();
            sb.append(pop);
        }
        return sb.toString();
    }
}

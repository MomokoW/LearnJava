package learnreg;

import com.sun.tools.javac.util.List;

/**
 * Created by momoko on 2019/12/12
 *
 * @author momoko
 */
public class LearnRegx {
    public static void main(String[] args) {
        //正则表达式的匹配规则是从左到右按规则匹配
        String re1 = "abc";
        System.out.println("abc".matches(re1));
        System.out.println("Abc".matches(re1));

        String re2 = "a&c";
        System.out.println("a&c".matches(re2));
        System.out.println("a\\&c".matches(re2));
        System.out.println(re2.matches(re2));
        System.out.println(re2);

        String re = "\\d{3,4}-\\d{7,8}";
        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }

}

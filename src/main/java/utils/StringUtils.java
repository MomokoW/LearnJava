package utils;

/**
 * Created by momoko on 2019/12/3
 *
 * @author momoko
 */
public class StringUtils {
    public static boolean isEmpty(String s) {
        //equals把常量写在前面
        return s == null||"".equals(s);
    }

    public static String capitalize(String s) {
        if (s.length() == 0) {
            return s;
        }
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}

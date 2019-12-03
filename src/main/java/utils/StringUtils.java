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
}

package date_and_time;

import java.util.TimeZone;

/**
 * Created by momoko on 2019/12/5
 *
 * @author momoko
 */
public class LearnTimeZone {
    public static void main(String[] args) {
        TimeZone tzDefault = TimeZone.getDefault(); // 当时时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00");  //GMT+9:00时区
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York");
        System.out.println(tzDefault.getID());
        System.out.println(tzDefault.getDisplayName());
        System.out.println(tzGMT9.getID());
        System.out.println(tzGMT9.getDisplayName());
        System.out.println(tzNY.getID());
        System.out.println(tzNY.getDisplayName());



    }
}

package date_and_time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by momoko on 2019/12/5
 *
 * @author momoko
 */
public class LearnDate {
    public static void main(String[] args) {
        //获取当前时间
        Date date = new Date();
        /**
         * 注意getYear()返回的年份必须加上1900
         * getMonth()返回的月份是0~11分别表示1~12月，所以要加1
         * 而getDate()返回的日期范围是1~31，又不能加1
         */
        System.out.println(date.getYear()+1900);
        System.out.println(date.getMonth()+1);
        System.out.println(date.getDate());
        //转换为GMT时区
        System.out.println(date.toGMTString());
        //转换为本地时区
        System.out.println(date.toLocaleString());

        //获取时间戳
        System.out.println(date.getTime());

        /**
         * 使用SimpleDateFormat对一个Date进行转换，它用预定义的字符串表示格式化
         * yyyy:年
         * MM:月
         * dd:日
         * HH:小时
         * mm:分钟
         * ss:秒
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));





    }
}

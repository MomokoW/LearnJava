import com.momoko.date_and_time.LearnCalender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * Created by momoko on 2019/12/5
 *
 * @author momoko
 */
public class LearnCalenderTest {
    @Test
    void testNextDayWeekStr() {
        Date date = new Date();
        String nextDayWeekStr = LearnCalender.getNextDayWeekStr(date);
        Assertions.assertEquals("Fri", nextDayWeekStr);

        date.setTime(date.getTime() + 24*60*60*1000);
        nextDayWeekStr = LearnCalender.getNextDayWeekStr(date);
        Assertions.assertEquals("Sat", nextDayWeekStr);

        date.setTime(date.getTime() + 2 * 24*60*60*1000);
        nextDayWeekStr = LearnCalender.getNextDayWeekStr(date);
        Assertions.assertEquals("Mon", nextDayWeekStr);
    }
}

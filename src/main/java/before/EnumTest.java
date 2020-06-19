package before;

/**
 * Created by momoko on 2020/6/19.
 */
public class EnumTest {
    public static void main(String[] args) {

        WeekDay day = WeekDay.SUN;
        if(day.dayValue == 0 || day.dayValue == 6) {
            System.out.println("Work at home");
        } else {
            System.out.println("Work at office");
        }

    }

    enum WeekDay {
        MON(1),TUE(2),WED(3),THU(4),FRI(5),SAT(6),SUN(0);

        public final int dayValue;

        private WeekDay(int dayValue) {
            this.dayValue = dayValue;
        }
    }
}
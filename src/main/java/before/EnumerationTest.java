package before;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by sunyuqing on 2019/9/17.
 */
public class EnumerationTest {
    public static void main(String[] args) {
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<String>();
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        dayNames.add("Sunday");
        days = dayNames.elements();
        while(days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }
}

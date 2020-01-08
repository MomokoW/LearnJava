package before;

import java.io.Serializable;

/**
 * Created by sunyuqing on 2019/9/19.
 */
public class Employee implements Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to" + name + "" + address);
    }
}

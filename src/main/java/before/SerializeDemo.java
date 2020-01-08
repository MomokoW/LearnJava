package before;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by sunyuqing on 2019/9/19.
 */
public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name="Sunny";
        e.address="Hubei Wuhan";
        e.SSN=112323;
        e.number=101;
        try {
            FileOutputStream fileOut = new FileOutputStream("tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            System.out.println("Serialized data is saved in /tmp/employee.ser");

        } catch (IOException i){
            i.printStackTrace();
        }
    }
}

package before;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by sunyuqing on 2019/9/19.
 */
public class DeserializeDemo {
    public static void main(String[] args) {
        Employee e = null;
        try {
            FileInputStream fis = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            e = (Employee)ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Deserialized Employee...");
            System.out.println("Name: " + e.name);
            System.out.println("Address: " + e.address);
            System.out.println("SSN: " + e.SSN);
            System.out.println("Number: " + e.number);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

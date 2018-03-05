package serializing_practise;
import materials.Employee;
import java.io.*;

public class Deserializ_Class {

    public static void main(String [] args)
    {
        Employee e1 = null;
        Employee e2 = null;
        Employee e3 = null;
        Employee e4 = null;
        try
        {
//            ObjectInputStream用以从文件读取序列化的对象，包含的是一个Stream输入流对象
//            因此读取方式和读取txt文件一样，一个个单位读取，读取一次出来的对象再类型转换到对应的类
            FileInputStream fileIn = new FileInputStream("./tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e1 = (Employee) in.readObject();
            e2 = (Employee) in.readObject();
            e3 = (Employee) in.readObject();
            e4 = (Employee) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("before e3 is changed");
        System.out.println("e2 --- "+e2);
        System.out.println("e3 --- "+e3);
        System.out.println("e2.equals(e3) --- "+e2.equals(e3));
        System.out.println("e2==e3 --- "+(e2==e3));
        System.out.println(" \n=============================\n");

        e3.SSN = 1;

        System.out.println("after e3 is changed");
        System.out.println("e2 --- "+e2);
        System.out.println("e3 --- "+e3);
        System.out.println("e2.equals(e3) --- "+e2.equals(e3));
        System.out.println("e2==e3 --- "+(e2==e3));

        System.out.println(" \n=============================\n");

        System.out.println("Deserialized Employee "+ e1.number);
        System.out.println("Name: " + e1.name);
        System.out.println("Address: " + e1.address);
        System.out.println("SSN: " + e1.SSN+" \n=============================\n");

        System.out.println("Deserialized Employee "+ e2.number);
        System.out.println("Name: " + e2.name);
        System.out.println("Address: " + e2.address);
        System.out.println("SSN: " + e2.SSN+" \n=============================\n");

        System.out.println("Deserialized Employee "+ e3.number);
        System.out.println("Name: " + e3.name);
        System.out.println("Address: " + e3.address);
        System.out.println("SSN: " + e3.SSN+" \n=============================\n");

        System.out.println("Deserialized Employee "+ e4.number);
        System.out.println("Name: " + e4.name);
        System.out.println("Address: " + e4.address);
        System.out.println("SSN: " + e4.SSN+" \n=============================\n");
    }

}

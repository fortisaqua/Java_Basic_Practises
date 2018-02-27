package serializing_practise;
import materials.Employee;
import java.io.*;

public class Serialize_Class {
    public static void main(String [] args)
    {
        Employee e1 = new Employee("Reyan Ali","Phokka Kuan, Ambehta Peer",11122333,101);
        Employee e2 = new Employee("Desmond Mils","Rome , Italy",11133555,102);
        Employee e2_1 = new Employee("Desmond Mils","Rome , Italy",11133555,102);
        Employee e3 = new Employee("Desmond Mils","Rome , Italy",11133555,103);
        try
        {
            File root_dir = new File("./tmp");
            File target_file = new File("./tmp/employee.ser");
//      如果File对象代表的目录不存在，则.isDirectory()也会返回false
//      因此如果要创建目录，则直接创建，不要先判断是否为目录
            if(!root_dir.exists())
            {
                if(!root_dir.mkdirs()){
                    System.out.println("creating root directory failed");
                    System.exit(2);
                }
            }
            FileOutputStream fileOut =
                    new FileOutputStream(target_file);
//      OnjectOutputStream 用以输出对象
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            在以下的四个写入语句中，注意第二个和第三个，如果写入的是两个对象，则读取后，
//            ，第二个和第三个读取的对象就算两个对象所有参数相等，两个对象也是不想等的（读取的顺序和写入顺序一致），
//            如果第二个和第三个输入的是同一个对象e2，则读取的第二个和第三个对象也会完全一样，即是同一个对象的两个引用
//            一个引用修改此对象，另一个引用读取的内容也会发生改变
            out.writeObject(e1);
            out.writeObject(e2);
            out.writeObject(e2);
            out.writeObject(e3);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./tmp/employee.ser");
        }catch(IOException i)
        {
            System.out.println(i.getLocalizedMessage());
            i.printStackTrace();
        }
    }
}

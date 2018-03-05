package materials;

import java.io.Serializable;

public class Employee implements Serializable{

    public String name;
    public String address;
//    带有transient的参数在实例化后，值不会被保存到序列化的流中，即“暂时的”
//    在读取被序列化的对象后，带有transient声明的参数会初始化
    public transient int SSN;
    public int number;

    public Employee(String name,String address,int SSN,int number){
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.number = number;
    }

    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }

}

package practise1;
import java.io.*;

//定义一个需要序列化的类

class People implements Serializable{
    String name; //姓名
    transient Integer age; //年龄
    public People(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "姓名 = "+name+" ,年龄 = "+age;
    }

}

//当对象被序列化时（写入字节序列到目标文件）时，transient阻止实例中那些用此关键字声明的变量持久化；
// 当对象被反序列化时（从源文件读取字节序列进行重构），这样的实例变量值不会被持久化和恢复；
// 对于类和对象来说反序列化的就是一次实例化，transient关键字起到了"筛选器"的作用，选择哪些状态不需要被保存下来

public class TransientPeople {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        People a = new People("李雷",30);
        System.out.println(a); //打印对象的值
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./people.txt"));
        os.writeObject(a);//写入文件(序列化)
        os.close();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("./people.txt"));
        a = (People)is.readObject();//将文件数据转换为对象（反序列化）
        System.out.println(a); // 年龄 数据未定义
        is.close();
        a.name="jacky";
        a.age=20;
        System.out.println(a);
    }
}

package Object_Oriented;

class Gene{

}
// 接口Gene_funs没有内容，只有空的定义，可以是为"标记接口"
/*
标记接口的意义：
1.建立一个公共的父接口：即给接口分组
2.向一个类添加数据类型：实现标记接口的类不需要定义任何接口方法(因为标记接口根本就没有方法)，但是该类通过多态性变成一个接口类型

接口中依旧可以实现具体的方法：
1.默认方法：添加default修饰符
2.静态方法：添加static修饰符
* */
interface Gene_funs{
    //这个是默认方法
    default String get(String aa){
        System.out.println("我是jdk1.8默认实现方法...");
        return "";
    }
    //这个是静态方法
    static void staticmethod(){
        System.out.println("我是静态方法");
    }
}
//接口可以继承接口，但是不能继承类
//interface Person extends Gene{
interface Person extends Gene_funs{
    public String getName();
    public String getAddress();
    public void setAddress(String newAddress);
    public int getNumber();
    double addNumber_2(double a ,double b,double c);
}

//不像类，接口可以实现多继承，继承的接口可以重写父接口的抽象方法
interface Socialize extends Gene_funs,Person{
//接口不能包含成员变量，除了 static 和 final 变量
//    接口中可以含有变量，但是接口中的变量会被隐式的指定为
// public static final 变量（并且只能是 public，用 private 修饰会报编译错误）
    String socialClass = "work class";
    public int getNumber();
}

//可以实现多个接口
public abstract class Employee implements Person,Socialize{

    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number) {
        System.out.println("Employee 构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public void mailCheck() {
        System.out.println("邮寄支票给： " + this.name
                + " " + this.address);
    }
    public String toString() {
        return name + " " + address + " " + number;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    public int getNumber() {
        return number;
    }
    public static double addNumber_1(double a,double b){
        return a+b;
    }
    public static void staticmethod_1(){
        Gene_funs.staticmethod();
    }
    /*
抽象的特性：
* 构造方法，类方法（用static修饰的方法）不能声明为抽象方法（没有实体{}的方法）
* 没有实体不分配空间给此方法*/
//    public abstract static double addNumber_2(double a ,double b,double c);
//    如果实现接口的类是抽象类，则实现接口的方法可以是抽象方法，否则就必须有实体
    public abstract double addNumber_2(double a ,double b,double c);
}

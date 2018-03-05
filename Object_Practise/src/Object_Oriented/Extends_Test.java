package Object_Oriented;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import java.io.IOException;

class Animal {
    private String name;
    private String id;

    final protected String GetId(){
        return id;
    }

    final protected  String GetName(){
        return name;
    }

    protected Animal(String myName, String myid) {
        //初始化属性值
        name = myName;
        id = myid;
    }

    public Animal()
    {

    }
    public void eat() throws IOException {
        System.out.print("Animal ");
    }
    public void sleep() { //睡觉方法的具体实现
    }
}

class Penguin  extends  Animal{
//    当父类没有显示地定义无参数构造器，而有带参数的构造器时
//    则要显式地通过super关键字调用父类的构造器并配以适当的参数列表
    public Penguin()
    {

    }

    protected Penguin(int n)
    {

    }

    public Penguin(String myName, String myid)
    {
        super(myName, myid);
        System.out.println("Object Penguin");
    }
//    override即重写，这个方法用以修改父类中可以被修改的方法的内容（public，protected，非final）
//    方法的重写体现在子类中定义了和父类一样名字，一样的返回类型和一样的参数列表的方法，而方法的内容有所不同
    public void eat()throws IOException{
        super.eat();
        System.out.println(GetName()+" is eating");
    }
    public void sleep(){
        System.out.println(GetName()+" is sleeping");
    }
//    final方法不能被修改
//    protected String GetId(){}
}

class Dog extends Animal{
    public Dog(String myName, String myid)
    {
        super(myName,myid);
    }
    protected void bark()
    {
        System.out.println(GetName()+" is barking");
    }
//    被重写的方法有抛出声明的话，重写的方法也要有对应的抛出声明
//    重写的方法抛出的异常应该是被重写方法抛出异常的子集
    public void eat() throws IOException{
        super.eat();
        System.out.println(GetName()+" is eating");
    }

//    重写的方法访问权限不能比父类中被重写的方法的访问权限更低
    public void sleep(){
        System.out.println("Dog is sleeping");
    }

}

public class Extends_Test {
    protected final class Animal_ID{

    }
//    final类不能被继承
//    protected class sub_ID extends Animal_ID{
//
//    }
    public static void main(String[] args) throws IOException{
        Penguin peg1 = new Penguin("Penguin 1","admin1");
        peg1.eat();
        Dog dog1 = new Dog("Dog 1","admin2");
        dog1.eat();
        dog1.bark();
        Animal dog2 = new Dog("Dog 2","admin3");
        dog2.eat();
//        dog2.bark();
//        向下转型之后才行
        ((Dog) dog2).bark();
//        声明为父类的子类对象，引用的类型为父类，因此不能调用子类独有的方法，只能调用父类中的，这是在编译中定制的规则
//        然而在运行中，运行的是子类的对象，因此运行的也是子类的方法，以上的dog2就是一个例子
//        以多态的方式解释：
//        当使用多态方式调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误
//        如果有，再去调用子类的同名方法
    }
}

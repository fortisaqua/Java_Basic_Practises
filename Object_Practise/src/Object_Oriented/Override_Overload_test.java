package Object_Oriented;


// overload: 即重载，在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。
//           重载的方法可以改变访问修饰符，例如test3

// override: 即重写，是指子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变

import java.io.FileNotFoundException;
import java.io.IOException;

public class Override_Overload_test {
    public int test(){
        System.out.println("test1");
        return 1;
    }

    public void test(int a) throws IOException {
        System.out.println("test2");
    }

    //以下两个参数类型顺序不同
    protected String test(int a,String s){
        System.out.println("test3");
        return "returntest3";
    }

    public String test(String s,int a){
        System.out.println("test4");
        return "returntest4";
    }

//    自己在自己内部设置子类也可以，以下四个函数就是对于父类四个方法的重写
    public static class Sub_test extends Override_Overload_test{

    public int test(){
        System.out.println("test1 from sub test");
        return 1;
    }
//  重写的方法抛出的异常需要在被重写方法抛出异常的范围之内
    public void test(int a) throws FileNotFoundException {
        System.out.println("test2 from sub test");
    }

    //以下两个参数类型顺序不同
    protected String test(int a,String s){
        System.out.println("test3 from sub test");
        return "returntest3";
    }

    public String test(String s,int a){
        System.out.println("test4 from sub test");
        return "returntest4";
    }
    }

    public static void main(String[] args) throws Exception {
        Sub_test o = new Sub_test();
        System.out.println(o.test());
        o.test(1);
        System.out.println(o.test(1,"test3"));
        System.out.println(o.test("test4",1));
    }
}

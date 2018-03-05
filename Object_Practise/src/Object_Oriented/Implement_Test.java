package Object_Oriented;

interface interface_A {
//    如果两个接口定义了同一个名字的变量，则会在类实例化后，调用这个变量的时候报错"ambiguous"
//    public char symble = 'a';
    public void eat();
    public void sleep();
}

interface interface_B {
//    接口中的变量，都是final量，不能修改
    public char symble = 'b';
    public void show();
}

class class_C implements interface_A,interface_B {
    public void eat(){};
    public void sleep(){};
    public void show(){};
}


public class Implement_Test {

    public static void main(String[] args){
        class_C c1 = new class_C();
        System.out.println(c1.symble);
    }

}

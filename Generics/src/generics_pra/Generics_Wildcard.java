package generics_pra;
import java.util.*;

interface Generics_Int1<I,J>{
    public void setA(I a);
    public void setB(J b);
    public I getA();
    public J getB();
}

class Generics_Box<A,B> implements Generics_Int1<A,B>{
    private A a;
    private B b;

    protected Generics_Box(){}

    protected Generics_Box(A a,B b){
        this.a = a;
        this.b = b;
    }

    public void setA(A a) {
        this.a = a;
    }
//带有类型参数的函数可以在所在类中重构
    public void setA(A a,String b){

    }

    public void setB(B b) {
        this.b = b;
    }

    public A getA(){
        return this.a;
    }

    public B getB(){
        return this.b;
    }

    public void show_type(){
        System.out.println("A is "+a.getClass().getName());
        System.out.println("B is "+b.getClass().getName());
    }
//    重构
    public void show_type(A tempa){

    }
}

class Generics_Child1<M,N> extends Generics_Box{
    private M m;
    private N n;
//    泛型类子类中的函数如果参数列表含有类型参数，则不能重写
//    public void setA(M m) {}
//    public void setA(M m,String b) {}
    public void setM(M m) {
        this.m = m;
    }

    protected Generics_Child1(M m,N n){
        this.m = m;
        this.n = n;
    }

    public void setN(N n) {
        this.n = n;
    }

    public M getM(){
        return this.m;
    }

    public N getN(){
        return this.n;
    }
// 重写
    public void show_type(){
        System.out.println("M is "+m.getClass().getName());
        System.out.println("N is "+n.getClass().getName());
    }
}

public class Generics_Wildcard {

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

//        如果调用有上界的泛型函数，一旦类型超出范围，则会由检查性错误，直接卡在调用语句
//        getUperNumber(name);//1
//        getUperNumber(age);//2
        getUperNumber(number);//3

        getData(name);
        getData(age);
        getData(number);

        Generics_Wildcard gen_wld = new Generics_Wildcard();
        Generics_Box<?,?> gen_box_1 = new Generics_Box<String,Integer>("abc",123);
        gen_wld.Demo1(gen_box_1);
        Generics_Box<?,?> gen_box_2 = new Generics_Child1<Double,Box<?>>(Double.valueOf("4353.657"),new Box('t'));
        gen_wld.Demo1(gen_box_2);
        gen_box_2.show_type();


    }

// 使用?作为“通配符”，即所有泛型类的父类
//    <? extends T>表示该通配符所代表的类型是T类型的子类。
//    <? super T>表示该通配符所代表的类型是T类型的父类。
    public static void getData(List<? extends java.io.Serializable> data) {
//        泛型类型都是可序列化类型的子类
        System.out.println("data :" + data.get(0));
    }

    public static void getUperNumber(List<? super Number> data) {
//        泛型类型都是Number类型的父类
        try{
        System.out.println("data :" + data.get(0));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public <A,B> void Demo1(Generics_Box<A,B> box){
        A a;
        B b;
        if(box instanceof Generics_Child1)
        {
//            向下转型之后才能调用子类的方法
            Generics_Child1 temp_gen = (Generics_Child1)box;
//            如果不设置强制类型转换，以下的getM方法将返回Object类，
//            因此这也可以理解成是向下转型
            a = (A)temp_gen.getM();
            b = (B)temp_gen.getN();
            if(b instanceof Box){
//                泛型函数中，如果想要实现多态，即根据类型不同设置分支，则要调用具体类型前，
//                将抽象类型，例如这里的B，强制转换到具体类型，例如这里的Box
                System.out.println("class Box.T is "+((Box) b).get().getClass().getName());
            }
        }
        else{
        a = box.getA();
        b = box.getB();
        }
        System.out.println("Class A is "+a.getClass().getName());
        System.out.println("Class B is "+b.getClass().getName());
    }

}

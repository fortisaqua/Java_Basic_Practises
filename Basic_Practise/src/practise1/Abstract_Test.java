package practise1;

//抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充
//如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误，抽象类可以包含抽象方法和非抽象方法
abstract class Vehicle{
    private String model;
    private String year;
    public String color;
    protected static String class_name;
    public abstract void goFast(); //抽象方法
    public abstract void changeColor(String col);
    public abstract String getColor();
//    静态语句块前面不能有访问控制修饰符
    static {class_name="";}
    public void setName()
    {
        System.out.println("non-abstract method from abstract class");
    }
    public void Set_Year(String new_year){
        year=new_year;
    }
    public String Get_Model()
    {
        return model;
    }
}

abstract class Document{
    public double price;
    String document_number;
    protected static String class_name;
    public abstract void Set_Price(double new_price); //抽象方法
}

class car_document extends Document{
    public void Set_Price(double new_price){
        price=new_price;
    }
    public void Set_name(String new_name){
        class_name = new_name;
    }
    car_document(String doc_number){
        document_number=doc_number;
    }
}

class car extends Vehicle{
    car_document doc;
//    static {doc = new car_document();}
    public void goFast(){

    }; //抽象方法
    public void changeColor(String col){
        color=col;
    };
    public String getColor(){
        return color;
    };
    car(double price,String doc_number){
        this.doc = new car_document(doc_number);
        this.doc.Set_Price(price);
    }
    car(){}
}

//子类需要父类有默认构造函数才能继承，特殊的构造函数（就是上面带参数的）用super(上面的参数)也可以
class small_car extends car{
    private String plate_number;
    small_car(double price,String doc_number,String plate_num){
        super.doc = new car_document(doc_number);
        super.doc.Set_Price(price);
        plate_number = plate_num;
    }
    small_car(double price,String doc_number){
        super(price,doc_number);
    }
//    synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符
    synchronized String Get_Plate_Number(){
        return plate_number;
    }
}

public class Abstract_Test {
    public static void main(String[] args){
        car car1 = new car(100,"abc123456");
        small_car small_car1 = new small_car(50,"def7890","苏E0000");
        System.out.println("price of car1 from it's document : "+car1.doc.price);
        System.out.println("plate number of small car 1 : "+small_car1.Get_Plate_Number());
    }
}

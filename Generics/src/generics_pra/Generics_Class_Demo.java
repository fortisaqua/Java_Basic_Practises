package generics_pra;

class Box<T> {
    private T t;

    protected Box(){}

    protected Box(T t){
        this.t = t;
    }

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

public class Generics_Class_Demo {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("菜鸟教程"));

        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());
    }
}

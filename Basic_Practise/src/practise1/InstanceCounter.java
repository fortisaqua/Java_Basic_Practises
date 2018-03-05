package practise1;
//一个static关键字在变量和方法上应用当实例
//static关键字修饰的方法可以通过类来调用，私有方法必须通过类内的方法调用

public class InstanceCounter {
//    final 修饰的变量不能被更改
    public final int final_var=123;
    private static int numInstances = 0;
    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }


    InstanceCounter() {
        InstanceCounter.addInstance();
    }

    public static void main(String[] arguments) {
//        私有方法都通过类内方法间接调用
        System.out.println("Starting with " +
                InstanceCounter.getCount() + " instances");
        for (int i = 0; i < 500; ++i){
            new InstanceCounter();
        }
        System.out.println("Created " +
                InstanceCounter.getCount() + " instances");
    }
}

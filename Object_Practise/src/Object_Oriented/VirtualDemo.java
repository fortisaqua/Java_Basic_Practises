package Object_Oriented;
//虚拟方法调用
/*
* 实例中，实例化了两个 Salary 对象：一个使用 Salary 引用 s，另一个使用 Employee 引用 e。

当调用 s.mailCheck() 时，编译器在编译时会在 Salary 类中找到 mailCheck()，执行过程 JVM 就调用 Salary 类的 mailCheck()。

因为 e 是 Employee 的引用，所以调用 e 的 mailCheck() 方法时，编译器会去 Employee 类查找 mailCheck() 方法 。

在编译的时候，编译器使用 Employee 类中的 mailCheck() 方法验证该语句， 但是在运行的时候，Java虚拟机(JVM)调用的是 Salary 类中的 mailCheck() 方法。
* */



public class VirtualDemo {
    public static void main(String [] args) {
//        抽象类不能被实例化
//        只有抽象类的非抽象子类可以创建对象
//        Employee e1 = new Employee("员工 A", "北京", 1);
        Salary s = new Salary("员工 A", "北京", 3, 3600.00);
        Employee e = new Salary("员工 B", "上海", 2, 2400.00);
        System.out.println("使用 Salary 的引用调用 mailCheck -- ");
        s.mailCheck();
        s.get("aa");
        System.out.println("\n使用 Employee 的引用调用 mailCheck--");
        e.mailCheck();
        e.staticmethod_1();
//      接口无法被实例化，因此通过接口来调用是唯一直接调用接口中静态方法的办法
        Gene_funs.staticmethod();
    }
}

public class Multi_Status_Test {

//    多态的一个例子，根据参数的实际类型运行不同的分支
//    当使用多态方式调用方法时，首先检查父类中是否有该方法
//    如果没有，则编译错误；如果有，再去调用子类的同名方法

    public static void main(String[] args) {
        show(new Cat());  // 以 Cat 对象调用 show 方法
        System.out.println("-------------------------------------");
        show(new Dog());  // 以 Dog 对象调用 show 方法
        System.out.println("-------------------------------------");

        Animal a = new Cat();  // 向上转型
        a.eat();               // 调用的是 Cat 的 eat
        System.out.println("-------------------------------------");
        Cat c = (Cat)a;        // 向下转型
        c.work();        // 调用的是 Cat 的 work
        System.out.println("-------------------------------------");
    }

    public static void show(Animal a)  {
        a.eat();
        // 类型判断
        if (a instanceof Cat)  {  // 猫做的事情
            Cat c = (Cat)a;
//            子类独有的方法需要将声明为父类的对象向下转型才能调用
            c.work();
        } else if (a instanceof Dog) { // 狗做的事情
            Dog c = (Dog)a;
            c.work();
        }
    }
}

abstract class Animal {
    abstract void eat();
}

class Cat extends Animal {
    public void eat() {
        System.out.println("吃鱼");
    }
    public void work() {
        System.out.println("抓老鼠");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("吃骨头");
    }
    public void work() {
        System.out.println("看家");
    }

}

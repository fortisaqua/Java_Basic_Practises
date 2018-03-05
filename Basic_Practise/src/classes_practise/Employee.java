package classes_practise;
import java.io.*;

//实例变量的应用

public class Employee {
    // 这个实例变量对子类可见
    public String name;
    // 私有变量，仅在该类可见
    private double salary;
    //salary_static 是静态的私有变量
    private static double salary_static;
    // DEPARTMENT是一个常量
    public static final String DEPARTMENT = "开发人员";

    //在构造器中对name赋值
    public Employee (String empName){
        name = empName;
    }
    //设定salary的值
    public void setSalary(double empSal){
        salary = empSal;
        salary_static = empSal*2;
    }

    private void setSalary_private(){
        salary_static-=1;
    }
    //
    public double getSalary_static(){
        return salary_static;
    }
    // 打印信息
    public void printEmp(){
        System.out.println("名字 : " + name );
        System.out.println("薪水 : " + salary);
    }
}

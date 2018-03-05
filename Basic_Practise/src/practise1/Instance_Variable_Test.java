package practise1;
import classes_practise.Employee;

public class Instance_Variable_Test {

    public static void main(String[] args){
        Employee empOne = new Employee("RUNOOB");
        empOne.setSalary(1000);
        empOne.printEmp();
//        外部变量无法访问private变量，也无法通过类访问，只能通过类的方法返回
//        System.out.println(empOne.salary_static);
//        System.out.println(Employee.salary_static);
//        实例变量在实例化（生成对象）之后才会被分配空间，因此只有静态变量才能通过类名访问
//        System.out.println(Employee.name);
        System.out.println("private static variable from function："+empOne.getSalary_static());
        System.out.println("public static variable from Class: "+Employee.DEPARTMENT);
        System.out.println("public static variable from Instance: "+empOne.DEPARTMENT);
    }
}

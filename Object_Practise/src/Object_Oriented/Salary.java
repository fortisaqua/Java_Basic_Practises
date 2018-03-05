package Object_Oriented;

public class Salary extends Employee{

//    抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类
    public abstract class Employee_Backup extends Employee{
//        子抽象类继承父抽象类，必须显性调用父抽象类的显性构造器
        public Employee_Backup(String name, String address, int number)
        {
            super(name, address, number);
            System.out.println("Employee_Backup 构造函数");
        }
    }

    private double salary; // 全年工资
    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        System.out.println("Salary 构造函数");
        try{
        setSalary(salary);
        } catch (InsufficientFundsException e){
            e.getMessage();
        }
    }
    public void mailCheck() {
        System.out.println("Salary 类的 mailCheck 方法 ");
        System.out.println("邮寄支票给：" + getName()
                + " ，工资为：" + salary);
    }
    public double getSalary() {
        return salary;
    }
    protected void setSalary(double newSalary) throws InsufficientFundsException {
        if(newSalary >= 0.0) {
            salary = newSalary;
        }
        else
        {
            throw new InsufficientFundsException(salary);
        }
    }
    public double computePay() {
        System.out.println("计算工资，付给：" + getName());
        return salary/52;
    }

//    子类中实现抽象方法的方法不能用static修饰
//    public static double addNumber_2(double a ,double b,double c){
    public double addNumber_2(double a ,double b,double c){
        return a+b+c;
    };
}

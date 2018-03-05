package practise1;
import java.io.*;

public class Exception_Test {

    //自定义异常类，继承Exception类
    public static class InsufficientFundsException extends Exception {
        //此处的amount用来储存当出现异常（取出钱多于余额时）所缺乏的钱
        private double amount;

        public InsufficientFundsException(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }

    //此类模拟银行账户
    public static class CheckingAccount
    {
        //balance为余额，number为卡号
        private double balance;
        private int number;
        public CheckingAccount(int number)
        {
            this.number = number;
        }
        //方法：存钱
        public void deposit(double amount)
        {
            balance += amount;
        }
        //方法：取钱
        public void withdraw(double amount) throws
                InsufficientFundsException
        {
            if(amount <= balance)
            {
                balance -= amount;
            }
            else
            {
                double needs = amount - balance;
//                用throw关键词抛主动抛出这个异常，定义中的throws InsufficientFundsException不能去掉
//                类似于声明这个发方法会抛出这些问题，主动抛出的时候需要new一个对应的异常类型
                throw new InsufficientFundsException(needs);
            }
        }
        //方法：返回余额
        public double getBalance()
        {
            return balance;
        }
        //方法：返回卡号
        public int getNumber()
        {
            return number;
        }
    }

//    被调用者抛出一个新创建的异常类，调用者用try——catch机制捕获这个异常
    public static void main(String[] args) {
        CheckingAccount c = new CheckingAccount(101);
        System.out.println("Depositing $500...");
        c.deposit(500.00);
        try
        {
            System.out.println("\nWithdrawing $100...");
            c.withdraw(100.00);
            System.out.println("\nWithdrawing $600...");
            c.withdraw(600.00);
        }catch(InsufficientFundsException e)
        {
            System.out.println("Sorry, but you are short $"
                    + e.getAmount());
            e.printStackTrace();
        }
    }

}

package practise1;
import java.util.Scanner;

public class ScannerDemo3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double sum = 0;
        int m = 0;
//      不同的hasNext...方法可以起到不同的作用，直接的hasNext有无法退出的风险
//      以next...的方法可以定义返回特定类型的变量，因此输入的整数也成了double
        while (scan.hasNextDouble()) {
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }

        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
        scan.close();
    }
}

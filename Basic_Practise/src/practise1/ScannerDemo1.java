package practise1;
import java.util.Scanner;

public class ScannerDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串，以输入中的空格分开各个字符串，但是用while(scan.hasNext())结构退出不了
        // 得自己设置退出条件
        System.out.println("next方式接收：");
        // 判断是否还有输入
        while (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
            if(str1.equals("end"))
            {
                break;
            }
        }
        scan.close();
    }
}

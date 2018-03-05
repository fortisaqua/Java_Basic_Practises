package practise1;
import java.util.*;

//计算一段语句执行时间的方法和线程睡眠的方法，计时单位为毫秒

public class Time_Diff_Test {
    public static void main(String args[]) {
        try {
            long start = System.currentTimeMillis( );
            System.out.println(new Date( ) + "\n");
            Thread.sleep(5*60*10);
            System.out.println(new Date( ) + "\n");
            long end = System.currentTimeMillis( );
            long diff = end - start;
            System.out.println("Difference is : " + diff+" ms");
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
    }
}

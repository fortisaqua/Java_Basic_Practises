package classes_practise;
import java.text.SimpleDateFormat;
import java.util.*;

public class data_types {

    public data_types()
    {
        System.out.println("data_type class is initialized");
    }

    public void Print_Types(){
        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);
        System.out.println(Character.toTitleCase('a'));
        System.out.println(Character.toUpperCase('b'));
        System.out.println(Character.toTitleCase('A'));
    }

    public void Change_Types(){
        char c1='a';//定义一个char类型
        int i1 = c1;//char自动类型转换为int
        System.out.println("char自动类型转换为int后的值等于"+i1);
        char c2 = 'A';//定义一个char类型
        int i2 = c2+1;//char 类型和 int 类型计算
        System.out.println("char类型和int计算后的值等于"+i2);
//        long数字后加一个大写的L，否则直接写的数字默认是int型
        long l1 = 4223372036854775807L;
        System.out.println("直接赋值的long类型："+l1);
        int i3 = 123;
        byte b3 = (byte)i3;//强制类型转换为byte
        System.out.format("i3的16进制表示: %x\n",i3);
        System.out.println("int强制类型转换为byte后的值等于"+b3);
        System.out.println("byte 型的类为 java.lang.String");
        System.out.println("int类转换成String "+String.valueOf(i3));
        System.out.println("int类转换成double (使用Double.parseDouble方法时要先把输入的类型转换到String) \n"+Double.parseDouble(String.valueOf(i3)));

    }

    public void Check_Date(){
        java.util.Date date = new java.util.Date();
//如果希望得到YYYYMMDD的格式
        SimpleDateFormat sy1=new SimpleDateFormat("yyyyMMDD");
        String dateFormat=sy1.format(date);
//如果希望分开得到年，月，日
        SimpleDateFormat sy=new SimpleDateFormat("yyyy");
        SimpleDateFormat sm=new SimpleDateFormat("MM");
        SimpleDateFormat sd=new SimpleDateFormat("dd");
        String syear=sy.format(date);
        String smon=sm.format(date);
        String sday=sd.format(date);
        System.out.println("时间的格式化输出");
        System.out.println("全部 ： \"yyyyMMDD\" : "+dateFormat);
        System.out.println("年 ： \"yyy\" : "+syear);
        System.out.println("月份 ：\"MM\" : "+smon);
        System.out.println("日期 ： \"dd\" : "+sday);
    }
}

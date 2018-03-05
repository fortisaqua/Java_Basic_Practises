package practise1;


public class Math_Test {

    private static void test(double num) {
        System.out.println("Math.floor(" + num + ")=" + Math.floor(num));
        System.out.println("Math.round(" + num + ")=" + Math.round(num));
        System.out.println("Math.ceil(" + num + ")=" + Math.ceil(num));
    }
    public static void main (String []args)
    {
//        Math类默认被加载，不用import
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI/3));
        System.out.println("1的反正切值，转到角度值： " + Math.toDegrees(Math.atan(1)));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI/2));
        System.out.println(Math.PI);

//        double[] nums = { 1.4, 1.5, 1.6, -1.4, -1.5, -1.6 };
//        for (double num : nums) {
//            test(num);
//        }

        /*
         Integer i1 = 128;  // 装箱，相当于 Integer.valueOf(128);
         int t = i1; //相当于 i1.intValue() 拆箱
         System.out.println(t);
         */

        /*
         对于–128到127（默认是127）之间的值,被装箱后，会被放在内存里进行重用
         但是如果超出了这个值,系统会重新new 一个对象
         */
        Integer i1 = 200;
        Integer i2 = 200;
        int i3 = 300;
        int i4 = 300;

        /*
         注意 == 与 equals的区别
         == 它比较的是对象的地址
         equals 比较的是对象的内容
         */

        System.out.println(i1==i2);
        System.out.println(i1.equals(i2));
        System.out.println(i3==i4);
//        System.out.println(i3.equals(i2));

        double d = 100.675;
        double e = 100.500;
        double f = 100.200;

        System.out.println("Math.rint("+d+") = "+Math.rint(d));
        System.out.println("Math.rint("+e+") = "+Math.rint(e));
        System.out.println("Math.rint("+f+") = "+Math.rint(f));

        Integer x =Integer.valueOf(9);
        Double c = Double.valueOf(5);
        Float a = Float.valueOf("80");

        Integer b = Integer.valueOf("444",16);   // 将字符串中的数字理解为 16 进制 ， 返回的是10进制
        Integer m = Integer.valueOf("444");

        System.out.println("Integer.valueOf(9) = "+x);
        System.out.println("Double.valueOf(5) = "+c);
        System.out.println("Float.valueOf(\"80\") = "+a);
        System.out.println("Integer.valueOf(\"444\",16) = "+b);
        System.out.println("Integer.valueOf(\"444\") = "+m);
    }
}

package practise1;

class Vehicle_2{}

class Small_Car_2 extends Vehicle_2{}

public class Byte_Operation_Test{
    public static void main(String[] args) {
        int a = 60; /* 60 = 0011 1100 */
        int b = 13; /* 13 = 0000 1101 */
        int d = -1;
        int c = 0;
        c = a & b;       /* 12 = 0000 1100 */
        System.out.println("a & b = " + c );

        c = a | b;       /* 61 = 0011 1101 */
        System.out.println("a | b = " + c );

        c = a ^ b;       /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c );

        c = ~a;          /*-61 = 1100 0011 */
        System.out.println("~a = " + c );

        c = a << 2;     /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c );

        c = a >> 2;     /* 15 = 1111 */
        System.out.println("a >> 2  = " + c );
// >>> 按位右移补零操作符。左操作数的值按右操作数指定的位数右移，不带符号的右移
        c = a >>> 2;     /* 15 = 0000 1111 */
        System.out.println("a >>> 2 = " + c );

        c = b >>> 1;
        System.out.println("b >>> 1 = "+c); /* 6 = 0000 0110 */

        c = b >>> 2;
        System.out.println("b >>> 2 = "+c); /* 3 = 0000 0011 */

        c = d >>> 3;
        System.out.println("d >>> 3 = "+c); /* 1 = 0000 0001 */

        Byte_Operation_Test temp1 = new Byte_Operation_Test();
        temp1.instance_test();
    }
    public void instance_test()
    {
        Vehicle_2 a = new Small_Car_2();
        boolean b = a instanceof Small_Car_2;
        boolean c = a instanceof Vehicle_2;
        System.out.println(b);
        System.out.println(c);
    }
}

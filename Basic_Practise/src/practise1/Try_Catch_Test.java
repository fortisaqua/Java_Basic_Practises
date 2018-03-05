package practise1;
import java.io.*;

public class Try_Catch_Test {

//    throws关键字的作用范围只在函数中，如果一个函数调用一个需要处理异常的函数
//    这个调用者函数也需要有相应的异常处理机制，例如下面，在没有try——catch
//    机制的情况下，调用try_catch_multi_demo_1函数的main函数如果没有在后面加上
//    throws IOException ，就会有"unhandled ....."报错，各层次的调用者都需要
//    和最终执行者throws的异常保持一致，除非被调用者有throws声明，调用者中有try——catch
//    机制捕捉相同的异常类

//    throws 机制不会保证程序继续运行下去，报错了之后就会停止程序
//    try——catch机制下会捕捉异常，程序照常继续

    public static void main(String args[]) throws IOException {
        try {
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown  :" + e);
        }
        System.out.println("Out of the block");
        try_catch_multi_demo("a.txt");
        try_catch_multi_demo("b.txt");
        try_catch_multi_demo("c.txt");
        System.out.println("back 1");
//        array_Exception_test();
        mid_mtehod("a.txt");
        mid_mtehod("b.txt");
        mid_mtehod("c.txt");
        System.out.println("back 2");
//        try_catch_multi_demo_1("a.txt");
//        try_catch_multi_demo_1("b.txt");
//        try_catch_multi_demo_1("c.txt");
//        System.out.println("back 2");
    }

    public static int mid_mtehod(String filename) {
        try {
            return try_catch_multi_demo_1(filename);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return 1;
    }

//   多层try——catch机制，加上最后的finally块，finally块中的内容无论如何都会被执行

    public static int try_catch_multi_demo(String filename) {
        try {
            FileInputStream file = new FileInputStream(filename);
            byte x = (byte) file.read();
            byte y = (byte) file.read();
            byte z = (byte) file.read();
        } catch (StringIndexOutOfBoundsException i) {
            i.printStackTrace();
            System.out.println("exception 1 caught and programme ended");
            return -1;
        } catch (SecurityException j)
        {
            j.printStackTrace();
            System.out.println("exception 2 caught and programme ended");
            return -2;
        } catch (RuntimeException k)
        {
            k.printStackTrace();
            System.out.println("exception 3 caught and programme ended");
            return -3;
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
            System.out.println("exception 4 caught and programme ended");
            return -4;
        }
        finally {
            System.out.println("finally block");
        }
        return 1;
    }
    public static int try_catch_multi_demo_1(String filename) throws IOException {

            FileInputStream file = new FileInputStream(filename);
            byte x = (byte) file.read();
            byte y = (byte) file.read();
            byte z = (byte) file.read();
        return 1;
    }

//    直接输出异常还是可以的，printStackTrace方法输出的是按照栈层次显示的调用断点
    public static void array_Exception_test(){
        int a[] = new int[2];
        try{
            System.out.println("Access element three :" + a[3]);
        }catch(ArrayIndexOutOfBoundsException e){

            System.out.println("Exception thrown  :" + e);
        }
        finally{
            a[0] = 6;
            System.out.println("First element value: " +a[0]);
            System.out.println("The finally statement is executed");
        }
    }
}

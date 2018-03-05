import java.util.*;
import java.text.*;

//创建线程最简便的方法：创建一个实现Runnable接口的类

class RunnableDemo implements Runnable{
    private Thread t;
    private String threadName;
    protected SimpleDateFormat sd;
    RunnableDemo(String name , SimpleDateFormat df){
        this.threadName = name;
        this.sd = df;
        System.out.println("Creating "+threadName);
    }
/**
 * 简单的一个Date对象只能保存一个时间，所以在设计好日期输出格式后，
 * 新建一个Date对象作为局部变量，用完即删的那种*/
    public void run() {
//        将此代码块对象级上锁，当多个线程调用此类的同一个对象时，此代码块的执行过程将不会被打断（即只会锁定给一个线程）
//        未被synchronized(this) 标记的部分依旧可以并发访问
        synchronized (this) {
            System.out.println("Start running thread " + threadName + " at " + sd.format(new Date()));
            try {
                for (int i = 10; i > 0; i--) {
                    System.out.println("Round " + i + " for thread" + threadName + " at " + sd.format(new Date()));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted" + " at " + sd.format(new Date()));
            }
        }
            System.out.println("Thread " + threadName + " exiting" + " at " + sd.format(new Date()));

    }

    public void start ()
    {
//        synchronized 关键字还可以对特定对象上锁，原理与方法块一致，此方法可以作用在程序的一部分上
//        即程序执行到 synchronized() 关键字修饰的大括号内部的部分时，对特定对象上锁
        synchronized (sd){
        System.out.println("Starting " +  threadName );
        }
        if (t == null) {
            t = new Thread (this, threadName);
//            线程创建后调用start进入就绪状态
            t.start ();
    }
    }
}

public class TestThread {

    public static void main(String[] args){
        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");

        RunnableDemo R1 = new RunnableDemo("Thread-1",df);
        R1.start();

        RunnableDemo R2 = new RunnableDemo("Thread-2",df);
        R2.start();
    }
}

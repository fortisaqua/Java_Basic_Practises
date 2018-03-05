import java.util.concurrent.*;

/*
 * callable 接口中的泛型类型指的是“返回类型”
 * callable 接口实现的类使用call（）方法启动线程的执行程序
 * FutureTas的作用：包装Callabe实现类的实例，保存该实例的返回值
 * 使用 Callable 实现实例以及使用 FutureTask 封装，可以实现
 * 结构化线程的执行结果，以对象的形式返回
 */

public class CallableThreadTest implements Callable<Integer> {
    public static void main(String[] args)
    {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for(int i = 0;i < 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i==20)
            {
                new Thread(ft,"有返回值的线程").start();
            }
        }
        try
        {
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }

    }
//    synchronized 关键字可以修饰一整个方法，用法与访问权限关键字相同
    @Override
    public synchronized Integer call() throws Exception
    {
        int i = 0;
        for(;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return i+9;
    }
}

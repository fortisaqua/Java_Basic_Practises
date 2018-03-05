import java.text.SimpleDateFormat;
import java.util.Date;

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    protected SimpleDateFormat sd;
    ThreadDemo(String name , SimpleDateFormat df){
        this.threadName = name;
        this.sd = df;
        System.out.println("Creating "+threadName);
    }

//    线程运行内容本体
    public void run(){
        System.out.println("Start running thread "+threadName+" at "+sd.format(new Date()));
        try{
            for(int i=5;i>0;i--){
                System.out.println("Round "+i+" for thread"+threadName+" at "+sd.format(new Date()));
                Thread.sleep(2000);
            }
        } catch (InterruptedException e){
            System.out.println("Thread "+threadName+" interrupted"+" at "+sd.format(new Date()));
        }
        System.out.println("Thread "+threadName+" exiting"+" at "+sd.format(new Date()));
    }

//    线程创建后到就绪前作的操作
    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
//            线程创建后调用start进入就绪状态
            t.start ();
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args){
        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
        System.out.println("Class extends Thread class: ");
        ThreadDemo R1 = new ThreadDemo("Thread-1",df);
        R1.start();

        ThreadDemo R2 = new ThreadDemo("Thread-2",df);
        R2.start();
    }
}

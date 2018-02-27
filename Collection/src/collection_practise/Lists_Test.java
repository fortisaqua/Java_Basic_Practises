package collection_practise;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

//ArrayList 和 LinkedList 的区别：就是数组和链表的区别，本质上都是对象集合的实现

public class Lists_Test {
    public static final int N=50000;
    public static List values;

    static{
        Integer vals[]=new Integer[N];
        Random r=new Random();
        for(int i=0,currval=0;i<N;i++){
            vals[i]=new Integer(currval);
            currval+=r.nextInt(100)+1;
        }
        values=Arrays.asList(vals);
    }
    static long timeList_search(List lst){
        long start=System.currentTimeMillis();
        for(int i=0;i<N;i++){
            int index=Collections.binarySearch(lst, values.get(i));
            if(index!=i)
                System.out.println("***错误***");
        }
        return System.currentTimeMillis()-start;
    }

    static long timeList_insert(List list){
        long start=System.currentTimeMillis();
        Object o = new Object();
        for(int i=0;i<N;i++)
            list.add(0, o);
        return System.currentTimeMillis()-start;
    }

    public static void main(String args[]){
        System.out.println("ArrayList搜索消耗时间："+timeList_search(new ArrayList(values)));
        System.out.println("LinkedList搜索消耗时间："+timeList_search(new LinkedList(values)));

        System.out.println("ArrayList插入消耗时间："+timeList_insert(new ArrayList()));
        System.out.println("LinkedList插入消耗时间："+timeList_insert(new LinkedList()));
    }
}

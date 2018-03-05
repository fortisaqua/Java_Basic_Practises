package data_structure_practise;

import java.util.*;

//HashMap是Hashtable的轻量级实现（非线程安全的实现），他们都完成了Map接口。
// 主要的区别有：线程安全性，同步(synchronization)，以及速度

/* 1、Hashtable 继承自 Dictiionary 而 HashMap继承自AbstractMap
*  2、HashMap允许将null作为一个entry的key或者value，而Hashtable不允许
 * 3、Hashtable是线程安全的，多个线程可以共享一个Hashtable；而如果没有正确的同步的话，多个线程是不能共享HashMap的。
 * 4、HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的
 * （fail-fast策略：如果在使用迭代器的过程中有其他线程修改了map，那么将抛出ConcurrentModificationException）
 * 5、由于HashMap非线程安全，在只有一个线程访问的情况下，效率要高于HashTable
 * 6、HashMap把Hashtable的contains方法去掉了，改成containsvalue和containsKey。因为contains方法容易让人引起误解
 * 7、Hashtable中hash数组默认大小是11，增加的方式是 old*2+1。HashMap中hash数组的默认大小是16，而且一定是2的指数
 * 8、两者通过hash值散列到hash表的算法不一样，HashTbale是古老的除留余数法，直接使用hashcode
    ，HashMap的hash算法是求得了hashcode后继续做了一系列操作，更加高效，取得的位置更加分散，偶数，奇数保证了都会分散到。
 * */

public class Map_Test {

    public static void main(String[] args) {
        Map m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");
        System.out.println();
        System.out.println(" Map Elements");
        System.out.print("\t" + m1);
    }

}

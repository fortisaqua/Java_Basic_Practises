package collection_practise;

import java.util.*;

// Set 接口实例存储的是无序的，不重复的数据。
// List 接口实例存储的是有序的，可以重复的元素。
// 以下例子可以看出：List接口的实例ArrayList遍历是以有序的方式遍历（String的大小顺序从小到大）


public class ArrayList_Test {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        Set<String> set1 = new TreeSet<String>();
        Set<String> set2 = new HashSet<String>();
        list.add("Hello");
        list.add("World");
        list.add("World");
        list.add("HAHAH");
        list.add("HAHAHAHA");

        for (String str : list) {            //也可以改写for(int i=0;i<list.size();i++)这种形式
            System.out.println(str);
            set1.add(str);
        }
        System.out.write('\n');
        //第二种遍历，把链表变为数组相关的内容进行遍历
        String[] strArray=new String[list.size()];
        list.toArray(strArray);
        for(int i=0;i<strArray.length;i++) //这里也可以改写为  foreach(String str:strArray)这种形式
        {
            System.out.println(strArray[i]);
            set2.add(strArray[i]);
        }
        System.out.write('\n');
        //第三种遍历 使用迭代器进行相关遍历

        Iterator<String> ite=list.iterator();
        while(ite.hasNext())//判断下一个元素之后有值
        {
            System.out.println(ite.next());
        }
        System.out.write('\n');
        System.out.println("Elements from set1");
        if(!set1.isEmpty()){
            Iterator<String> itr = set1.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next());
            }
        }
        System.out.write('\n');
        System.out.println("Elements from set2");
        if(!set1.isEmpty()){
            Iterator<String> itr = set2.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next());
            }
        }
    }
}

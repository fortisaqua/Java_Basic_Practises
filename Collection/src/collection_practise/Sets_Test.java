package collection_practise;

import java.util.*;

/* 所有Set的实例都是不重复地保存
HashSet是使用散列表进行存储，元素无序，元素允许为null。
TreeSet是使用树结构来进行存储，元素按字符串顺序排序存储，元素不允许为null。*/

public class Sets_Test {

    public static void main(String[] args){
        ShowHashSet();
        ShowTreeSet();
    }

    public static void ShowHashSet() {
        System.out.println("\n============hash set============\n");
        Set<String> sets = new HashSet<String>();
        sets.add("first");
        sets.add("second");
        sets.add("second");
        sets.add("third");
        sets.add("forth");
        System.out.println(sets);
        Iterator<String> i = sets.iterator();
        while (i.hasNext()) {
            String value = i.next();
            System.out.println(value);
        }
    }

    public static void ShowTreeSet() {
        System.out.println("\n============tree set============\n");
        Set<String> sets = new TreeSet<String>();
        sets.add("first");
        sets.add("second");
        sets.add("third");
        sets.add("third");
        sets.add("forth");
        System.out.println(sets);
        Iterator<String> i = sets.iterator();
        while (i.hasNext()) {
            String value = i.next();
            System.out.println(value);
        }
    }
}
package collection_practise;

import java.util.*;

public class Add_Set_Test {
    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<>(2);
            System.out.println("list大小为：" + list.size());
            list.add("12");
            System.out.println("list大小为：" + list.size());
//            执行以下语句会报错，因为，对于ArrayList，虽然开出了一个初始长度的对象数组，
//            但是真正在数组中添加的元素数量和初始长度不是一回事，在加入了1个元素的，长度为2的ArrayList中
//            直接设置（修改）第二个位置的元素是错误的，因为第二个位置并没有真正的放入元素
////            list.set(1, "sss");

//            一般情况下，对于逐个添加元素的ArrayList，有没有定义capacity没有关系，
//            当需要插入大量元素时，在插入前可以调用ensureCapacity方法来增加ArrayList的容量以提高插入效率
            list.add(1, "放在下标为1的位置_1");
            list.add("22");
            System.out.println("list大小为：" + list.size());
            System.out.println(list.toString());
            list.add(1, "放在下标为1的位置_2");
            System.out.println("list大小为：" + list.size());
            System.out.println(list.toString());
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}

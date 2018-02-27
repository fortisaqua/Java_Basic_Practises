package generics_pra;

//要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
//extends关键字在泛型类型参数定义中不再表示“继承”，用以声明右边的上界（可以是接口，也可以是类）
abstract class Funs_Demo{
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }

//    通过自定义一个空的继承自其他接口的接口来自定义类型参数的上界
    private static interface Inter1<T> extends Comparable<T>{

    }

    public static <T extends Comparable<T>> T Bigger(T input1,T input2){
        if(input1.compareTo(input2)>0)
        {
            return input1;
        }
        else{
            return input2;
        }
    }
}

public class Limited_Generics_Demo extends Funs_Demo{
//    静态方法不会被重写，函数调用规则和虚拟函数的原则一样，存在看引用，实现看实例
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        System.out.println("Data type is : "+max.getClass().getName());
//        System.out.printf("Maximum value is : %s",max);
        return max; // 返回最大对象
    }

    public static void main(String[] args){
        System.out.printf( " %d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ));

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );

        System.out.printf( " %d, %d  中最大的数为 %d\n\n",
                3, 4, Bigger(3,4));

        System.out.printf( "%.1f, %.1f  中最大的数为 %.1f\n\n",
                6.6, 8.8, Bigger( 6.6, 8.8) );

        System.out.printf( "%s, %s  中最大的数为 %s\n","pear",
                "apple",  Bigger( "pear", "apple" ) );
    }
}

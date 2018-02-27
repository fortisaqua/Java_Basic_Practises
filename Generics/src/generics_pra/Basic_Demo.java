package generics_pra;

public class Basic_Demo {
//    类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符
    public static <E> E Demo1(E[] inputArray ){
        for (E element:inputArray) {
            System.out.printf("%s ",element);
        }
        System.out.println();
        return inputArray[0];
    }

    public static void main( String args[] )
    {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        Integer demo_int = Demo1( intArray  ); // 传递一个整型数组
        System.out.println( "返回整形元素："+demo_int );

        System.out.println( "\n双精度型数组元素为:" );
        Double demo_double =  Demo1( doubleArray ); // 传递一个双精度型数组
        System.out.println( "返回双精度型元素："+demo_double );

        System.out.println( "\n字符型数组元素为:" );
        Character demo_character = Demo1( charArray ); // 传递一个字符型数组
        System.out.println( "返回字符型元素："+demo_character );
    }
}

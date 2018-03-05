package data_structure_practise;
import java.util.BitSet;

// BitSet中的一个元素代表一位，每一位都有：true或者false
// 初始化后全是false，set函数的作用是对特定位置设置成true
// 直接输出一个BitSet对象，得到的是一个值为true的位置集合
// 两个BitSet对象所做的位操作直接作用在每一位的布尔值上

public class BitSet_Test {

    public static void main(String args[]) {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);

        // set some bits
        for(int i=0; i<25; i++) {
            if((i%2) == 0) bits1.set(i);
            if((i%5) != 0) bits2.set(i);
        }
        System.out.println("size of bits1: ");
        System.out.println(bits1.size());
        System.out.println("size of bits2: ");
        System.out.println(bits2.size());
        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println("\nInitial pattern in bits2: ");
        System.out.println(bits2);

        bits1.clear(2);
        System.out.println("\nbits1.clear(2)");
        System.out.println(bits1);

        bits2.xor(bits1);
        System.out.println("\nbits2 XOR bits1: ");
        System.out.println(bits2);

        // AND bits
        bits2.and(bits1);
        System.out.println("\nbits2 AND bits1: ");
        System.out.println(bits2);
        bits2.set(0);
        System.out.println("\nbits2.set(0): ");
        System.out.println(bits2);

        // OR bits
        bits2.or(bits1);
        System.out.println("\nbits2 OR bits1: ");
        System.out.println(bits2);


        // XOR bits
        bits2.xor(bits1);
        System.out.println("\nbits2 XOR bits1: ");
        System.out.println(bits2);
    }

}

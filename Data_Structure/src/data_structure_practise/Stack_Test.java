package data_structure_practise;

import java.util.*;

public class Stack_Test {

    static void showpush(Stack<Integer> st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
        System.out.println("top of stack : "+st.peek());
        System.out.write('\n');
    }

    static void showpop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
        if(!st.empty()){
            System.out.println("top of stack : "+st.peek());
        }
        System.out.write('\n');
    }

    public static void main(String args[]) {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
//        stack 中，栈顶的元素位置下标为1，即以1为基数，以下的输出中，栈顶位置的99输出位置1
//        栈底位置的42输出位置3，不存在的元素40输出位置-1
        System.out.println("location of element "+99+" is "+st.search(99));
        System.out.println("location of element "+42+" is "+st.search(42));
        System.out.println("location of element "+40+" is "+st.search(40));
        System.out.write('\n');
        showpop(st);
        showpop(st);
        showpop(st);
        try {
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }

}

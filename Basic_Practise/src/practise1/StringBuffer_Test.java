package practise1;

public class StringBuffer_Test {
    public static void main(String args[]){
        StringBuffer sBuffer = new StringBuffer("菜鸟教程官网：");
        sBuffer.append("www");
        sBuffer.append(".runoob");
        sBuffer.append(".com");
        System.out.println(sBuffer);
        System.out.println(sBuffer.insert(3,123));
        System.out.println(sBuffer.reverse());
        System.out.println(sBuffer.delete(3,6));
        //调用reverse操作后sBuffer本身保存的字符串是被改变的，如果需要恢复，需要再次调用reverse
        sBuffer.reverse();
        System.out.println(sBuffer.replace(sBuffer.indexOf("www"),sBuffer.lastIndexOf("."),"XMU.edu"));
    }
}

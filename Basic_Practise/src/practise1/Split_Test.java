package practise1;

//split() 方法根据匹配给定的正则表达式来拆分字符串

public class Split_Test {
    public static void main(String args[]) {
        String str = new String("Welcome-to-Runoob");

        System.out.println("- 分隔符返回值 :" );
        for (String retval: str.split("-")){
            System.out.println(retval);
        }

        System.out.println("");
        System.out.println("- 分隔符设置分割份数返回值 :" );
        for (String retval: str.split("-", 2)){
            System.out.println(retval);
        }

// . 、 | 和 * 等转义字符，必须得加 \\
        System.out.println("");
        String str2 = new String("www.runoob.com");
        System.out.println("转义字符返回值 :" );
        for (String retval: str2.split("\\.", 3)){
            System.out.println(retval);
        }

//多个分隔符，可以用 | 作为连字符
        System.out.println("");
        String str3 = new String("acount=? and uu =? or n=?");
        System.out.println("多个分隔符返回值 :" );
        for (String retval: str3.split("and|or")){
            System.out.println(retval);
        }
    }
}

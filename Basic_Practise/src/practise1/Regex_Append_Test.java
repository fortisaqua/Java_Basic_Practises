package practise1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Append_Test {
    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoob";
    private static String REPLACE = "-";
    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer("sb");
        while(m.find()){
            m.appendReplacement(sb,REPLACE);
        }
//        把m的内容加到字符串sb到后面
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}

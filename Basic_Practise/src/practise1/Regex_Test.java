package practise1;
import java.util.regex.*;

public class Regex_Test {
    public static void main(String args[]){
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);

        // 按指定模式在字符串查找
        /*
        * 这里就有一系列组，((\D*)(\d+))(.*)的各个组为：
        * ((\D*)(\d+))(.*)
        * (\D*)(\d+)
        * (.*)
        * (\D*)
        * (\d+)
        * 即可以根据各个分组，来捕获字符串中符合任何一个组的子串
        * */
        String line = "This order was placed for QT3000! OK?";
        pattern = "((\\D*)(\\d+))(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            for(int i=0; i<=m.groupCount();i++)
                System.out.println("Found value: " + m.group(i) );
        } else {
            System.out.println("NO MATCH");
        }

    }
}

package practise1;
import java.io.*;
import java.util.regex.*;
import java.text.*;

//从 BufferedReader 对象读取一个字符要使用 read() 方法
//每次调用 read() 方法，它从输入流读取一个字符并把该字符作为整数值返回。
// 当流结束的时候返回 -1。该方法抛出 IOException

public class BRRead {
    private static String REGEX = "([wW]indows (\\s*)(?=98|vista|2000|7|8|8.1|10))(\\s*)(\\d*)";
    private static String REPLACE = "-";
    public static void main(String args[]) throws IOException
    {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
//        do {
//            c = (char) br.read();
//            System.out.println(Character.toUpperCase(c));
//        } while(c != 'q');
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        Pattern p = Pattern.compile(REGEX);
        do {
            str = br.readLine();
            Matcher m = p.matcher(str);
            if (m.find())
            {
                for(int i=0; i<=m.groupCount();i++)
                    System.out.println("Found value: " + m.group(i) );
                String temp_ret = m.replaceAll("linux");
                System.out.println(temp_ret);
            }
            else if(!str.equals("end")&&!str.equals("End"))
            {
                System.out.println("no match in "+str);
            }
        } while(!str.equals("end")&&!str.equals("End"));
        System.out.println("programme ");
//      write方法只能输出单个字符或者字符数组，不能输出字符串
        byte[] endline = {'e','n','d','\n'};
        System.out.write(endline);
    }
}

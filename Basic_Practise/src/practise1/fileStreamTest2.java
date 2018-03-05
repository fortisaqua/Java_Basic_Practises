package practise1;

import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//使用三层结构 输入输出流读写器（文件输入输出流（文件），编码方法），这个用的是逐个character读写
//或者另一种三层结构 （带缓冲的读写器（文件读写器（文件））） ，这个可以逐行读写
//这里读写流的read和write的读写单位，是char，16位，
//是可以存放中文编码的，只要写入的编码方式和读取的解码方式一致就好

public class fileStreamTest2 {
    public static void main(String[] args) throws IOException {

        File f = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(f);
        // 构建FileOutputStream对象,文件不存在会自动新建

        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

        BufferedWriter buf_writer = new BufferedWriter(new FileWriter(f));
        //与下面的BufferedReader同理，可以缓冲的写入器

        writer.append("中文输入");
        // 写入到缓冲区

        writer.append("\r\n");
        //换行，\r的作用是回到一行的最开始，\n的作用是走到下一行

        writer.append("English");
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

        writer.append("\r\n");

        writer.append("1234.4567");

        writer.close();
        //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

        fop.close();
        // 关闭输出流,释放系统资源

        FileInputStream fip = new FileInputStream(f);
        // 构建FileInputStream对象

        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        // 构建InputStreamReader对象,编码与写入相同

        BufferedReader buf_reader = new BufferedReader(new FileReader(f));
        //用于包装reader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有

        System.out.println("文件中可读到的字节数："+fip.available()+" 来自文件输入流");

        Pattern p = Pattern.compile("\\d*\\.\\d*");
        StringBuffer sb = new StringBuffer();
//      只要文件里面还有可读的内容这个ready返回的就是true

        while (reader.ready()) {
            char temp = (char) reader.read();

            sb.append(temp);
//            System.out.write(temp);
//            System.out.write(' ');
            // 转成char加到StringBuffer对象中
        }
//        System.out.println(sb.toString());
        String total_string = new String(sb);
//        按字节全部读入后，根据分割规则分割字符串并且判断能否被转化为浮点型数字，如果可以则转化后输出
        String[] sub_strings = total_string.split("\r\n");
        System.out.println("number of sub strings : "+sub_strings.length);
        for (String element : sub_strings)
        {
            Matcher m = p.matcher(element);
            if(m.matches())
            {
                System.out.println("got double from String : "+Double.valueOf(element));
            }
        }

//      BufferedReader 才是可以从文件一行一起读读，其他的带stream的都是逐个character或者byte读写
        while(buf_reader.ready())
        {
            String temp = buf_reader.readLine();
            Matcher m = p.matcher(temp);
            System.out.println(temp);
            if(m.matches())
            {
                System.out.println("got double from String : "+Double.valueOf(temp));
            }
        }

        buf_reader.close();
        // 关闭带缓冲的读取流

        reader.close();
        // 关闭读取流

        fip.close();
        // 关闭输入流,释放系统资源

        f=null;
        System.gc();
    }
}

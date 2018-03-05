package practise1;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class fileStreamTest3 {
    public static void file_op_demo_1(String file_name) throws IOException,RuntimeException{
        File f = new File(file_name);
        BufferedWriter buf_writer = new BufferedWriter(new FileWriter(f));

        buf_writer = null;
        System.gc();
        buf_writer.write("中文输入");
        buf_writer.newLine();
        //带缓冲的写入器，也要靠newLine来换行
        buf_writer.write("new line 1 ");
        buf_writer.write("new line 2 ");
        buf_writer.newLine();
        buf_writer.write("192.168000148");
        buf_writer.newLine();
        buf_writer.write("3.1415926");
        buf_writer.write(" asdf ");
        buf_writer.newLine();
        buf_writer.write(" asdf ");
        buf_writer.write("3.1415926");
        buf_writer.close();

        BufferedReader buf_reader = new BufferedReader(new FileReader(f));
        FileInputStream fip = new FileInputStream(f);
        // 构建FileInputStream对象
        System.out.println("文件中可读到的字节数："+fip.available()+" 来自文件输入流");

        Pattern p = Pattern.compile("\\d*\\.\\d*");
//        StringBuffer sb = new StringBuffer();
//      只要文件里面还有可读的内容这个ready返回的就是true

        while(buf_reader.ready())
        {
            String temp = buf_reader.readLine();
            Matcher m = p.matcher(temp);
            System.out.println(temp);
            if(m.matches())
            {
                System.out.println("original string : "+temp);
                System.out.println("got double from String : "+Double.valueOf(temp));
            }
        }
        buf_reader.close();
    }
    public static void main(String[] args){
        try{
            file_op_demo_1("a.txt");
        } catch (IOException e){
            System.out.println("IOException detected !");
            System.out.println("exception type : "+e);
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println("RuntimeException detected !");
            System.out.println("exception type : "+e);
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("finally block");
        }
    }
}

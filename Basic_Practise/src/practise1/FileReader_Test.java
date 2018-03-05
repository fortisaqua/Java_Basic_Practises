package practise1;
import java.io.*;

public class FileReader_Test {
    public static void main(String args[])throws IOException{
        File file = new File("Hello1.txt");
//        文件存在时无法再次创建，因此要先删除，直接new一个文件对象的时候是不管是否存在的
//        这是一个判断存在即删除的例子
        if(file.exists())
        {
            if(file.delete())
                System.out.println("file exists and deleted!");
            else
            {
                System.out.println("file deleted failed");
                System.exit(0);
            }
        }
        // 创建文件
        if(file.createNewFile())
        {
            char[] empty_char = new char[1];
//            System.out.println(empty_char[0]);
            // creates a FileWriter Object
            FileWriter writer = new FileWriter(file);
            // 向文件写入内容
            writer.write("This\n is\n an\n example\n");
            writer.write("1");
            writer.write("\n");
            writer.flush();
            writer.close();
            // 创建 FileReader 对象
            FileReader fr = new FileReader(file);
            char [] a = new char[50];
//            判断文件是否可读，同理判断是否可写，可执行
            if(file.canRead()){
                int hit_count = fr.read(a); // 读取数组中的内容，单位为char
                System.out.println("got "+hit_count+" characters");
                for(char c : a){

//              设置一个初始化的字符，与输出字符串比较，只输出被该写过的字符
                    if(!(empty_char[0] == c))
                        System.out.print(c); // 一个一个打印字符
                }
            }
            fr.close();
        }
        else
        {
            System.out.println("file creation failed!");
        }
    }
}

package practise1;
import java.io.File;
import java.util.*;
import java.text.*;

public class DirList {
    public static double[] dates;
    public static void dir_walk(String dirname){
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println( "Walking Directory of " + dirname);
//            File.list() : 列出当前目录下的所有元素（目录+文件）
            String s[] = f1.list();
            for (int i=0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " is a directory");
                    dir_walk(dirname + "/" + s[i]);
                } else {
//                    System.out.println(s[i] + " is a file");
//                    如果是文件，则读取此文件的最后修改时间
                    File temp_file = new File(dirname + "/" + s[i]);
                    double itemDate = temp_file.lastModified();
                    String itemDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS").format(itemDate);
                    System.out.println(s[i] + " last modified at " + itemDateStr);
                }
            }
        } else if(!f1.exists())
        {
            System.out.println("文件夹不存在");
            if(f1.mkdirs())
            {
                System.out.println("文件夹已创建");
            }
        }
        else {
            System.out.println(dirname + " is not a directory");
        }
        f1 = null;
        System.gc();
    }
    public static void main(String args[]) {
        String dirname = "/Users/wanghongxuan/IdeaProjects/practise1/";
        dir_walk(dirname);
    }
}

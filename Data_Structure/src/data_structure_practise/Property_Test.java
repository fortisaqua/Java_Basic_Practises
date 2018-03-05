package data_structure_practise;

import java.util.*;
import java.io.*;

public class Property_Test {
    public static void main(String[] args){
        try {
            Properties capitals_out = new Properties();

            File f1 = new File("a.txt");
            File f2 = new File("b.txt");
            FileOutputStream fop = new FileOutputStream(f1);
//            输出流一样可以输出，就是会覆盖
            OutputStreamWriter writer = new OutputStreamWriter(fop,"UTF-8");

//            第二个参数的true代表从末尾添加
            BufferedWriter buf_writer = new BufferedWriter(new FileWriter(f2,true));
//
            capitals_out.put("Illinois", "Springfield");
            capitals_out.put("Missouri", "Jefferson City");
            capitals_out.put("Washington", "Olympia");
            capitals_out.put("California", "Sacramento");
            capitals_out.put("Indiana", "Indianapolis");
            capitals_out.put("China", "BeiJing_1");
            capitals_out.store(writer,"property from a FileOutputStream_1");
            capitals_out.store(buf_writer,"property from a FileOutputStream_1");
            capitals_out.remove("China", "BeiJing_1");
            capitals_out.put("China", "BeiJing_2");
            capitals_out.store(writer,"property from a BufferedWriter_2");
            capitals_out.store(buf_writer,"property from a BufferedWriter_2");
//            capitals_out.remove("China", "BeiJing_1");
            capitals_out.put("China", "BeiJing_3");
            capitals_out.store(writer,"property from a BufferedWriter_3");
            capitals_out.store(buf_writer,"property from a BufferedWriter_3");

            InputStreamReader reader = new InputStreamReader(new FileInputStream(f1),"UTF-8");
            BufferedReader buf_reader = new BufferedReader(new FileReader(f2));

            Properties capitals_in = new Properties();
            Properties capitals_in_1 = new Properties();
            capitals_in.load(reader);

//            load方法会加载文件输入流中的所有不重复属性键值对，如果在多个属性列表中存在重复关键字（key）
//            的项，则会选择此关键字（key）最后出现位置所拥有的值（value）

            Set states;
            String str;
            // Show all states and capitals in hashtable.
            states = capitals_in.keySet(); // get set-view of keys
            Iterator itr = states.iterator();
            while (itr.hasNext()) {
                str = (String) itr.next();
                System.out.println("The capital of " +
                        str + " is " + capitals_in.getProperty(str) + ".");
            }
            System.out.println();

            // look for state not in list -- specify default
            str = capitals_in.getProperty("China", "Not Found");
            System.out.println("The capital of China is "
                    + str + ".");
            System.out.write('\n');
            System.out.write('\n');

            capitals_in_1.load(buf_reader);

            // Show all states and capitals in hashtable.
            Set states1 = capitals_in_1.keySet(); // get set-view of keys
            Iterator itr1 = states1.iterator();
            while (itr1.hasNext()) {
                str = (String) itr1.next();
                System.out.println("The capital of " +
                        str + " is " + capitals_in_1.getProperty(str) + ".");
            }
            System.out.println();

            // look for state not in list -- specify default
            str = capitals_in_1.getProperty("China", "Not Found");
            System.out.println("The capital of China is "
                    + str + ".");
            System.out.write('\n');
            System.out.write('\n');

//            Properties类封装好的格式化输出方法
            capitals_in_1.list(System.out);

        } catch (IOException e)
        {
            e.getCause();
            e.getMessage();
        }
    }
}

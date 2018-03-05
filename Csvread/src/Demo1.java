import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.IOException;
import java.util.*;
import java.nio.charset.Charset;

public class Demo1 {
    private static final int LIMIT = 1000;
    public static void readCSV() {
        try {
            // 用来保存数据
            ArrayList<String[]> csvFileList = new ArrayList<String[]>();
            // 定义一个CSV路径
            String csvFilePath = "D:\\BaiduNetdiskDownload\\Santander Product Recommendation\\train_ver2.csv";
            // 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
            CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
            // 跳过表头 如果需要表头的话，这句可以忽略
            reader.readHeaders();
            // 逐行读入除表头的数据

            int limit_counter = 0;
            while (reader.readRecord()&&limit_counter<LIMIT) {
                System.out.println(reader.getRawRecord());
                csvFileList.add(reader.getValues());
                limit_counter+=1;
            }
            reader.close();

            // 遍历读取的CSV文件
            for (int row = 0; row < csvFileList.size(); row++) {
                // 取得第row行第0列的数据
                String cell = csvFileList.get(row)[0];
                System.out.println("------------>"+cell);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        readCSV();
    }
}

package practise1;
import java.io.*;

public class DataOutputStream_Test {
    public static void main(String args[])throws IOException{

        DataInputStream in = new DataInputStream(new FileInputStream("test_data.txt"));
        DataOutputStream out = new DataOutputStream(new  FileOutputStream("test_data.txt"));
        BufferedReader d  = new BufferedReader(new InputStreamReader(in));

        String count;
        while((count = d.readLine()) != null){
            String u = count.toUpperCase();
            System.out.println(u);
            out.writeBytes(u + "  ,");
        }
        d.close();
        out.close();
    }
}

package practise1;
import java.io.*;

//默认的Input/OutputStream 中的 read 和 write 的读写单位，都是byte，输入的时候可以是数字或者字符
//但是在写入文件后，会被翻译成字符

public class fileStreamTest {
    public static void main(String args[]){
        try{
            byte bWrite [] = {81,101,93,80,5};
            OutputStream os = new FileOutputStream("test.txt");
            for(int x=0; x < bWrite.length ; x++){
                System.out.println(bWrite[x]);
                os.write( bWrite[x] ); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            System.out.println("available data count : "+size+" bytes");

            for(int i=0; i< size; i++){
                System.out.print((char)is.read() + "  ");
            }
            is.close();
        }catch(IOException e){
            System.out.print("Exception");
        }
    }
}

import java.io.*;
import java.net.*;

public class GreetingClient {
    public static void main(String[] args){
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try{
            System.out.println("Connecting to the host "+serverName+" , port : "+port);
            Socket client = new Socket(serverName,port);
/**
 * 这种参数列表代表的构造函数：创建一个流套接字并将其连接到指定IP地址和制定端口号
 * */
            System.out.println("Remote host address : "+client.getRemoteSocketAddress());
/**
 * 依旧是两层结构，流一层，写流的一层
 * 输入输出流均从client获取*/

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
/**
 * 用utf-8编码写*/
            out.writeUTF("Hello from "+client.getLocalAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("~Server response : "+in.readUTF());
            client.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

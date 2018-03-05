import java.net.*;
import java.io.*;

public class GreetingServer extends Thread {
    private ServerSocket serverSocket;
    public GreetingServer(int port) throws IOException{
        serverSocket = new ServerSocket(port);
//      设置等待时间，超过时间没有访问，则结束线程，下面是设置时间限制为10秒
        serverSocket.setSoTimeout(10000);
    }

//   重写thread的run方法
    public void run(){
        while(true){
            try{
                System.out.println( serverSocket.getLocalSocketAddress()+" Waiting for remote , port : "+serverSocket.getLocalPort()+" ...");
                Socket server = serverSocket.accept();
                System.out.println("Remote host address : "+server.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());

                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for accessing : "+server.getLocalSocketAddress()+"\n Goodbye");
                server.close();
            } catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args){
        int port = Integer.parseInt(args[0]);
        try{
            Thread t = new GreetingServer(port);
            t.run();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

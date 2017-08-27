package ljl.thinking.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/8/22/022.
 */
public class ServerThread implements Runnable{

    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器 127.0.0.1 已经监听在10086端口");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int count=0;
        while(true){
            Socket socket = serverSocket.accept();
            executorService.submit(new ServerThread(socket));
            count++;
        }
    }
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            SocketAddress clientAddress = socket.getRemoteSocketAddress();
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8")) ;
            String s = null;
            System.out.println(clientAddress+" say:");
            while((s = reader.readLine())!=null){
                System.out.println(s);
            }
            socket.shutdownInput();
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎您！您是第"+atomicInteger.getAndIncrement()+"位访客");
            pw.flush();
            os.close();
            pw.close();
            inputStream.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package ljl.thinking.socket;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/8/22/022.
 */

public class Client implements Runnable {
    private String name;
    public Client(String name){
        this.name = this.name;
    }

    public static void main(String[] args) throws Exception{
       ExecutorService executorService = Executors.newFixedThreadPool(20);
       int i = 1;
       while(true){
           executorService.submit(new Client("client"+i));
           if(i%30==0){
               Thread.sleep(1000);
           }
       }
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1",10086);
            //2、获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
            pw.write("用户名:admin;密码:123");
            pw.flush();
            socket.shutdownOutput();
//3、获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info=br.readLine())!=null){
                System.out.println("我是客户端,服务器说："+info);
            }

//4、关闭资源
            br.close();
            is.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

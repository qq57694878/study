package ljl.thinking.rmi;

import ljl.thinking.po.O1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2017/7/17/017.
 */
public class Client {
    public static void main(String[] args) {
        try {
            String url = "rmi://localhost:9999/service1";
 /*           Context context = new InitialContext();
           IService service = (IService) context.lookup(url);*/
            IService service = (IService) Naming.lookup(url);
           String r =  service.service("111");
            System.out.println(r);
            O1 o = (O1)service.o1("1");
            System.out.println(o);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

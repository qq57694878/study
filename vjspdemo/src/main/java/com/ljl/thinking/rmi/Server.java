package com.ljl.thinking.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Administrator on 2017/7/17/017.
 */
public class Server {

    public static void main(String[] args) {
        try {
            String url = "rmi://localhost:9999/service1";
            IService service = new ServiceImpl();
            //Context namingContext = new InitialContext();
            //namingContext.rebind(url,service);
            LocateRegistry.createRegistry(9999);
            Naming.rebind(url,service);
        }  catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

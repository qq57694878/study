package ljl.thinking.rmi;

import ljl.thinking.po.O1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Administrator on 2017/7/17/017.
 */
public class ServiceImpl extends UnicastRemoteObject implements IService {


    public ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String service(String s) {
        System.out.println(s);
        return  "service return"+s;
    }
    @Override
    public O1 o1(String s) {
        System.out.println(s);
        return  new O1(1);
    }

}

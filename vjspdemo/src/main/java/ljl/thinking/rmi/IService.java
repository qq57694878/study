package ljl.thinking.rmi;

import ljl.thinking.po.O1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2017/7/17/017.
 */
public interface IService extends Remote{
    public String service(String s) throws RemoteException;
    public O1 o1(String s)throws RemoteException;
}

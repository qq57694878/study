package com.ljl.section1_6;

/**
 * Created by Administrator on 2017/8/9/009.
 */
public class ServiceStaticFactory {
    private ServiceStaticFactory(){}
    public static ServiceStaticFactory instance;
    public static ServiceStaticFactory getInstance(){
        if(instance==null){
            synchronized (ServiceStaticFactory.class){
                if(instance==null){
                    instance = new ServiceStaticFactory();
                }
            }
        }
        return instance;
    }
    public void sayHello(){
        System.out.println("hello static factory");
    }
}

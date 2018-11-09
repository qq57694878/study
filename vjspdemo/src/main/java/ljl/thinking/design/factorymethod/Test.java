package ljl.thinking.design.factorymethod;

import org.apache.naming.factory.SendMailFactory;

public class Test {
  
    public static void main(String[] args) {  
        Provider provider = new SmsSenderFactory();
        Sender sender = provider.produce();  
        sender.send();
    }  
}  
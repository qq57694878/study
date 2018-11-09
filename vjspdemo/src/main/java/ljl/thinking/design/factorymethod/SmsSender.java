package ljl.thinking.design.factorymethod;

public class SmsSender implements Sender{
    @Override
    public void send() {
        System.out.println("SmsSender send!");
    }
}

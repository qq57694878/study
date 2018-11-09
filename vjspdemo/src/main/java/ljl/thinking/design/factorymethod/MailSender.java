package ljl.thinking.design.factorymethod;

public class MailSender implements Sender{
    @Override
    public void send() {
        System.out.println("mail sender send!");
    }
}

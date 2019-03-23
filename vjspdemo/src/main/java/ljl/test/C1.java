package ljl.test;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2019/2/24 0024.
 */
class ObserverTV implements Observer{
    private String name;
    public ObserverTV(String name){
        this.name =name;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.name+" i see");
    }
}
class Subject extends Observable{
    public void publish(){
        System.out.println("新版本发布");
        this.notifyObservers();
    }
}
public class C1 {
    volatile long a;
    public static void test1(){
        Subject subject = new Subject();
        subject.addObserver(new ObserverTV("1"));
        subject.addObserver(new ObserverTV("2"));
        subject.publish();
    }
    public static void main(String[] args) {
test1();
    }
}

package ljl.designmode.action.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Title: C
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/20 16:50
 */
interface Observer{
	public void update();
}
class Observer1 implements Observer{

	@Override public void update() {
		System.out.println("观察者1已更新");
	}
}
class Observer2 implements Observer{

	@Override public void update() {
		System.out.println("观察者3已更新");
	}
}
interface Subject{
	public void add(Observer observer);
	public void del(Observer observer);
	/*通知所有的观察者*/
	public void notifyObservers();

	/*自身的操作*/
	public void operation();
}
abstract class AbstractSubject implements Subject{
	private List<Observer> list = new ArrayList<Observer>();

	public void add(Observer observer){
		list.add(observer);
	}
	public void del(Observer observer){
		list.remove(observer);
	}
	/*通知所有的观察者*/
	public void notifyObservers(){
		Iterator<Observer> iter=  list.iterator();
		while(iter.hasNext()){
			Observer o = 	iter.next();
			o.update();
		}

	}
	/*自身的操作*/
	public void operation(){}
}
class MySubject extends AbstractSubject implements Subject{
	/*自身的操作*/
	public void operation(){
		System.out.println("MySubject operation");
		this.notifyObservers();
	}
}
public class C {
	public static void main(String[] args) {
		Subject subject = new MySubject();
		Observer o1 = new Observer1();
		Observer o2 = new Observer2();
		subject.add(o1);
		subject.add(o2);
		subject.operation();
	}
}

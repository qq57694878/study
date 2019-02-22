package ljl.multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: PCThread
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/22 8:54
 */
interface IBlocking<T>{
	public T get();
	public void put(T t);
}
class MyBlockingSync<T> implements IBlocking<T>{
	private Object[] data;
	private int index;
	private int size;

	public MyBlockingSync(int len){
		data = new Object[len];
		index =-1;
		size=len;
	}
	@Override public T get() {
		Object result =null;
		synchronized (this){
			try {
				while(index<0){
						this.wait();
				}
				result = data[index--];
				this.notify();
				} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return (T)result;
	}

	@Override public void put(T t) {
		synchronized (this) {
			try {
				while (index >= size - 2) {
					this.wait();
				}
				data[++index] = t;
				this.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyBlocking<T> implements  IBlocking<T>{
	private Object[] data;
	private int index;
	private static java.util.concurrent.locks.Lock lock  = new ReentrantLock();
	private static Condition putCondition =  	lock.newCondition();
	private static Condition getCondition =  	lock.newCondition();
	private int size;
	public MyBlocking(int len){
		data = new Object[len];
		index =-1;
		size=len;
	}

	@Override public T get() {
		Object result =null;
		lock.lock();
		try{
			while(index<0){
				getCondition.await();
			}
			result = data[index--];
			putCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return (T)result;
	}

	@Override public void put(T t) {
		lock.lock();
		try {
			while(index>=size-2){
				putCondition.await();
			}
			data[++index]= t;
			getCondition.signalAll();
		}catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}
class Goods{
	private String name;
	public Goods(String name){
		this.name = name;
	}

	@Override public String toString() {
		return "Goods{" + "name='" + name + '\'' + '}';
	}
}
class Customer implements Runnable{
	private IBlocking<Goods> container;
	private String name;
	public Customer(IBlocking<Goods> que,int i){
		container = que;
		this.name = "customer"+i;
	}
	public void custom(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Goods goods= container.get();
		System.out.println(this.name+"消费了"+goods);
	}

	@Override public void run() {
	    while(!Thread.interrupted()){
	    	custom();
		}
	}
}
class Productor implements Runnable{
	private IBlocking<Goods> container;
	private String name;
	private static AtomicInteger atomicInteger = new AtomicInteger();
	public Productor(IBlocking<Goods> que,int i){
		container = que;
		this.name = "productor"+i;
	}
	public void product(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Goods goods= new Goods("实物"+atomicInteger.getAndIncrement());
		container.put(goods);
		System.out.println(this.name+"生产了"+goods);
	}

	@Override public void run() {
		while(!Thread.interrupted()){
			product();
		}
	}
}
public class PCThread {
	public static void main(String[] args) {
		//IBlocking container = new MyBlocking(10);
		IBlocking container = new MyBlockingSync(10);
		for(int i=0;i<1;i++){
			Customer customer = new Customer(container,i);
			new Thread(customer).start();
		}
		for(int i=0;i<11;i++){
			Productor productor = new Productor(container,i);
			new Thread(productor).start();
		}
	}
}

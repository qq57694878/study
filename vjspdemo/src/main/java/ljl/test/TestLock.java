package ljl.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Title: TestLock
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/3/22 14:45
 */
class  MyBlockingList{
	private Lock lock = new java.util.concurrent.locks.ReentrantLock();
	private Condition canPut = lock.newCondition();
	private Condition canGet = lock.newCondition();
	private int size;
	private Object[] ao;
	private int index;
	public MyBlockingList(int size){
		this.size = size;
		ao = new Object[size];
		index = -1;
	}

	public Object get()throws InterruptedException{
		Object result = null;
		lock.lock();
		try{
			if(index>=0){
				result = ao[index--];
				canPut.notify();
			}else{
				canGet.await();
			}
		}finally {
			lock.unlock();
		}
     return result;
	}
	public void put(Object o) throws InterruptedException {
		lock.lock();
		try{
			if(index<this.size-1){
				ao[++index]=o;
				canGet.signal();
			}else{
				canPut.await();
			}
		}finally {
			lock.unlock();
		}

	}
}
public class TestLock {

}

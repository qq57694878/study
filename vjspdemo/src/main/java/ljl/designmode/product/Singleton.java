package ljl.designmode.product;

/**
 * Title: Singleton
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/14 14:25
 */
public class Singleton {
	private Singleton(){}
	private static Singleton instance;
	private static  Object o = new Object();
	public static Singleton getInstance(){
		if(instance==null){
			synchronized (Singleton.class){
				if(instance==null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	public static class SingletonFactory{
		private static Singleton instance = new Singleton();

	}
	public void s(){
		System.out.println("11");
	}
	public static Singleton getInstance1(){
		return SingletonFactory.instance;
	}

	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		singleton.s();
	}
}

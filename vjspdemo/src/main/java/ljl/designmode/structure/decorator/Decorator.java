package ljl.designmode.structure.decorator;

/**
 * Title: Decorator
 * <p>Description: 装饰模式</p>
 *
 * @author lijinliang
 * Date: 2019/2/14 16:29
 */
interface  Sourceable{
	void method1();
}
class Source implements  Sourceable{
	public void method1(){
		System.out.println("this is method1");
	}
}
public class Decorator implements  Sourceable {

	private Sourceable source;

	public Decorator(Sourceable source){
		this.source = source;
	}
	public void method1(){
		System.out.println("before method1");
		source.method1();
		System.out.println("after method1");
	}

	public static void main(String[] args) {
		Sourceable s = new Decorator(new Source());
		s.method1();
	}
}

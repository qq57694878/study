package ljl.designmode.structure.proxy;

/**
 * Title: Proxy
 * <p>Description: 代理模式</p>
 *
 * @author lijinliang
 * Date: 2019/2/14 16:36
 */
interface  Sourceable{
	void method();
}
class Source implements Sourceable{
	@Override public void method() {
		System.out.println("this is method");
	}
}
public class Proxy implements Sourceable{
	private Source source;
	public Proxy(Source source){
		this.source = source;
	}
	public void before(){
		System.out.println("before");
	}
	public void after(){
		System.out.println("after");
	}
	@Override public void method() {
		before();
		source.method();
		after();
	}

	public static void main(String[] args) {
		Sourceable sourceable = new Proxy(new Source());
		sourceable.method();
	}
}

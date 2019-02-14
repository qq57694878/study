package ljl.designmode.structure.adapter.objeca;

/**
 * Title: ObjectAdapter
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/14 16:15
 */
class Source{
	public void method1(){
		System.out.println("this is orginal method1");
	}
}
interface Targetable{
	void method1();
	void method2();
}
class Adapter implements Targetable{
	private Source source;
	public Adapter( Source source){
		this.source = source;
	}

	@Override public void method1() {
		source.method1();
	}

	@Override public void method2() {
		System.out.println("this is new method2");
	}
}
public class ObjectAdapter {
	public static void main(String[] args) {
		Targetable targetable = new Adapter(new Source());
		targetable.method1();
		targetable.method2();
	}
}

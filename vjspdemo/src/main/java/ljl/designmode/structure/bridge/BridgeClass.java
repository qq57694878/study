package ljl.designmode.structure.bridge;

import javax.xml.transform.Source;

/**
 * Title: BridgeClass
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/19 13:13
 */
interface Sourceable{
	void method1();
}
class SubSourceable1 implements Sourceable{

	@Override public void method1() {
		System.out.println("SubSourceable1 method1");
	}
}
class SubSourceable2 implements Sourceable{

	@Override public void method1() {
		System.out.println("SubSourceable2 method1");
	}
}

	abstract class  Bridge1  {

	private Sourceable sourceable;

	public Sourceable getSourceable() {
		return sourceable;
	}

	public void setSourceable(Sourceable sourceable) {
		this.sourceable = sourceable;
	}
		public void method1() {
			sourceable.method1();
		}

}
class MyBridge extends Bridge1{
	public void method1() {
		getSourceable().method1();
	}
}

public class BridgeClass {
	public static void main(String[] args) {
		Bridge1 bridge1 = new MyBridge();
		bridge1.setSourceable(new SubSourceable1());
		bridge1.method1();
		bridge1.setSourceable(new SubSourceable2());
		bridge1.method1();
	}
}

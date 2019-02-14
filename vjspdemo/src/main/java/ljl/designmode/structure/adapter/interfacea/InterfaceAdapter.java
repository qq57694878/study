package ljl.designmode.structure.adapter.interfacea;

/**
 * Title: InterfaceAdapter
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/14 16:15
 */
interface Targetable{
	void method1();
	void method2();
}
abstract class A implements Targetable{
	public void method1(){
		System.out.println("this is orginal method1");
	}
	public void method2(){
		System.out.println("this is orginal method2");
	}
}
class SourceAdapterA extends A{
	public void method1(){
		System.out.println("this is new method1");
	}
}
class SourceAdapterB extends A{
	public void method2(){
		System.out.println("this is new method2");
	}
}
public class InterfaceAdapter {
	public static void main(String[] args) {
		Targetable targetable = new SourceAdapterA();
		Targetable targetable1 = new SourceAdapterB();
		targetable.method1();
		targetable.method2();
		targetable1.method1();
		targetable1.method2();
	}


}

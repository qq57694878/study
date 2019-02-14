package ljl.designmode.product.f1;

/**
 * Title: AbstractFactory
 * <p>Description: 抽象工厂</p>
 *
 * @author lijinliang
 * Date: 2019/2/14 15:27
 */
interface Food{}
class A implements Food {}
class B implements Food {}
interface Product{
	Food get();
}
class AProduct implements Product{

	@Override public Food get() {
		return new A();
	}
}
class BProduct implements Product{

	@Override public Food get() {
		return new B();
	}
}
public class AbstractFactory {
	public static void main(String[] args) {
		Product p = new AProduct();
		System.out.println(p.get());
		Product p1 = new BProduct();
		System.out.println(p1.get());
	}
}

package ljl.designmode.product.f2;

/**
 * Title: FactoryMethod
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/14 15:07
 */
interface Food{}
class A implements Food{}
class B implements Food{}
class Factory{
	private Factory(){}
	public static A getA(){return new A();}
	public static B getB(){return new B();}
}
public class FactoryMethod {
	//客户端代码只需要将相应的参数传入即可得到对象
	//用户不需要了解工厂类内部的逻辑。
	public static Food get(String name){
		Food x = null ;
		if ( name.equals("A")) {
			x = Factory.getA();
		}else if ( name.equals("B")){
			x = Factory.getB();
		}
		return x;
	}

	public static void main(String[] args) {
		Food f = FactoryMethod.get("A");
		System.out.println(f);
	}

}

package ljl.test;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Title: ClassLoaderForname
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/3/21 16:31
 */
class B{
	static{
		System.out.println("B static block is run");
	}
}
class A{
	static{
		System.out.println("A static block is run");
	}
	private static B b =new B();

}
interface C {
	default void say(String s){
		System.out.println(s);
	}
	static void hello(){
		System.out.println("hello");
	}
	void other();
}
class D implements C{

	@Override public void other() {

	}
}

public class ClassLoaderForname {
	public static void main(String[] args) throws Exception {
		//Class.forName("ljl.test.A");
		//Class.forName("ljl.test.A",false,Thread.currentThread().getContextClassLoader());
		ClassLoader.getSystemClassLoader().loadClass("ljl.test.A");
	}
}

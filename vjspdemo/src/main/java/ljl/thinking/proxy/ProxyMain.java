package ljl.thinking.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Title: ProxyMain
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/15 15:40
 */
interface Person{
	void say(String s);
	 void hello();
}
class Student implements Person {

	@Override public void say(String s) {
		System.out.println(s);
	}
	@Override public void hello() {
		System.out.println("hello");
	}
}
class MyInvocationHander implements InvocationHandler{
	private Person person;
	public MyInvocationHander(Person person){
		this.person=person;
	}

	@Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		Object o = method.invoke(person,args);
		System.out.println("after");
		return o;
	}
}
public class ProxyMain {
	public static void main(String[] args) {
		Person person = new Student();
		Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[] { Person.class }, new MyInvocationHander(person));
		p.say("你好");
		p.hello();
	}
}

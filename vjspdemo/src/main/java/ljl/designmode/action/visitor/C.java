package ljl.designmode.action.visitor;

import org.apache.catalina.Lifecycle;

/**
 * Title: C
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/21 15:49
 */
interface Subject{
	public void accept(Visitor visitor);
	public String getSubject();
}
 interface Visitor {
	public void visit(Subject sub);
}
class MyVisitor implements Visitor{

	@Override public void visit(Subject sub) {
		System.out.println("visit "+sub.getSubject());
	}
}
class MyVisitor1 implements Visitor{

	@Override public void visit(Subject sub) {
		System.out.println("come in "+sub.getSubject());
	}
}
class MySubject implements Subject{
	@Override public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override public String getSubject() {
		return "MySubject";
	}

}
public class C {
	public static void main(String[] args) {
		Subject subject = new MySubject();
		//为了改变Subject的行为，我可以改变Visitor的实现就可以改变Subject的行为。
		Visitor visitor = new MyVisitor();
		visitor.visit(subject);
		Visitor visitor1 = new MyVisitor1();
		visitor1.visit(subject);
	}
}

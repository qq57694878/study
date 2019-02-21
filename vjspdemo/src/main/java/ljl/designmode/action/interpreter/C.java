package ljl.designmode.action.interpreter;

/**
 * Title: C
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/21 17:22
 */
interface Expression {
	public int interpret(Context context);
}
class Plus implements  Expression{

	@Override public int interpret(Context context) {
		return context.getNum1()+context.getNum2();
	}
}
class Minus implements Expression{

	@Override public int interpret(Context context) {
		return context.getNum1() - context.getNum2();
	}
}
class Context {

	private int num1;
	private int num2;

	public Context(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
}
public class C {
	public static void main(String[] args) {
		int result =  new Plus().interpret(new Context(1,2));
		System.out.println(result);
	}
}

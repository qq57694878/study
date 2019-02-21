package ljl.designmode.action.templatemethod;

/**
 * Title: C
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/21 14:37
 */
abstract class AbstractCaculator{
	public  int calculate(String exp,String opt){
		int[] as = this.split(exp,opt);
		return this.calculate(as[0],as[1]);
	}
	public abstract int calculate(int m,int n);
	public int[] split(String exp,String opt){
		String array[] = exp.split(opt);
		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}
}
class Minus extends AbstractCaculator {

	@Override public int calculate(int m, int n) {
		return m-n;
	}
}
class Plus extends AbstractCaculator {

	@Override public int calculate(int m, int n) {
		return m+n;
	}
}
public class C {
	public static void main(String[] args) {
		AbstractCaculator caculator = new Minus();
		int a = caculator.calculate("8-7","\\-");
		System.out.println(a);
		caculator = new Plus();
		 a = caculator.calculate("8+7","\\+");
		System.out.println(a);
	}
}

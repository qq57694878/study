package ljl.designmode.action.strategy;

/**
 * Title: C
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/21 14:29
 */
interface ICalculator{
	public int calculate(String exp);
}
abstract class AbstractCalculator {

	public int[] split(String exp,String opt){
		String array[] = exp.split(opt);
		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}
}
class Plus extends AbstractCalculator implements  ICalculator{

	@Override public int calculate(String exp) {
		int [] intNums = this.split(exp,"\\+");
		return intNums[0]+intNums[1];
	}
}
class Minus extends AbstractCalculator implements  ICalculator{

	@Override public int calculate(String exp) {
		int [] intNums = this.split(exp,"\\-");
		return intNums[0]-intNums[1];
	}
}
public class C {
	public static void main(String[] args) {
		ICalculator calculator = new Plus();
		int a = calculator.calculate("3+4");
		System.out.println(a);
		calculator = new Minus();
		 a = calculator.calculate("4-3");
		System.out.println(a);
	}
}

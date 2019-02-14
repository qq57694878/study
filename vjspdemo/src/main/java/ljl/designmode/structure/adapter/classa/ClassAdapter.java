package ljl.designmode.structure.adapter.classa;

/**
 * Title: ClassAdapter
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/14 16:08
 */
class Source {
	public void method1() {
		System.out.println("this is original method!");
	}
}

interface TargetAble {
	void method1();

	void method2();
}

class SourceAdapter extends Source implements TargetAble {

	@Override public void method2() {
		System.out.println("this is new method!");
	}
}

public class ClassAdapter {
	public static void main(String[] args) {
		TargetAble targetAble = new SourceAdapter();
		targetAble.method1();
		targetAble.method2();
	}
}

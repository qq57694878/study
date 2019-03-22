package ljl.test;

/**
 * Title: MemoryLeak
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/3/21 15:09
 */
public class MemoryLeak {
	public static void main(String[] args) {
		test1(0L);
	}
	public static void test1(Long i){
		System.out.println(""+i++);
		test1(i);
	}
}

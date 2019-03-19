package ljl.test;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;

/**
 * Title: C1
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/27 10:53
 */
enum Status {
	OPEN, CLOSED
};

class Task {
	private final Status status;
	private final Integer points;

	Task( final Status status, final Integer points ) {
		this.status = status;
		this.points = points;
	}

	public Integer getPoints() {
		return points;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return String.format( "[%s, %d]", status, points );
	}
}
public class C1 {
	private interface Defaulable {
		// Interfaces now allow default methods, the implementer may or
		// may not implement (override) them.
		default String notRequired() {
			return "Default implementation";
		}
	}

	private static class DefaultableImpl implements Defaulable {
	}

	private static class OverridableImpl implements Defaulable {
		@Override
		public String notRequired() {
			return "Overridden implementation";
		}
	}
	private interface DefaulableFactory {
		// Interfaces now allow static methods
		static Defaulable create( Supplier< Defaulable > supplier ) {
			return supplier.get();
		}
	}

	public static void main(String[] args) {
test1();
	}
	public static void test2(String[] args) {
		Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );
		Defaulable defaulable = DefaulableFactory.create( DefaultableImpl::new );
		System.out.println( defaulable.notRequired() );

		defaulable = DefaulableFactory.create( OverridableImpl::new );
		System.out.println( defaulable.notRequired() );
	}
	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRES_NEW)
	public static void test1(){
		final Collection< Task > tasks = Arrays.asList(
				new Task( Status.OPEN, 5 ),
				new Task( Status.OPEN, 13 ),
				new Task( Status.CLOSED, 8 )
		);
		int i  = tasks.stream().filter(o->o.getStatus().equals(Status.OPEN)).mapToInt(Task::getPoints).sum();
		System.out.println(i);
	}
}

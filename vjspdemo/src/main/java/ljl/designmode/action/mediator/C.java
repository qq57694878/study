package ljl.designmode.action.mediator;

/**
 * Title: C
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/21 17:03
 */
interface Mediator{
	public void createMediator();
	public void workAll();
	public User1 getUser1();
	public User2 getUser2();
}
class MyMediator implements Mediator{

   private User1 user1;
   private User2 user2;

	@Override public User1 getUser1() {
		return user1;
	}

	@Override public User2 getUser2() {
		return user2;
	}

	@Override public void createMediator() {
		user1 = new User1(this);
		user2 = new User2(this);
	}

	@Override public void workAll() {
        user1.work();
        user2.work();
	}
}
abstract class User {

	private Mediator mediator;

	public Mediator getMediator(){
		return mediator;
	}

	public User(Mediator mediator) {
		this.mediator = mediator;
	}

	public abstract void work();
}
class User1 extends User{

	public User1(Mediator mediator) {
		super(mediator);
	}

	@Override public void work() {
		System.out.println("user1 work");
	}
}
class User2 extends User{

	public User2(Mediator mediator) {
		super(mediator);
	}

	@Override public void work() {
		getMediator().getUser1().work();
		System.out.println("user2 work");
	}
}
public class C {
	public static void main(String[] args) {
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();

	}
}

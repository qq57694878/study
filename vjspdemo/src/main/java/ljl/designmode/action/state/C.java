package ljl.designmode.action.state;

/**
 * Title: C
 * <p>Description: 状态模式
 * 当状态改变影响依赖于状态的类的行为发生变化</p>
 *
 * @author lijinliang
 * Date: 2019/2/21 15:17
 */
class Context{
	private IState state;

	public Context(){
		state = null;
	}

	public void setState(IState state){
		this.state = state;
	}

	public IState getState(){
		return state;
	}
	public void  method1(){
		if(state instanceof  StartState){
			System.out.println("startState zhixing");
		}
		else if(state instanceof  StopState){
			System.out.println("stopState zhixing");
		}
	}
}
interface  IState{
	public void doAction(Context context);
}
class StartState implements IState{

	@Override public void doAction(Context context) {
		context.setState(this);
	}
}
class StopState implements IState{

	@Override public void doAction(Context context) {
		context.setState(this);
	}
}
public class C {
	public static void main(String[] args) {
		Context context = new Context();
		context.setState(new StartState());
		context.method1();
		context.setState(new StopState());
		context.method1();
	}
}

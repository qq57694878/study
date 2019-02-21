package ljl.designmode.action.command;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.awt.shell.ShellFolder;

/**
 * Title: C
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/21 13:52
 */
interface ICommand {
	public void exe();
}
interface IReceiver{
	public void action();
}
interface IInvoker {
	public void action();
}
class MyCommond implements ICommand{
	private IReceiver receiver;
	public MyCommond(IReceiver receiver){
		 this.receiver = receiver;
	}

	@Override public void exe() {
		this.receiver.action();
	}
}
class Receiver implements  IReceiver{
	@Override public void action() {
		System.out.println("receiver action");
	}
}

 class Invoker implements IInvoker{

	private ICommand command;

	public Invoker(ICommand command) {
		this.command = command;
	}

	public void action(){
		command.exe();
	}
}

public class C {

	public static void main(String[] args) {
		IReceiver iReceiver = new Receiver();
		IInvoker invoker = new Invoker(new MyCommond(iReceiver));
		invoker.action();
	}
}

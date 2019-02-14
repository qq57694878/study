package ljl.designmode.structure.facade;

/**
 * Title: Facade
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/14 16:58
 */
class CPU{
	void startup(){
		System.out.println("cpu startup");
	}
	void shutdown(){
		System.out.println("cpu shutdown");
	}
}
class Memory{
	void startup(){
		System.out.println("memory startup");
	}
	void shutdown(){
		System.out.println("memory shutdown");
	}
}
class Disk{
	void startup(){
		System.out.println("disk startup");
	}
	void shutdown(){
		System.out.println("disk shutdown");
	}
}
class Computer{
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	public Computer(){
		this.cpu = new CPU();
		this.memory=new Memory();
		this.disk=new Disk();
	}
	void startup(){
		this.cpu.startup();
		this.memory.startup();
		this.disk.startup();
		System.out.println("start computer finished!");
	}
	void shutdown(){
		this.cpu.shutdown();
		this.memory.shutdown();
		this.disk.shutdown();
		System.out.println("shutdown computer finished!");
	}
}
public class Facade {
	public static void main(String[] args) {
		Computer c = new Computer();
		c.startup();
		c.shutdown();
	}
}

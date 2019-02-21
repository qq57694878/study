package ljl.designmode.action.memento;

/**
 * Title: C
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/21 14:58
 */
class MemInfo{
	private String value;
	public MemInfo(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
class Original{
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public MemInfo createMeminfo(){
		return new MemInfo(this.value);
	}
	public void restoreMeninfo(MemInfo memInfo){
		this.value = memInfo.getValue();
	}
}
class Storage{
	private MemInfo memInfo;
	public Storage(MemInfo memInfo){
		this.memInfo = memInfo;
	}

	public MemInfo getMemInfo() {
		return memInfo;
	}
}
public class C {
	public static void main(String[] args) {
		Original original  = new Original();
		original.setValue("nihao");
		MemInfo memInfo  = original.createMeminfo();
		Storage storage = new Storage(memInfo);
		System.out.println("变更前："+original.getValue());
		original.setValue("new value");
		System.out.println("变更后："+original.getValue());
		original.restoreMeninfo(storage.getMemInfo());
		System.out.println("恢复后："+original.getValue());
	}
}

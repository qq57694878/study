package ljl.designmode.product;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: Prototype
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/14 14:42
 */
public class Prototype implements Cloneable,Serializable {
	private static final long serialVersionUID = 1L;
	private String string;

	private Map map;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	@Override public String toString() {
		return "Prototype{" + "string='" + string + '\'' + ", map=" + map + '}';
	}

	@Override protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	/* 深复制 */
	public Object deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(this);
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}

	public static void main(String[] args)throws Exception {
		Prototype p = new Prototype();
		Map m = new HashMap();
		m.put("1","2");
		p.setMap(m);
		p.setString("123");
		System.out.println(p);
		Prototype p1 =(Prototype)p.deepClone();

		p1.getMap().put("2","2");

		System.out.println(p);
		System.out.println(p1);
		Prototype p2 =(Prototype)p.clone();
		p2.getMap().put("2","2");
		System.out.println(p);
		System.out.println(p2);
	}
}

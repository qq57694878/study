package ljl.test;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * Title: ObjectCreation
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/3/21 12:36
 */
public class ObjectCreation {
	public static void main(String[] args)throws Exception {

		//one
		Employee employee = new Employee();
		System.out.println(employee);
		//two
		Employee e2 = Employee.class.newInstance();
		e2.setName("lilei");
		e2.getM().put("1","1");
		System.out.println(e2);
		Constructor c = Employee.class.getConstructor(String.class);
		Employee e21 = (Employee)c.newInstance("hahahaha");
		System.out.println("e21:");
		System.out.println(e21);
		//three
		Employee e3 = (Employee) e2.clone();

		e3.getM().put("2","2");
		System.out.println("three:");
		System.out.println(e2);
		System.out.println(e3);
		//four
		ByteArrayOutputStream bio = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bio);
		os.writeObject(e3);
		ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(bio.toByteArray()));
		Employee e4 = (Employee)is.readObject();
		System.out.println("four:");
		System.out.println(e4);
		e3.getM().put("3","3");
		e4.getM().put("4","4");
		System.out.println(e4);

		Employee e5 = (Employee)Class.forName("ljl.test.Employee").newInstance();
		System.out.println(e5);



	}
}

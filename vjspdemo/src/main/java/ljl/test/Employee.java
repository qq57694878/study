package ljl.test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: Employee
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/3/21 12:31
 */
public class Employee implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	public Map<String,String> m =new HashMap<String,String>();
	private final String s;
	private String name;
	public Employee() {
		s="";
		System.out.println("Employee Constructor Called...");
	}
	public Employee(String name ) {
		s="";
		this.name = name;
		System.out.println("Employee Constructor args Called...");
	}
	public String getName() {
		return name;
	}

	public Map<String, String> getM() {
		return m;
	}

	public void setM(Map<String, String> m) {
		this.m = m;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + "]"+m;
	}
	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}

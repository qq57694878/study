package ljl.designmode.structure.bridge;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Title: Bridge
 * <p>Description: 桥接模式</p>
 *
 * @author lijinliang
 * Date: 2019/2/14 17:03
 */
interface Driver{
	Connection connect();
}
class DriverManager1 {
	private Driver driver;
	public void setDriver(Driver driver){
		this.driver = driver;
	}
	public  Connection getConection(){
		return this.driver.connect();
	}

}
public class Bridge {
	public static void main(String[] args) {

	}
}

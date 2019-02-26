import java.util.*;

/**
 * Created by Administrator on 2017/8/14/014.
 */
public class TTT {
	public static void main(String[] args) {
		final Map m = new HashMap();
		m.put("key","value");
		System.out.println(m);
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//			list.remove(i);
//		}
		Iterator<String> iter =  list.iterator();
		while(iter.hasNext()){
			//System.out.println(iter.next());
			//iter.next();
			//iter.remove();
		//	list.remove(iter.next());
		}
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
	}
}

package ljl.designmode.action.iterator;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

/**
 * Title: C
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/20 17:12
 */
interface Iterator<T>{
	T next();
	boolean hasNext();
}
interface Collection<T>{
	Iterator<T> iterator();
	public void add(T a);
	public int size();
}
class MyCollection<T> implements Collection<T>{
	private Object[] array ;
	private int addIndex;
	private int size;
	public MyCollection(int size){
		this.array = new Object[size];
		this.addIndex=0;
		this.size =size;
	}

	@Override public Iterator<T> iterator() {
		return new MyIterator<>();
	}

	@Override public void add(T a) {
		if(addIndex<size()-1){
			array[addIndex++] = a;
		}
	}



	@Override public int size() {
		return this.size;
	}
	private class MyIterator<T> implements Iterator<T>{
		private int index;
		public MyIterator(){
			index =0;
		}

		@Override public T next() {
			return (T)array[index++];
		}

		@Override public boolean hasNext() {
			if(index<size()-1){
				return true;
			}
			return false;
		}
	}
}
public class C {
	public static void main(String[] args) {
		Collection<Integer> collection = new MyCollection<Integer>(10);
		collection.add(1);
		collection.add(2);
		collection.add(3);
		Iterator iter = collection.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}

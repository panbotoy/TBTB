package linkedin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ListIterator<T> implements Iterator {

	/**
	 * @param args
	 */
	Stack<Iterator> stack = new Stack<Iterator>();
	T nextItem = null;
	Iterator iter = null;
	
	public ListIterator(List<Object> list){
		iter = list.iterator();
		nextItem = this.getNextItem();
	}
	
	private T getNextItem(){
		while (iter.hasNext() || !stack.isEmpty()){
			if (!iter.hasNext()){
				iter = stack.pop();
				continue;
			}
			Object obj = iter.next();
			if (obj instanceof List){
				stack.add(iter);
				iter = ((List)obj).iterator();
			} else {
				return (T)obj;
			}
		}
		return null;
	}
	
	@Override
	public boolean hasNext(){
		return nextItem != null;
	}
	
	@Override
	public T next(){
		T item = this.nextItem;
		this.nextItem = this.getNextItem();
		return item;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Object> list1 = new ArrayList<Object>();
		ArrayList<Object> list2 = new ArrayList<Object>();
		ArrayList<Object> list3 = new ArrayList<Object>();
		ArrayList<Object> list4 = new ArrayList<Object>();
		list2.add(1);
		list2.add(2);
		list4.add(4);
		list4.add(5);

		list3.add(list4);
		list3.add(6);
		list1.add(0);
		list1.add(list2);
		list1.add(3);
		list1.add(list3);
		
		ArrayList<Object> list5 = new ArrayList<Object>();
		ArrayList<Object> list6 = new ArrayList<Object>();
		list5.add(list6);
		
		ListIterator<Integer> iter = new ListIterator<Integer>(list1);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}

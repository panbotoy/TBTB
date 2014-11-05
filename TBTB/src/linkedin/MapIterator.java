package linkedin;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MapIterator<K, T> implements Iterator<T> {
	Map<K, Object> map = null;
	Class<T> elementClass = null;
	Iterator<K> currentKeyIterator = null;
	LinkedList<Map<K, Object>> current = new LinkedList< Map < K, Object>>();
	T nextElem = null;
	
	public MapIterator(Map<K, Object> map, Class<T> elementClass) {   //Constructor should not contain <K,T>
		this.map = map;
		this.elementClass = elementClass;
		this.currentKeyIterator = this.map.keySet().iterator();
		this.nextElem = this.getNextElem();
	}
	
	private T getNextElem(){
		T result = null;
		while(this.currentKeyIterator.hasNext() || this.current.size()!= 0){
			if (this.currentKeyIterator.hasNext()){
				K key = this.currentKeyIterator.next();
				Object value = this.map.get(key);
				if (value instanceof Map){
					if (((Map<K, Object>) value).size() != 0){ // no need to cast?? 
						this.current.add((Map<K,Object>)value);
						continue;
					}
				}
				//else if (value instanceof T){ how to write this ??
				else{
					result = (T)value;
					break;
				}
			}
			else if(this.current.size()!=0){
				this.map = this.current.poll();
				this.currentKeyIterator = this.map.keySet().iterator();
			}
		}
		return result;
	}
	
	@Override
	public boolean hasNext(){
		return this.nextElem != null;
	}
	@Override
	public T next(){
		if (this.nextElem == null) throw new NoSuchElementException();
		T tmp = this.nextElem;
		this.nextElem = this.getNextElem();
		return tmp;
	}
	
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Object> map1 = new HashMap<Integer, Object>();

		Map<Integer, Object> map2 = new HashMap<Integer, Object>();
		Map<Integer, Object> map3 = new HashMap<Integer, Object>();
		Map<Integer, Object> map4 = new HashMap<Integer, Object>();
		
		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(3, map2);
		
		map2.put(31, "C");
		map2.put(32, "D");
		map2.put(33, map3);
		
		map3.put(331, map4);
		map3.put(332, "E");
		
		MapIterator<Integer, String> myIter = new MapIterator<Integer,String>(map1, String.class);
		while(myIter.hasNext()){
			System.out.println(myIter.next());
		}
	}

}

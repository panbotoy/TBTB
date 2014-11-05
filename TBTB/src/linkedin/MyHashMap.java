package linkedin;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K,V> {
	
	int capacity = 0;
	ArrayList<List<HashEntry<K,V>>> map;
	public MyHashMap(int capacity){
		this.capacity = capacity;
		map = new ArrayList<List<HashEntry<K,V>>>(this.capacity);
		for (int i = 0; i < this.capacity; i++){
			map.add(new ArrayList<HashEntry<K,V>>());
		}
	}
	
	public void put(K key, V value){
		HashEntry<K,V> entry = new HashEntry<K,V>(key, value);
		int hash = this.hashFunction(key);
		List<HashEntry<K,V>> list = map.get(hash);
		boolean exists = false;
		for (HashEntry<K,V> existing : list){
			if (existing.getKey().hashCode() == entry.getKey().hashCode()){
				existing = entry;
				exists = true;
				break;		
			}
		}
		if (!exists) list.add(entry);
	}
	
	public V get(K key){
		int hash = this.hashFunction(key);
		List<HashEntry<K,V>> list = map.get(hash);
		for (HashEntry<K,V> entry : list){
			if (entry.getKey().hashCode() == key.hashCode()){
				return entry.getValue();
			}
		}
		return null;
	}
	
	private int hashFunction(K key){
		return Math.abs(key.hashCode()) % this.capacity;
	}
		
	public class HashEntry<K,V>{
		K key = null;
		V value = null;
		public HashEntry(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public K getKey(){
			return this.key;
		}
		
		public V getValue(){
			return this.value;
		}
	}
	
	public static void main(String args[]){
		MyHashMap<String, String> map = new MyHashMap<String, String>(10);
		map.put("abc", "123");
		map.put("cde", "345");
		System.out.println(map.get("abc"));
	}
}

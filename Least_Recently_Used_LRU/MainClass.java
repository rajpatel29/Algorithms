package Least_Recently_Used_LRU;

public class MainClass {
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(3);
		lru.put(1, 1);
		lru.show();
		
		lru.put(2, 2);
		lru.show();
		
		lru.put(3, 3);
		lru.show();
		
		lru.put(1, 1);
		lru.show();
		
		lru.get(2);
		lru.show();
		
		
	}

}

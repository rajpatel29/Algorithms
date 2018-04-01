package LRU_Cache;

public class MainClass {
	public static void main(String[] args) {
//		LeastRecentlyUsedCache cache = new LeastRecentlyUsedCache(2);
//		
//		cache.put(1, 1);
//		cache.put(2, 2);
//		System.out.println(cache.get(1));       // returns 1
//		cache.put(3, 3);    // evicts key 2
//		System.out.println(cache.get(2));       // returns -1 (not found)
//		cache.put(4, 4);    // evicts key 1
//		System.out.println(cache.get(1));       // returns -1 (not found)
//		System.out.println(cache.get(3));       // returns 3
//		System.out.println(cache.get(4));       // returns 4
		
		LeastRecentlyUsedCache cache1 = new LeastRecentlyUsedCache(2);
		cache1.put(2, 1);
		cache1.put(2, 3);
		cache1.put(4, 4);
		System.out.println(cache1.get(2));
	
		
	}
}

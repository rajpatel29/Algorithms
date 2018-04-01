package LFU_Cache;

public class MainClass {

	public static void main(String[] args) {
		LFUCache cache = new LFUCache(3);
		
		cache.set(1, 1);
		cache.set(2, 2);
		System.out.println(cache.get(2));  
		System.out.println(cache.get(1)); 
		System.out.println(cache.get(2)); 
		cache.set(3, 3);     
		cache.set(4, 4);
		System.out.println(cache.get(3));       
		System.out.println(cache.get(2));       
		System.out.println(cache.get(1));     
		System.out.println(cache.get(4));
		
	}

}

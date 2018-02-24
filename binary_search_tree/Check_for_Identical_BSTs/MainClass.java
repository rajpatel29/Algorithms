package Check_for_Identical_BSTs;

public class MainClass {
	public static void main(String[] args) {
//		int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
//		int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
		
		int a[] = {2,4,3,1};
		int b[] = {2,1,4,3};
		
		System.out.println("Is same? " + isSameBST(a, b));
	}

	private static boolean isSameBST(int[] a, int[] b) {
		if(a.length != b.length) 
			return false;
		
		return isSameBSTHelper(a, b, 0, 0, a.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isSameBSTHelper(int[] a, int[] b, int aIndex, int bIndex, int length, int minValue, int maxValue) {
		int i, j;
		
		for (i = aIndex; i < length; i++) {
			if(minValue < a[i] && a[i] < maxValue) {
				break;
			}
		}
		
		for (j = bIndex; j < length; j++) {
			if(minValue < b[j] && b[j] < maxValue) {
				break;
			}
		}
		
		
		if((i == length) && (j == length)) {
			return true;
		}
		
		if(((i == length) && (j != length)) || ((i != length) && (j == length))) {
			return false;
		}
		
		if((a[i] != b[j]))
			return false;
		
		return isSameBSTHelper(a, b, i+1, j+1, length, a[i], maxValue) &&
				isSameBSTHelper(a, b, i+1, j+1, length, minValue, a[i]);
		
	}
}

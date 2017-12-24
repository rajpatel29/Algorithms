package Kruskals;

public class DisjointSetTest {
	public static void main (String args[]) {
		DisjointSet disjointSet = new DisjointSet(7);
		disjointSet.makeSet(1);
		disjointSet.makeSet(2);
		disjointSet.makeSet(3);
		disjointSet.makeSet(4);
		disjointSet.makeSet(5);
		disjointSet.makeSet(6);
		disjointSet.makeSet(7);
		
		disjointSet.union(1,2);
		disjointSet.union(2,3);
		disjointSet.union(4,5);
		disjointSet.union(6,7);
		disjointSet.union(5,6);
		disjointSet.union(3,7);
		
		disjointSet.printMe();

		
	}
}

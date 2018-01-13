/**
Given some resources in the form of linked list you have to canceled out all the resources(only "sub-sequences") whose sum up to 0(Zero) and return the remaining list. 

E.g-->> 6 -6 8 4 -12 9 8 -8 

the above example lists which gets canceled : 
6 -6 
8 4 -12 
8 -8 
o/p : 9 
case 3 : 4 6 -10 8 9 10 -19 10 -18 20 25 
O/P : 20 25
**/

package CancelSubSequencesSum0;

public class MainClass {
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.push(6);
		list.push(-6);
		list.push(8);
		list.push(4);
		list.push(-12);
		list.push(9);
		list.push(8);
		list.push(-8);
		
		list.cancelOutSum0();
	}
}

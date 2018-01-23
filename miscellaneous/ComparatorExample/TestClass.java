package ComparatorExample;

import java.util.ArrayList;
import java.util.Collections;

public class TestClass {
	public static void main (String args[]) {
		ArrayList list = new ArrayList<Student>();
		Student s2 = new Student("Stu 2", 50);
		Student s3 = new Student("Stu 3", 35);
		Student s1 = new Student("Stu 1", 45);
		
		list.add(s2);
		list.add(s1);
		list.add(s3);
		
		Collections.sort(list, new AgeComparator());
		System.out.println("Age Comparator");
		for (int i = 0; i < list.size(); i++) {
			Student current = (Student) list.get(i);
			System.out.println(current.name + " " + current.age);
		}
		System.out.println();
		
		Collections.sort(list, new NameComparator());
		System.out.println("Name Comparator");
		for (int i = 0; i < list.size(); i++) {
			Student current = (Student) list.get(i);
			System.out.println(current.name + " " + current.age);
		}
	}
}

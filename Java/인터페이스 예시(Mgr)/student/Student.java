package student;

import java.util.Scanner;
import manager.Manageable;

public class Student implements Manageable {
	static int Number=1;
	int id;
	String sid;
	String name;
	String dept;
	int year;
	String phone;
	public void read(Scanner in) {
		id = Number++;
		sid = in.next();
		name = in.next();
		dept = in.next();
		year = in.nextInt();
		phone = in.next();
	}
		
	public void print() {
		System.out.printf("%d %s %s %2d학년 %s%n", 
				id, name, dept, year, phone);
	}
	public boolean compare(String kwd) {
		if (kwd.matches("-?\\d+")) {
			int temp = Integer.parseInt(kwd);
			if (id == temp) return true;
			if (year == temp) return true;
		}
		if (kwd.equals(name) || kwd.equals(dept) 
			|| kwd.equals(phone))
			return true;
		return false;
	}
}
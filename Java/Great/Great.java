package great;

import java.util.Scanner;

class Great {
	static int Count = 1;
	int id;
	int type;
	int country;
	String name;
	String gender;
	int bYear, dYear;
	String achieve;
	
	Great() {
		id = Count++;
	}
	Great(String s) {
		name = s;
		id = Count++;
	}
	void read(Scanner s) {
		name = s.next();
		type = s.nextInt();
		gender = s.next();
		country = s.nextInt();
		bYear = s.nextInt();
		dYear = s.nextInt();
		achieve = s.nextLine().trim();
	}
	void appendRead(Scanner s) {
		System.out.print("����(��:M/��:F) : ");
		gender = s.next();
		System.out.print("�ô� : (0)���� (1)������ (2)�ﱹ (3)���ϽŶ� (4)��� (5)���� (6)�Ĺ��� (7)���ѹα� ");
		country = s.nextInt();
		System.out.print("���� : (0)��Ÿ (1)�� (2)���� (3)��ġ�� (4)������ (5)�ǻ� (6)������ ");
		type = s.nextInt();
		System.out.print("���� ����� : ");
		bYear = s.nextInt();
		dYear = s.nextInt();
		s.nextLine();
		System.out.print("���� : ");
		achieve = s.nextLine();
		print();
	}
	boolean match(int matchType, String kwd) {
		if (matchType == MatchType.getNum("Name"))
			return name.contains(kwd);
		if (matchType == MatchType.getNum("Gender"))
			return gender.contains(kwd);
		if (matchType == MatchType.getNum("Year")) {
			int year = Integer.parseInt(kwd);
			return (year >= bYear && year <= dYear);
		}
		if (matchType == MatchType.getNum("Achieved"))
			return achieve.contains(kwd);
		return false;
	}
	void print() {
		System.out.printf("[%d] %s [%s] %d ~ %d %s / %s\n", 
						id, name, gender, bYear, dYear, 
						Country.getValue(country), GType.getValue(type));
		if (achieve.length() != 0)
			System.out.println(achieve);
	}
	void print(int matchType, String kwd) {
		if (matchType != MatchType.getNum("Name"))
			System.out.printf("%s ",  name);
		else System.out.print("�� ������  ");
		System.out.printf("%d ~ %d  ", bYear, dYear);
		if (matchType != MatchType.getNum("Gender")) 
			System.out.printf("[%s] ",  gender);
		if (matchType != MatchType.getNum("Achieved"))
			System.out.print(achieve);
		else
			System.out.print(achieve.replace(kwd, "<<" + kwd + ">>"));
		System.out.println();
	}
}

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
		System.out.print("성별(남:M/여:F) : ");
		gender = s.next();
		System.out.print("시대 : (0)없음 (1)고조선 (2)삼국 (3)통일신라 (4)고려 (5)조선 (6)식민지 (7)대한민국 ");
		country = s.nextInt();
		System.out.print("구분 : (0)기타 (1)왕 (2)무인 (3)정치가 (4)예술가 (5)의사 (6)종교인 ");
		type = s.nextInt();
		System.out.print("생년 사망년 : ");
		bYear = s.nextInt();
		dYear = s.nextInt();
		s.nextLine();
		System.out.print("업적 : ");
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
		else System.out.print("이 위인은  ");
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

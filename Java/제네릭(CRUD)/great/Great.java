package great;

import java.util.Scanner;
import java.util.ArrayList;

import crud.Crudable;

public class Great implements Crudable {
	static int Number=1;
	int id;
	String name;
	String gender;
	int bYear, dYear;
	String achieved;
	@Override
	public void read(Scanner in) {
		id = Number++;
		name = in.next();
		gender = in.next();
		bYear = in.nextInt();
		dYear = in.nextInt();
		achieved = in.nextLine();
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void print() {
		System.out.printf("[%d] %s %d-%d, %s%n", 
				id, name, bYear, dYear, achieved);
	}
	void showQuestion() {
		System.out.printf("%d-%d년도 - %s%n", 
				bYear, dYear, achieved);		
	}
	@Override
	public boolean compare(String kwd) {
		if (kwd.matches("-?\\d+")) {
			int temp = Integer.parseInt(kwd);
			if (id == temp) return true;
			if (bYear <= temp && temp <= dYear) 
				return true;
		}
		if (kwd.equals(name) || achieved.contains(kwd))
			return true;
		return false;
	}
	@Override
	public boolean compare(int n) {
		return (bYear <= n && n <= dYear);
	}

	@Override
	public boolean readOnline(String name, Scanner keyin) {
		id = Number++;
		this.name = name;
		System.out.println("성별 (m/f/n) : ");
		gender = keyin.next();
		System.out.println("생년 사망년 : ");
		bYear = keyin.nextInt();
		dYear = keyin.nextInt();
		keyin.nextLine();
		System.out.println("업적 : ");
		achieved = keyin.nextLine().trim();
   		return true;
	}
	static ArrayList<String> Names = new ArrayList<>();
	static {
		Names.add("박혁거세");
		Names.add("왕건");
		Names.add("이성계");
	}
	@Override
	public boolean checkRemove() {
		if(achieved.contains("건국")) {
			System.out.println("건국 왕 입니다.");
	        return false;
		}
	    return true;
	}
	public boolean update(Scanner keyin) {
		System.out.printf("성별 [%s] (m/f/n, 엔터 변경없음) : ", gender);
		String aLine = keyin.nextLine().trim();
		if (aLine.trim().length() > 0)
			gender = aLine;
		System.out.printf("생년 사망년 [%d %d], 엔터 변경없음): ", bYear, dYear);
		aLine = keyin.nextLine().trim();
		if (aLine.length() > 0) {
			String[] tokens = aLine.split(" ");
			bYear = Integer.parseInt(tokens[0]);
			dYear = Integer.parseInt(tokens[1]);
		}
		System.out.printf("업적 (엔터 변경없음) [%s] : ", achieved);
		aLine = keyin.nextLine().trim();
		if (aLine.length() > 0)
			achieved = aLine;
		return true;
	}
}
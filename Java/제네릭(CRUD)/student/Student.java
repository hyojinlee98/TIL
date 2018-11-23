package student;

import java.util.Scanner;
import book.*;
import crud.Crudable;

public class Student implements Crudable {
	static int Number = 1;
	int id;
	int loan;
	String college;
	String studentId;
	String name;
	int grade;
	String phoneNumber;
	Book[] lendlist = null;
	@Override
	public void read(Scanner s) {
		id = Number++;
		studentId = s.next();
		name = s.next();
		college = s.next();
		grade = s.nextInt();
		phoneNumber = s.next();
	}
	public void readLend(Scanner s) {
		int count;
		count = s.nextInt();
		loan = count;
		lendlist = new Book[count];
		Book b = null;
		for (int i = 0; i < count; i++) {
			b = BookCrudMgr.blist.get(s.nextInt() - 1);
			b.loan += 1;
			lendlist[i] = b;
		}
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void print() {
		System.out.printf("[%s] %s %s (%d학년) %s\n", 
				studentId, name, college, grade, phoneNumber);
		if (lendlist != null) {
			System.out.print("대출 : ");
			for (Book b : lendlist) {
				System.out.printf("[%s, %s]\n", b.publisher, b.title);
			}
			System.out.println();
		}
	}
	@Override
	public boolean compare(String kwd) {
		if (studentId.equals(kwd)) return true;
		if (college.equals(kwd)) return true;
		if (name.equals(kwd)) return true;
		return false;
	}
	@Override
	public boolean compare(int n) {
		return (id == n || grade == n);
	}
	@Override
	public boolean readOnline(String studentId, Scanner keyin) {
		id = Number++;
		this.studentId = studentId;
		System.out.println("이름 : ");
		name = keyin.next();
		System.out.println("학과 : ");
		college = keyin.next();
		System.out.println("학년 : ");
		grade = keyin.nextInt();
		System.out.println("휴대폰 번호 : ");
		phoneNumber = keyin.next();
   		return true;
	}
	@Override
	public boolean checkRemove() {
		if(loan != 0) {
			System.out.printf("%d권 대출중...\n", loan);
			System.out.print("대출 : \n");
			for (Book b : lendlist)
				System.out.printf("[%s, %s]\n", b.publisher, b.title);
			System.out.println();
	        return false;
		}
	    return true;
	}
	public boolean update(Scanner keyin) {
		System.out.printf("이름 (엔터 변경없음) [%s] : ", name);
		String aLine = keyin.nextLine().trim();
		if (aLine.trim().length() > 0)
			name = aLine;
		System.out.printf("학과 (엔터 변경없음) [%s] : ", college);
		aLine = keyin.nextLine().trim();
		if (aLine.length() > 0) 
			college = aLine;
		System.out.printf("학년 (엔터 변경없음) [%d] : ", grade);
		aLine = keyin.nextLine().trim();
		if (aLine.length() > 0) 
			grade = Integer.parseInt(aLine);
		System.out.printf("휴대폰 번호 (엔터 변경없음) [%s] : ", phoneNumber);
		aLine = keyin.nextLine().trim();
		if (aLine.length() > 0)
			phoneNumber= aLine;
		return true;
	}
}
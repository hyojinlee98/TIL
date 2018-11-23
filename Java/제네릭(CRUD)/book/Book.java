package book;

import java.util.Scanner;
import crud.Crudable;

public class Book implements Crudable {
	static int Number = 1;
	public int loan = 0;
	public int id;
	public String title;
	int isbn;
	int year;
	public String publisher;
	String[] author;
		
	@Override
	public void read(Scanner s) {
		id = Number++;
		title = s.nextLine();
		if (title.length() == 0)
			title = s.nextLine();
		isbn = s.nextInt();
		year = s.nextInt();
		publisher = s.next();
		int count = 0;
		count = s.nextInt();
		author = new String[count];
		for (int i = 0; i < count; i++)
			author[i] = s.next();
	}
	@Override
	public void print() {
		System.out.printf("[%d] %s\n\t%d %d년 %s - ", 
				id, title, isbn, year, publisher);
		for (String a : author)
			System.out.printf("%s ", a); 
		System.out.printf(" : %d명 대출\n", loan);
	}
	@Override
	public boolean compare(String kwd) {
		if (title.contains(kwd) || kwd.equals(publisher))
			return true;
		for (String s : author) {
			if (kwd.equals(s))
				return true;
		}
		return false;
	}
	@Override
	public boolean compare(int n) {
		return (year == n || isbn == n || id == n);
	}
	@Override
	public String getName() {
		return title;
	}
	@Override
	public boolean readOnline(String name, Scanner keyin) {
		this.title = name;
		System.out.println("isbn : ");
		isbn = keyin.nextInt();
		System.out.println("연도 : ");
		year = keyin.nextInt();
		System.out.println("출판사 : ");
		publisher = keyin.next();
		System.out.println("저자(수, 이름) : ");
		int n = keyin.nextInt();
		author = new String[n];
		for (int i = 0; i < n; i++)
			author[i] = keyin.next();
   		return true;
	}
	@Override
	public boolean checkRemove() {
		if(loan != 0) {
			System.out.printf("%d명이 대출중이라 삭제할 수 없습니다.", loan);
	        return false;
		}
	    return true;
	}
	public boolean update(Scanner keyin) {
		System.out.printf("도서번호 [%d] (엔터 변경없음) : ", isbn);
		String aLine = keyin.nextLine().trim();
		if (aLine.length() > 0)
			isbn = Integer.parseInt(aLine);
		System.out.printf("연도 [%d] (엔터 변경없음): ", year);
		aLine = keyin.nextLine().trim();
		if (aLine.length() > 0)
			year = Integer.parseInt(aLine);
		System.out.printf("출판사 (엔터 변경없음) [%s] : ", publisher);
		aLine = keyin.nextLine().trim();
		if (aLine.length() > 0)
			publisher = aLine;
		return true;
	}
}
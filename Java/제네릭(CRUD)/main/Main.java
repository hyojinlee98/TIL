package main;

import java.util.Scanner;
import book.BookCrudMgr;
import great.GreatCrudMgr;
import student.StudentCrudMgr;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.doit();
	}
	BookCrudMgr bMgr = new BookCrudMgr();
	GreatCrudMgr gMgr = new GreatCrudMgr();
	StudentCrudMgr sMgr = new StudentCrudMgr();
	void doit() {
		readAll();
		printAll();
		menu();
	}
	void menu() {
		int menu = 0;
		Scanner s = new Scanner(System.in);
		while (menu < 4) {
			System.out.print("(1) 학생 (2) 책 (3) 위인 (4) 종료.. ");
			menu = s.nextInt();
			s.nextLine();
			if (menu <= 0 || menu > 3) break;
			switch(menu) {
			case 1 :
				sMgr.menu();
				break;
			case 2 :
				bMgr.menu();
				break;
			case 3 :
				gMgr.menu();
				break;
			}
		}
		gMgr.runQuiz();
		System.out.println("Bye!!");
	}
	void readAll() {
		bMgr.doit();
		gMgr.doit();
		sMgr.doit();
	}
	void printAll() {
		sMgr.printAll();
		bMgr.printAll();
		gMgr.printAll();
	}
}

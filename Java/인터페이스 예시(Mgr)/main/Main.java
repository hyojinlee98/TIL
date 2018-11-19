package main;

import java.util.Scanner;
import manager.Manager;
import manager.Factory;
import book.Book;
import great.*;
import student.Student;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.doit();
	}
	Manager[] mgrs = {new Manager(), new Manager(), new GreatQuizMgr()};
	void doit() {
		readAll();
		Scanner keyin = new Scanner(System.in);
		int menu=0;
		while (menu < 4) {
			System.out.print("(1)학생  (2)책  (3)위인  (4)종료..  ");
			menu = keyin.nextInt();
			keyin.nextLine();
			if (menu <= 0 || menu > 3) break;
			mgrs[menu-1].menu(keyin);
		}
		GreatQuizMgr quizMgr = (GreatQuizMgr)mgrs[2];
		quizMgr.runQuiz(keyin);
		System.out.println("Bye!!");
	}
	void readAll() {
		mgrs[0].readFile("students.txt", new Factory() {
			@Override 
			public Student create() {
				return new Student();
			}
		});
		mgrs[1].readFile("book.txt", new Factory() {
			@Override 
			public Book create() {
				return new Book();
			}
		});
		mgrs[2].readFile("great.txt", new Factory() {
			@Override 
			public Great create() {
				return new Great();
			}
		});
	}
}

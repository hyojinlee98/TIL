package crud;

import java.util.ArrayList;
import java.util.Scanner;
import manager.*;

public abstract class CrudMgr<T extends Crudable> extends Manager<T> implements Factory<T> {
	Scanner keyin = new Scanner(System.in);
	public void init(String filename) {
		keyin = new Scanner(System.in);
		readAll(filename, this);
	}
	public boolean menu() {
		int m;
		System.out.print("(1) 전체출력  (2) 검색   (3) 추가   (4) 삭제   (5) 변경   (6) 종료.. ");
		m = keyin.nextInt();
		switch(m) {
		case 1: 
			printAll();
			break;
		case 2: 
			search();
			break;
		case 3: 
			addOne();
			break;
		case 4:
			remove();		// 건국시조인 왕, 대출중인 책 또는 학생은 삭제 불가
			break;
		case 5:
			update();
			break;
		default:
			return false;
		}	
		return true;
	}

	void search() {
		System.out.print("검색키: ");
		String kwd = keyin.nextLine().trim();
		if (kwd.length() == 0)
			kwd = keyin.nextLine().trim();	
		ArrayList<T> foundList = findAll(kwd);
		printList(foundList, true);
	}
	private boolean addOne() {
		System.out.print("추가할 학번/이름/제목 : ");
		String kwd = keyin.nextLine().trim();
		if (kwd.length() == 0)
			kwd = keyin.nextLine().trim();	
		T g = find(kwd);
		if (g != null) {
			System.out.println("있는 학번/이름/제목입니다.");
			return false;
		}
		g = create();
		g.readOnline(kwd, keyin);
		mList.add(g);
		return true;
	}
	private boolean remove() {
		T g = selectOne();
		if (g == null) {
			System.out.println("없는 학번/이름/제목입니다.");
			return false;
		}
		System.out.println(g.getName() + " 삭제...");
		if (!g.checkRemove()) {
			System.out.println(g.getName() + " 삭제 불가");
			return false;
		}
		remove(g);
		return true;
	}
	boolean update() {
		T g = selectOne();
		if (g == null) {
			System.out.println("없는 학번/이름/제목입니다.");
			return false;
		}
		System.out.println(g.getName() + " 수정...");
		g.update(keyin);
		return true;
	}

	T selectOne() {
		System.out.print("수정/삭제할 학번/이름/제목 : ");
		String kwd = keyin.nextLine().trim();
		if (kwd.length() == 0)
			kwd = keyin.nextLine().trim();	
		ArrayList<T> foundList = findAll(kwd);
		if (foundList.size() == 0)
			return null;
		printList(foundList, false);
		if (foundList.size() == 1) // 검색결과가 한 개면
			return foundList.get(0);
		System.out.print("번호선택: ");
		int i = keyin.nextInt();
		keyin.nextLine();
		if (i < 1 || i > foundList.size())
			return null;
		return foundList.get(i-1);
	}
}

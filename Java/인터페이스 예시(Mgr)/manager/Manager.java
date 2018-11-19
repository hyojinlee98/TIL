package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Manager {
	protected ArrayList<Manageable> mList = new ArrayList<>();
	public void readFile(String filename, Factory fac) {
		Manageable m = null;
		Scanner fs = openFile(filename);
		fs.nextLine();
		while (fs.hasNext()) {
			m = fac.create();
			m.read(fs);
			if (mList.contains(m))
				continue;
			mList.add(m);
		}
		fs.close();
	}
	protected void printAll() {
		for (Manageable m : mList)
			m.print();
	}
	private Scanner openFile(String filename) {
	    Scanner scan = null;
	    try{
	    	scan = new Scanner(new File(filename));
	    } catch(FileNotFoundException e){
	    	throw new RuntimeException(e);
	    }
	    return scan;
	}
	protected void search(String kwd) {
		for (Manageable m : mList) {
			if (m.compare(kwd))
				m.print();
		}
	}
	public void menu(Scanner keyin) {
		System.out.print("(1)전체출력   (2)검색   (3)종료..  ");
		int m = keyin.nextInt();
		if (m == 1) 
			printAll();
		else if (m == 2) {
			String kwd = null;
			while (true) {
				System.out.print("검색 키워드 : ");
				kwd = keyin.next();
				if (kwd.equals("end")) break;
				search(kwd);
			}
		}
	}
}


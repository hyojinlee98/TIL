package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import student.Student;

public class Manager<E extends Manageable> {
	public ArrayList<E> mList = new ArrayList<>();
	public void remove(E m) {
		mList.remove(m);
	}
	public void readAll(String filename, Factory<E> fac) {
		Scanner fileIn = Manager.fileOpen(filename);
		E m = null;
		fileIn.nextLine();
		while (fileIn.hasNext()) {
			m = fac.create();
			m.read(fileIn);
			mList.add(m);
		}
		if (m instanceof Student) {
			fileIn = Manager.fileOpen("lend.txt");
			Student st = null;
			while (fileIn.hasNext()) {
				String Sid = fileIn.next();
				st = (Student)find(Sid);
				st.readLend(fileIn);
			}
		}
		fileIn.close();
	}
	public void printAll() {
		for (E e : mList) {
			e.print();
		}
	}
	public static Scanner fileOpen(String filename) {
		File f = new File(filename);
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return fileIn;
	}
	public E find(int n) {
		for (E m : mList)
			if (m.compare(n)) 
				return m;
		return null;
	}
	public E find(String kwd) {
		for (E m : mList)
			if (m.compare(kwd)) 
				return m;
		return null;
	}
	public ArrayList<E> findAll(String kwd) {
		ArrayList<E> list = new ArrayList<>();
		for (E m : mList)
			if (m.compare(kwd)) 
				list.add(m);
		return list;
	}
	public void printList(ArrayList<E> mlist, boolean bAll) {
		int i = 1;
		for (E m : mlist) {
			if (bAll)
				m.print();
			else
				System.out.printf("[%d] %s\n", i++, m.getName());
		}
	}
}

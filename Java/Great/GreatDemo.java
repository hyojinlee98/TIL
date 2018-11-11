package great;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GreatDemo {
	public static void main(String[] args) {
		GreatDemo demo = new GreatDemo();
		demo.doit();
	}
	ArrayList<Great> greatList = new ArrayList<>();
	HashMap<String, Great> nameMap = new HashMap<>();
	void doit() {
		Scanner s = fileOpen("great-inherit-enum.txt");
		Great g = null;
		int type = 0;
		while (s.hasNext()) {
			type = s.nextInt();
			if (type == 1) g = new Great();
			else if (type == 2) g = new GreatDetail();
			g.read(s);
			greatList.add(g);
			nameMap.put(g.name, g);
		}
		s.close();
		for (Great great : greatList) 
			great.print();
		System.out.println();
		s = new Scanner(System.in);
		search();
		System.out.println();
		String name = null;
		while (true) {
			System.out.print("추가할 위인 : ");
			name = s.next();
			if (name.equals("end"))
				break;
			append(s, name);
		}
		for (Great great : greatList) 
			great.print();
	}
	void search() {
		String kwd = "";
		Scanner keyin = new Scanner(System.in);
		int matchType = 0;
		while (true) {
			System.out.print("키워드 : ");
			kwd = keyin.next();
			if (kwd.equals("end")) 
				break;
			else if (nameMap.containsKey(kwd))
				matchType = MatchType.getNum("Name");
			else if (kwd.matches(".?\\d+"))
				matchType = MatchType.getNum("Year");
			else if (kwd.equals("M") || kwd.equals("F")) 
				matchType = MatchType.getNum("Gender");
			else matchType = MatchType.getNum("Achieved");
			System.out.printf("[%s 검색 : kwd=%s]\n", MatchType.getValue(matchType), kwd);
			for (Great g2 : greatList)
				if (g2.match(matchType, kwd))
					g2.print(matchType, kwd);
		}
	}
	void append(Scanner s, String name) {
		if (nameMap.containsKey(name)) {
			System.out.println("이미 있는 이름입니다");
			return;
		}
		Great g = new Great(name);
		g.appendRead(s);
		System.out.print("저장할까요?(저장 : Y, 취소 : N) ");
		if (s.next().equals("Y"))
			greatList.add(g);
	}
	Scanner fileOpen(String filename) {
		Scanner s = null;
		try {
			s = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return s;
	}
}


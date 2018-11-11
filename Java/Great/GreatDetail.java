package great;

import java.util.ArrayList;
import java.util.Scanner;

public class GreatDetail extends Great {
	ArrayList<String> detailsList = new ArrayList<>();
	@Override
	void read(Scanner s) {
		super.read(s);
		String line = null;
		while (true) {
			line = s.nextLine();
			if (line.length() == 0)
				break;
			detailsList.add(line);
		}
	}
	@Override
	void print() {
		super.print();
		for (String str : detailsList)
			System.out.println(str);
	}
	@Override
	void print(int matchType, String kwd) {
		super.print(matchType, kwd);
		for (String str : detailsList) {
			if (matchType != MatchType.getNum("Achieved"))
				System.out.print(str);
			else
				System.out.print(str.replace(kwd, "<<" + kwd + ">>"));
		}
		System.out.println();
	}
	@Override
	boolean match(int matchType, String kwd) {
		if (super.match(matchType, kwd))
			return true;
		for (String s : detailsList)
			return s.contains(kwd);
		return false;
	}
}

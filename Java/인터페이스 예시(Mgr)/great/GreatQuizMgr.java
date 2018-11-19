package great;
import java.util.Scanner;

import manager.*;

public class GreatQuizMgr extends Manager implements Factory {
	@Override
	public Manageable create() {
		return new Great();
	}
	public void runQuiz(Scanner s) {
		int rand;
		String answer;
		Great g;
		while (true) {
			rand = (int) (Math.random()*(mList.size()));
			g = (Great)mList.get(rand);
			System.out.printf("%d ~ %d�⵵ - %s\n=> ", 
						g.bYear, g.dYear, g.achieved);
			answer = s.next();
			if (answer.equals("end")) break;
			else if (answer.equals(g.name))
				System.out.println("�¾ҽ��ϴ�.");
			else 
				System.out.printf("������ %s�Դϴ�.\n", g.name);
		}
	}
}

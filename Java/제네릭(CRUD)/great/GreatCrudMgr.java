package great;

import crud.CrudMgr;
import java.util.Scanner;

public class GreatCrudMgr extends CrudMgr<Great> {
	public void doit() {
		init("great.txt");
	}
	public void runQuiz() {
		Scanner s = new Scanner(System.in);
		int rand;
		String answer;
		Great g;
		while (true) {
			rand = (int) (Math.random()*(mList.size()));
			g = (Great)mList.get(rand);
			g.showQuestion();
			answer = s.next();
			if (answer.equals("end")) break;
			else if (answer.equals(g.name))
				System.out.println("맞았습니다!");
			else 
				System.out.printf("정답은 %s입니다.\n", g.name);
		}
	}
	@Override
	public Great create() {
		return new Great();
	}
}

package manager;
import java.util.Scanner;

public interface Manageable {
	void read(Scanner scan);
	void print();
	boolean compare(String kwd);
}

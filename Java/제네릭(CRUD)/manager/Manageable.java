package manager;
import java.util.Scanner;

public interface Manageable {
	void read(Scanner scan);
	String getName();
	void print();
	boolean compare(int n);
	boolean compare(String kwd);
}

package crud;

import java.util.Scanner;
import manager.Manageable;

public interface Crudable extends Manageable{
	boolean readOnline(String name, Scanner keyin);
	boolean update(Scanner keyin);
	boolean checkRemove();
}

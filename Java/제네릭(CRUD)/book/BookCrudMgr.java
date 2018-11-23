package book;

import java.util.ArrayList;
import crud.CrudMgr;

public class BookCrudMgr extends CrudMgr<Book> {
	public static ArrayList<Book> blist = new ArrayList<>();
	public void doit() {
		init("book.txt");
		blist = mList;
	}
	@Override
	public Book create() {
		return new Book();
	}
}

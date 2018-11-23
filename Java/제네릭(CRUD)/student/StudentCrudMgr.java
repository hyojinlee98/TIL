package student;

import crud.CrudMgr;

public class StudentCrudMgr extends CrudMgr<Student> {
	public void doit() {
		init("students.txt");
	}
	@Override
	public Student create() {
		return new Student();
	}
}

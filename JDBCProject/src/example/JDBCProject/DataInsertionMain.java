package example.JDBCProject;

public class DataInsertionMain {

	public static void main(String[] args) {
		DaoInterface<Student, Integer> daoRef = new StudentDao();
		Student std = new Student(4, "Cristiano Ronaldo", "Portugal");
		daoRef.create(std);
	}
}

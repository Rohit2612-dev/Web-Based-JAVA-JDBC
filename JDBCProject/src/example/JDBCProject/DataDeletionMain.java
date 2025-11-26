package example.JDBCProject;

public class DataDeletionMain {

	public static void main(String[] args) {
		
		DaoInterface<Student, Integer> daoRef = new StudentDao();
		daoRef.deleteOne(4);
	}
}

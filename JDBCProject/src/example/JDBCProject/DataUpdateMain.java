package example.JDBCProject;

public class DataUpdateMain {

	public static void main(String[] args) {
		
		DaoInterface<Student, Integer> daoRef = new StudentDao();
		Student foundStudent = daoRef.getOne(4);
		if(foundStudent != null) {
			foundStudent.setName("Thomas Shelby");
			foundStudent.setCity("Birmingham");
			daoRef.update(foundStudent);
		}
		else {
			System.out.println("Student given Id does not Exist!");
		}
		

	}

}

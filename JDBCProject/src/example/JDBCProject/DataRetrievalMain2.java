package example.JDBCProject;

import java.util.Collection;

public class DataRetrievalMain2 {

	public static void main(String[] args) {
		
		DaoInterface<Student, Integer> daoRef = new StudentDao();
		Collection<Student> allStudents=daoRef.getAll();
		for(Student st: allStudents) {
		System.out.println(st);
		//allStudents.stream().forEach(student -> System.out.println(student)); //Calling by lambda function..optional
		System.out.println("==============================================");
		Student std = daoRef.getOne(3);
		if(std != null)
			System.out.println(std);
		else
			System.out.println("Student with given ID does not exist..");
		}
	}

}
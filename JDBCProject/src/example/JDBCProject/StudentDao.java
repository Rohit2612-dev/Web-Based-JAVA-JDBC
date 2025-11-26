package example.JDBCProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao implements DaoInterface<Student, Integer>{
	
	@Override
	public Collection<Student> getAll() {
		
		Collection<Student> allStudents = new ArrayList<>();
		String sqlQuery="select stud_name,studt_city,stud_id from students";
		
		try(
			Connection dbConnection = JdbcUtils.getConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery)
		){
			
			while (rs.next()) {  //it is call 
				String name = rs.getNString(1); // name
				String city = rs.getNString(2); // city
				int id = rs .getInt(3); // Id
				
//				System.out.println(id+ ","+name+","+city);
				Student studentObj = new Student(id, name, city);
				allStudents.add(studentObj);
				}
		}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		
		return allStudents;
	}
	
	@Override
	public Student getOne(Integer StudentId) {
		
		Student foundStudent = null;
		String sqlQuery = "Select stud_name, studt_city, stud_id from students where stud_id =?";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
			//Substitute studentId in place of '?'
			pstmt.setInt(1, StudentId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString(1); // name
				String city = rs.getString(2); // city to read string
				int id = rs .getInt(3); // Id  to read int
			foundStudent = new Student (id,name,city);
				
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		return foundStudent;
	}

	@Override
	public void create(Student studentObj) {
		
		//This method accepts a student object and stores it as a record into student table.
		String sqlQuery = "insert into students values(? ,?, ?)";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
			//Fetching a value from student object
			int id = studentObj.getStudentId();
			String name = studentObj.getName();
			String city = studentObj.getCity();
			//Substitute these values in place of '?'
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			int count = pstmt.executeUpdate();
			System.out.println(count+ "record inserted..");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	@Override
	public void update(Student modifiedStudentObj) {
		//This method receives modified state of the student object and
		//Reflects that state back to DB to complete the UPDATE operation.
		String sqlQuery = "update students set stud_name = ?, studt_city= ? WHERE stud_id = ?";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
			//Fetching a value from student object
			int id = modifiedStudentObj.getStudentId();
			String name = modifiedStudentObj.getName();
			String city = modifiedStudentObj.getCity();
			//Substitute these values in place of '?'
			pstmt.setInt(3, id);
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			
			int count = pstmt.executeUpdate();
			System.out.println(count +"Record Updated...");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteOne (Integer StudentId) {
		String sqlQuery = "Delete from students WHERE stud_id = ?";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
			
			pstmt.setInt(1, StudentId);
			int count = pstmt.executeUpdate();
			if (count !=0)
				System.out.println(count+ "Record Deleted..");
			else
				System.out.println("Student not found ..");
			
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}

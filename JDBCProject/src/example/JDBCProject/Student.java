package example.JDBCProject;

public class Student {
	private int StudentId;
	private String name;
	private  String city;
	
	public Student() {
		
	}
	
	public Student(int studentId, String name, String city) {
		super();
		StudentId = studentId;
		this.name = name;
		this.city = city;
	}
	
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", name=" + name + ", city=" + city + "]";
	}

	
}

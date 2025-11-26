import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRetrievalMain 
{

	public static void main(String[] args) 
	{
		//program to retrieve data from DB using select query and display it
		// 1Load the driver
		
		String driverClass="com.mysql.cj.jdbc.Driver";
		try 
		{
			Class.forName(driverClass);
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2 establish connection
		String connectionUrl="jdbc:mysql://localhost:3306/cdac?useSSL=false";
		String userId="root";
		String password="root";
		
		Connection dbConnection=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try 
		{
			dbConnection=DriverManager.getConnection(connectionUrl, userId, password);
			System.out.println("connected to DB");
			
			//3 obtain some Statement
			stmt=dbConnection.createStatement();
			
			
			//4 execute sql query
			String sqlQuery="select stud_name,studt_city,stud_id from students";
			rs=stmt.executeQuery(sqlQuery);
			
			// 5 Perform navigation 
			
			while (rs.next()) {  //it is call 
				String name = rs.getNString(1); // name
				String city = rs.getNString(2); // city
				int id = rs .getInt(3); // Id
				System.out.println(id+ ","+name+","+city);
				}
		
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

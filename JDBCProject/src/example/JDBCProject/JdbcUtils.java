package example.JDBCProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	
	public static Connection getConnection() throws SQLException {
		//This method is used to establish connection with DB and return the same.
		String connectionUrl="jdbc:mysql://localhost:3306/cdac?useSSL=false";
		String userId="root";
		String password="root";
		Connection dbConnection = DriverManager.getConnection(connectionUrl, userId, password);
		return dbConnection;
	}
}

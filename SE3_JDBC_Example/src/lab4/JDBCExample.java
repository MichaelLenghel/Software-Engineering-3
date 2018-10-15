package lab4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
	
	public static void main(String[] args) {
		
		try {
			// load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// get a connection to the database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			
			// get a statement from the connection
			Statement stmt = conn.createStatement();
			
			//String sql = "SELECT * FROM customer where customerName like 'A%' order by customerName";
			// execute the query
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
			
			while(rs.next())
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			
			// close the result set, statement and the connection
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException se) {
			System.out.println("SQLException:");
			
			// loop through the SQL Exceptions
			while(se != null) {
				System.out.println("State:" + se.getSQLState());
				System.out.println("Message:" + se.getMessage());
				System.out.println("Error:" + se.getErrorCode());
				
				se = se.getNextException();		
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
package lab4;

import java.util.Vector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlCustomerDao implements CustomerDao {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String database = "jdbc:mysql://localhost:3306/test";
	private static final String username = "root";
	private static final String password = "";
	
	private Vector<Customer> customers = new Vector<>();
	
	private Connection getConnection() {
		
		Connection conn = null;
		
		try {
			// load the database driver
			Class.forName(driver);
			
			// get a connection to the database
			conn = DriverManager.getConnection(database, username, password);
			
		} catch(SQLException se) {
			System.out.println("SQL Exception");
			
			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	@Override
	public Vector<Customer> selectCustomerByName(String name) {
		
		String query = "SELECT * FROM customer WHERE " + name + " = " + "customerName"; 
				
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				System.out.println(rs.getString("customerName"));
				
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return null;
		
		
		
	}

	@Override
	public Customer findCustomerById(int customerNumber) {
		String query = "SELECT * FROM customer WHERE " + customerNumber + " = " + "customerNumber";
		Customer cust = null;
		
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				cust = new Customer(		rs.getInt(1),
											rs.getString(2),
											rs.getString(3),
											rs.getString(4),
											rs.getString(5),
											rs.getString(6),
											rs.getString(7),
											rs.getString(8),
											rs.getString(9),
											rs.getString(10),
											rs.getString(11),
											rs.getInt(12),
											rs.getDouble(13)		);
				
				customers.add(cust);
//				System.out.println(rs.getString("customerNumber"));
//				System.out.println(rs.getString("customerName"));
				
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return cust;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (Customer c : customers) {
			sb.append(c);
		}
		return sb.toString();
	}
}

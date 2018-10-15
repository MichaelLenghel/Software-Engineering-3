package lab4;

public class JDBCExercise {

	public static void main(String[] args) {
		MySqlCustomerDao cust = new MySqlCustomerDao();
		MySqlCustomerDao mini = new MySqlCustomerDao();
		
		cust.findCustomerById(347);
//		mini.selectCustomerByName("Mini");
		System.out.println(cust);
		
		
	}

}

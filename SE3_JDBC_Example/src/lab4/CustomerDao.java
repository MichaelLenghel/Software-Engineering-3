package lab4;

import java.util.Vector;

public interface CustomerDao {
	public Vector<Customer> selectCustomerByName(String name);
	public Customer findCustomerById(int customerNumber);
}

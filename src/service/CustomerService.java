package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {

	private Map<String, Customer> customers;

	private static final CustomerService instance = new CustomerService();

	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}

	public static CustomerService getInstance() {
		return instance;
	}

	// -----------------------------------------------------------
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}

	public Customer findCustomer(String id) {
		if (id != null)
			return (customers.get(id.toLowerCase()));
		else
			return null;
	}

	public Customer login(String id, String password) {
		try {
			Customer customer = findCustomer(id);
			if (id != null && password != null && customer.getPassword().trim().equals(password))
				return customer;
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

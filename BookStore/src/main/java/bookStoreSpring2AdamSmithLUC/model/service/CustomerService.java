package bookStoreSpring2AdamSmithLUC.model.service;


import bookStoreSpring2AdamSmithLUC.model.customer.Customer;

public class CustomerService {
	private Customer customer;
	
	public void setCustomer(Customer customer) {
	    this.customer = customer;
	  }
	
	public Customer getCustomer() {
		return customer;
	}
	
}

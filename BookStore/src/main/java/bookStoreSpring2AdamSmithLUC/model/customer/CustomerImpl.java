package bookStoreSpring2AdamSmithLUC.model.customer;

import java.util.ArrayList;
import java.util.List;

import bookStoreSpring2AdamSmithLUC.model.customer.Address;
import bookStoreSpring2AdamSmithLUC.model.order.Order;


public class CustomerImpl implements Customer {
	private String customerId;
	private String lastName;
	private String firstName;
	private Address billingAddress;
	private Address shippingAddress;
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String id) {
		this.customerId = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
}

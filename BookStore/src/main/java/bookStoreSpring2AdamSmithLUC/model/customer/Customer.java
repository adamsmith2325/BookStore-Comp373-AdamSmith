package bookStoreSpring2AdamSmithLUC.model.customer;

import java.util.List;

import bookStoreSpring2AdamSmithLUC.model.order.Order;

public interface Customer {
	public List<Order> getOrders();
	public void setOrders(List<Order> orders);
	public Address getBillingAddress();
	public void setBillingAddress(Address billingAddress);
	public Address getShippingAddress();
	public void setShippingAddress(Address shippingAddress);
	public void addOrder(Order order);
	public String getCustomerId();
	public void setCustomerId(String id);
	public String getLastName();
	public void setLastName(String lastName);
	public String getFirstName();
	public void setFirstName(String firstName);
}

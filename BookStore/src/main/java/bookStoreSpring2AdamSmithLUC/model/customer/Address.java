package bookStoreSpring2AdamSmithLUC.model.customer;

public interface Address {
	public String getAddressId();
	public void setAddressId(String addressId);
	public String getStreet();
	public void setStreet(String street);
	public String getUnit();
	public void setUnit(String unit);
	public String getCity();
	public void setCity(String city);
	public String getState();
	public void setState(String state);
	public String getZip();
	public void setZip(String zip);
}

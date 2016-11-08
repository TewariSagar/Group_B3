package warehouse_system.orders;

public class Order {
	/**
	 * This is just for testing
	 */
	public final String ID;
	public String name;
	public int quantity;
	public String address;
	// add more order information here

	public Order(String ID, String name, int quantity, String address){
		this.ID = ID;
		this.name = name;
		this.quantity = quantity;
		this.address = address;
	}
	
}

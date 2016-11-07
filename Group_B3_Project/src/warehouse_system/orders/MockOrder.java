package warehouse_system.orders;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class MockOrder implements Order, Report, Tickable{
	
	public final String ID;
	public String address;
	// add more order information here
	
	public MockOrder(String ID, String address){
		this.ID = ID;
		this.address = address;
	}

	@Override
	public void tick(int tick) {
		printEvent("received.");
		
	}
	
	@Override
	public void printEvent(String event) {
		System.out.println("Order " + ID + ": " + event);
	}
	
}

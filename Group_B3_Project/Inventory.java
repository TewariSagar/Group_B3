package warehouse_system.inventory;

import warehouse_system.Report;
import warehouse_system.Tickable;
import warehouse_system.floor.Floor;
import warehouse_system.orders.Orders;

public class Inventory implements Tickable, Report{
	
	private SimulatedDatabase database;
	private Floor F;
	private Orders O;
	
	public Inventory(Floor F, Orders O){		// you can add parameters for constructor
		this.F = F;
		this.O=O;
		database = new SimulatedDatabase(F,O);
	}
	
	public String itemAvailable(Orders O){
	// depends on order provide the name and the quantity of the Item;
	// if order quantity <= then inventory quantity, return "available", else return "not availble".
		return "availble"; 
	}
	
	public boolean itemreplenishment(Orders O){
		
		// after shipping the order item, determine whether the item need to do replenishment.
		// if need to do replenishment return true, else return false 
		return true;
	}
	
	
	@Override
	public void tick(int clk) {
		Item mockItem1 = new Item(01, "abc", 100, new int[]{1,2,3},50, 01, 5);
		database.addquantity(mockItem1,mockItem1.getquantity());
		printEvent("Inventory adding Item1");
		
		Item I = (Item) database.get(mockItem1.getId());	
		
	}
	
	@Override
	public void printEvent(String event) {
		System.out.println("Inventory: " + event);	
		
	}
	
	
}


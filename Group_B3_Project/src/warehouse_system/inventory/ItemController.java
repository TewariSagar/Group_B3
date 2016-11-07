package warehouse_system.inventory;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class ItemController implements Report, Tickable{
	/**
	 * This works as the inventory subsystem
	 */
	
	InventoryDatabase database;
	
	public ItemController(){
		database = new InventoryDatabase();
	}
	
	public ItemController(InventoryDatabase database){
		this.database = database;
	}
	
	@Override
	public void printEvent(String event) {
		System.out.println("ItemController: " + event);	
	}

	@Override
	public void tick(int tick) {
		printEvent("...");
	}
	
}


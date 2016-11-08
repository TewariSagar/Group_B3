package warehouse_system.inventory;

import java.util.HashMap;

import warehouse_system.Report;
import warehouse_system.orders.Order;

public class ItemController {
	/**
	 * This works as the inventory subsystem
	 */
	private HashMap<String, Item> inventory;

	public ItemController() {
		inventory = new HashMap<String, Item>();
	}

	public ItemController(HashMap<String, Item> database) {
		this.inventory = database;
	}
	
	public void addItem(Item i){
		inventory.put(i.name, i);
	}

	public boolean itemAvailable(Order o) {
		if (!inventory.containsKey(o.name))
			return false;
		return inventory.get(o.name).quantity >= o.quantity;
	}

}

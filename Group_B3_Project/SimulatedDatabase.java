package warehouse_system.inventory;

import java.util.HashMap;

import warehouse_system.floor.Floor;
import warehouse_system.floor.Shelf;
import warehouse_system.orders.Orders;

public class SimulatedDatabase extends HashMap{
	int itemquantityMax=100;
	private Floor F;
	private Orders O;
	
	public SimulatedDatabase(Floor f, Orders O) {
		this.F = f;
		this.O=O;
	}
	
	public void addquantity(Item newItem, int quantity){
	
		// if itemreplenishment(Orders O), the quantity of the item should be add.
	}
	
	public void shippingItem(Item newItem, int quantity){
		
		// if itemAvailable(Orders O), the quantity of the Item should be reduce.
		// then identify itemreplenishment(Orders O), whether it should add the quantity of the item or not
	}

	
	public Shelf findShelf(Item item){
		int shelfID = item.getShelfID();
		return F.getShelves().get(shelfID);
	}

	
	
	
}


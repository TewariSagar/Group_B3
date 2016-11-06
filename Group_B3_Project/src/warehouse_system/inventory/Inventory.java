package warehouse_system.inventory;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class Inventory implements Tickable, Report{
	
	public Inventory(){		// you can add parameters for constructor
		
	}
	
	@Override
	public void tick(int clk) {
		printEvent();
		
	}
	
	@Override
	public void printEvent() {
		String events = "to print what events are happening";
		System.out.println("Inventory: " + events);	
		
	}
	
}


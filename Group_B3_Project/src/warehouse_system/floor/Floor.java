package warehouse_system.floor;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class Floor implements Tickable, Report{
	
	public Floor(){		// you can add parameters for constructor
		
	}

	@Override
	public void tick(int clk) {
		printEvent();
		
	}
	
	@Override
	public void printEvent() {
		String events = "to print what events are happening";
		System.out.println("Floor: " + events);	
		
	}

}

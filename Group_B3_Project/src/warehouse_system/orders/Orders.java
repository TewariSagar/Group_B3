package warehouse_system.orders;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class Orders implements Tickable, Report{
	
	public Orders(){		// you can add parameters for constructor
		
	}

	@Override
	public void tick(int clk) {
		printEvent();
		
	}
	
	@Override
	public void printEvent() {
		String events = "to print what events are happening";
		System.out.println("Orders: " + events);	
		
	}

}

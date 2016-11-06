package warehouse_system.belt;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class Belt implements Tickable, Report{
	
	public Belt(){		// you can add parameters for constructor
		
	}

	@Override
	public void tick(int clk) {
		printEvent();
		
	}

	@Override
	public void printEvent() {
		String events = "to print what events are happening";
		System.out.println("Belt: " + events);	
		
	}

}

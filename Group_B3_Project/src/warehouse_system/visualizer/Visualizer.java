package warehouse_system.visualizer;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class Visualizer implements Tickable, Report{
	
	public Visualizer(){		// you can add parameters for constructor
		
	}
	
	@Override
	public void tick(int clk) {
		printEvent();
		
	}
	
	@Override
	public void printEvent() {
		String events = "to print what events are happening";
		System.out.println("Visualizer: " + events);	
		
	}
}

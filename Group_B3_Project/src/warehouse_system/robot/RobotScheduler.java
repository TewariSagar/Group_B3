package warehouse_system.robot;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class RobotScheduler implements Tickable, Report{
	
	public RobotScheduler(){		// you can add parameters for constructor
		
	}

	@Override
	public void tick(int clk) {
		printEvent();
		
	}
	
	@Override
	public void printEvent() {
		String events = "to print what events are happening";
		System.out.println("RobotScheduler: " + events);	
		
	}

}

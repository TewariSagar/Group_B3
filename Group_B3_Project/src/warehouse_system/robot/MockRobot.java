package warehouse_system.robot;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class MockRobot implements Robot, Tickable, Report{
	
	public final String ID;
	public boolean lowBattery = false;
	public boolean carrying = false;
	// add more robot attributes here
	
	public MockRobot(String ID){
		this.ID = ID;
	}

	@Override
	public void tick(int tick) {
		printEvent("it's doing something...");
		
	}

	@Override
	public void printEvent(String event) {
		System.out.println("Robot " + ID + ": " + event);
	}
	
}

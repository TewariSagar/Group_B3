package warehouse_system.robot;

import java.util.ArrayList;

import warehouse_system.floor.MockFloor.Directions;


public class MockRobot implements Robot{
	/**
	 * This is just for testing
	 */
	public final String ID;
	public boolean lowBattery = false;
	public boolean carrying = false;
	public boolean idle = true;
	public int x, y;
	
	private ArrayList<Directions> route;
	// add more robot attributes here
	
	public MockRobot(String ID){
		this.ID = ID;
	}

	@Override
	public boolean isIdle() {
		return idle;
	}
	
	@Override
	public void setIdle(boolean idle) {
		this.idle = idle;
	}

	@Override
	public void setRoute(ArrayList<Directions> route) {
		this.route = route;
	}

	@Override
	public String getID() {
		return ID;
	}

}

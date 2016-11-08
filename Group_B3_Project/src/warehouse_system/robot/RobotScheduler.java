package warehouse_system.robot;

import java.util.ArrayList;

import warehouse_system.Report;
import warehouse_system.Tickable;
import warehouse_system.floor.Floor;
import warehouse_system.orders.Order;

public class RobotScheduler implements Tickable, Report {
	/**
	 * This works as the robot control subsystem: 1. Creating instances of Robot
	 * and place them to locations in the warehouse (with Floor); 2. OrderSystem
	 * would ask it to move a shelf containing the needed items to the picking
	 * station (with OrderSystem); 3. It can ask ItemController for the location
	 * of the shelf containing the needed items (with ItemController); 4. It can
	 * find an available robot and plan a route to the shelf containing the
	 * needed items (this shelf should be reserved); 5. Floor can provide routes
	 * for the robot: route 1: from the robot to the shelf containing the needed
	 * items route 2: from the shelf to the picking station route 3: from the
	 * picking station to an available place to drop the shelf
	 */
	private ArrayList<Robot> robots;
	
	private Floor F;
	
	public RobotScheduler(Floor F) {
		this.F = F;
		robots = new ArrayList<Robot>();
	}

	public RobotScheduler(ArrayList<Robot> robots) {
		this.robots = robots;
		// place robots to locations in the warehouse
		robots.forEach(r -> F.placeRobot(r));
		// report placement event
	}

	public void addRobot(Robot r) {
		robots.add(r);
		// place the robot to locations in the warehouse
		F.placeRobot(r);
		// report placement event
	}

	@Override
	public void tick(int tick) {
		robots.forEach(r -> F.placeRobot(r));
	}

	public Robot finaAvailableRobot() {
		for (Robot r : robots){
			if (r.isIdle()){
				r.setIdle(false);
				return r;
			}
		}
		printEvent("There's no robot available right now.");
		return null;
	}

	public boolean fromRobotToShelf(Order o) {
		Robot r = finaAvailableRobot();
		if (r.equals(null))
			return false;
		// plan a route for the robot from itself location to the shelf
		printEvent("robot " + r.getID() + " is going to find the shelf containing " + o.name);
		return true;
	}
	
	public void fromShelfToPick(Robot r){
		// plan a route for the robot from the shelf to picking station
	}
	
	public void fromPickToShelf(Robot r){
		// plan a route for the robot from picking station to the shelf (which is reserved)
	}

	@Override
	public void printEvent(String event) {
		System.out.println("RobotScheduler: " + event);
	}

}

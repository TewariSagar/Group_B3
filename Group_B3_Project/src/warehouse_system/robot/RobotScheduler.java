package warehouse_system.robot;

import java.util.ArrayList;

import warehouse_system.Tickable;

public class RobotScheduler implements Tickable{
	/**
	 * This works as the robot control subsystem
	 */
	
	private ArrayList<Robot> robots;
	
	public RobotScheduler(){
		robots = new ArrayList<Robot>();
	}
	
	public RobotScheduler(ArrayList<Robot> robots){
		this.robots = robots;
	}

	@Override
	public void tick(int tick) {
		robots.forEach(r -> ((Tickable)r).tick(tick));
	}
	
	public void addRobot(Robot r){
		robots.add(r);
	}

}

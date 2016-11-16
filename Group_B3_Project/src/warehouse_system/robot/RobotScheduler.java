package warehouse_system.robot;

import java.util.ArrayList;

import warehouse_system.Tickable;
import warehouse_system.floor.Point;
/**
 * 
 * @author Wei Gui
 *
 */
public class RobotScheduler implements Tickable{
	/**
	 * This works as the robot control subsystem
	 */
	public ArrayList<Robot> robots;//for testing only
	
	/**
	 * @param Robotnum Initial Robot number
	 */
	public RobotScheduler(int Robotnum){
		robots = new ArrayList<Robot>();
		for(int a=0;a<Robotnum;a++) {
			Point temp = new Point(0,0);
			addRobot(new MockRobot(Integer.toString(a),temp,this));
		}
	}
	
	/**
	 * @param robots Initial Robot ArrayList
	 */
	public RobotScheduler(ArrayList<Robot> robots){
		this.robots = robots;
	}

	/* 
	 * @see warehouse_system.Tickable#tick(int)
	 */
	@Override
	public void tick(int tick) {
		robots.forEach(r -> ((Tickable)r).tick(tick));
	}
	
	/**
	 * @param r Add A new Robot, use new Robot() here.
	 */
	public void addRobot(Robot r){
		robots.add(r);
	}
	/**
	 * @return get a robot that is currently available
	 */
	public Robot getAvailableRobot() {
		for(Robot r:robots) {
			if(((MockRobot)r).isBusy()==false) {
				return (Robot)r;
			}
		}
		//All Robots are busy now
		return null;
	}
	/**
	 * @param p expected collision point
	 * @return true when collision happened
	 */
	public boolean collisioncheck(Point p) {
		for(Robot r:robots) {
			if(((MockRobot)r).getPOS().getX()==p.getX()&&((MockRobot)r).getPOS().getY()==p.getY()) {
				return true;
			}
		}
		return false;
	}

}

package warehouse_system.robot;

import java.util.ArrayList;

import warehouse_system.Tickable;
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
	
	public RobotScheduler(int Robotnum){
		robots = new ArrayList<Robot>();
		for(int a=0;a<Robotnum;a++) {
			addRobot(new MockRobot(Integer.toString(a),new Position(0,0),this));
		}
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
	public Robot getAvailableRobot() {
		for(Robot r:robots) {
			if(((MockRobot)r).isBusy()==false) {
				return (Robot)r;
			}
		}
		//All Robots are busy now
		return null;
	}
	public boolean collisioncheck(Position p) {
		for(Robot r:robots) {
			if(((MockRobot)r).getPOS().getx()==p.getx()&&((MockRobot)r).getPOS().gety()==p.gety()) {
				return true;
			}
		}
		return false;
	}

}

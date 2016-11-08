package warehouse_system.floor;

import java.util.ArrayList;

import warehouse_system.floor.MockFloor.Directions;
import warehouse_system.robot.Robot;

public interface Floor{
	
	public static final int width = 60, height = 30;				// unit: grid
	public static final int gridSize = 10;							// [10 pixel x 10 pixel] each grid
	
	public ArrayList<Directions> getRoute(int[] start, int[] end);
	public void placeRobot(Robot r);
	
}

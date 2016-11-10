package warehouse_system.floor;

import java.util.ArrayList;
/**
 * 
 * @author josephtleiferman
 *
 */
public interface Floor {
	
	public Point getLocation(String l);
	public boolean objectAt(Point l);
	public void updateObjectLocation(String object, Point location);
	public ArrayList<MockFloor.Directions> getRoute(Point start, Point end);
	public void placeRobot(Point l);
}

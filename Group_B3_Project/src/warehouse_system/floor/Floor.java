package warehouse_system.floor;

import java.util.ArrayList;

public interface Floor {
	
	public int[] getLocation(String l);
	public boolean objectAt(int[] l);
	public void updateObjectLocation(String object, int[] location);
	public ArrayList<MockFloor.Directions> getRoute(int[] start, int[] end);
	public void placeRobot(int[] l);
}

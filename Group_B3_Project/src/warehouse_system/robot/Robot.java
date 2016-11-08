package warehouse_system.robot;

import java.util.ArrayList;

import warehouse_system.floor.Floor;
import warehouse_system.floor.MockFloor.Directions;

public interface Robot{
	
	public static final int size = Floor.gridSize;
	public boolean isIdle();
	public void setIdle(boolean idle);
	public void setRoute(ArrayList<Directions> route);
	public String getID();
	
}

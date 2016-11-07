package warehouse_system;

import org.junit.Test;

import warehouse_system.belt.Belt;
import warehouse_system.floor.Floor;
import warehouse_system.floor.MockFloor;
import warehouse_system.inventory.ItemController;
import warehouse_system.orders.MockOrder;
import warehouse_system.orders.OrderSystem;
import warehouse_system.robot.MockRobot;
import warehouse_system.robot.RobotScheduler;
import warehouse_system.visualizer.Visualizer;

public class TestMaster {
	
	@Test
	public void test000() {	
		// Doing unit test
		Belt B = new Belt();
		
		Floor F = new MockFloor();
		
		ItemController I = new ItemController();
		
		OrderSystem O = new OrderSystem();
		O.enqueue(new MockOrder("0x01", "Clinton St"));
		O.enqueue(new MockOrder("0x02", "Johnson St"));
		
		RobotScheduler R = new RobotScheduler();
		R.addRobot(new MockRobot("001"));
		R.addRobot(new MockRobot("002"));
		
		Visualizer V = new Visualizer(F);
		
		Master M = new Master(B, F, I, O, R, V);
		M.setLimit(10);
		M.setUnitTime(0);
		M.start();
	}
	
}

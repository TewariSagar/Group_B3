package warehouse_system;

import org.junit.Test;

import warehouse_system.belt.Belt;
import warehouse_system.floor.Floor;
import warehouse_system.floor.MockFloor;
import warehouse_system.inventory.Item;
import warehouse_system.inventory.ItemController;
import warehouse_system.orders.Order;
import warehouse_system.orders.OrderSystem;
import warehouse_system.robot.MockRobot;
import warehouse_system.robot.RobotScheduler;
import warehouse_system.visualizer.Visualizer;

/**
 * 
 * @author Di Huang
 *
 */
public class TestMaster {
	
	@Test
	public void test000() {	
		// Doing unit test
		Belt B = new Belt();
		
		Floor F = new MockFloor();
		
		RobotScheduler R = new RobotScheduler(F);
		R.addRobot(new MockRobot("001"));
		R.addRobot(new MockRobot("002"));
		
		ItemController I = new ItemController();
		I.addItem(new Item("apple", 5, "777"));
		I.addItem(new Item("banana", 5, "778"));
		
		OrderSystem O = new OrderSystem(I, R);
		O.enqueue(new Order("0x01", "apple", 1, "Clinton St"));
		O.enqueue(new Order("0x02", "banana", 2, "Johnson St"));
		
		Visualizer V = new Visualizer(F);
		
		Master M = new Master(B, F, I, O, R, V);
		M.setLimit(10);
		M.setUnitTime(0);
		M.start();
	}
	
}

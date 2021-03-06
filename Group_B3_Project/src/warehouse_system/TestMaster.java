package warehouse_system;

import org.junit.Test;

import warehouse_system.belt.Belt;
import warehouse_system.belt.MockBelt;
import warehouse_system.floor.Floor;
import warehouse_system.floor.MockFloor;
import warehouse_system.floor.Point;
import warehouse_system.inventory.Item;
import warehouse_system.inventory.ItemController;
import warehouse_system.orders.Order;
import warehouse_system.orders.OrderControl;
import warehouse_system.robot.MockRobot;
import warehouse_system.robot.RobotScheduler;
import warehouse_system.visualizer.Visualizer;

/**
 * @author Di Huang
 * @author josephtLeiferman
 * add your name here if you modify this class
 */
public class TestMaster {

	/**
	 * @author Di Huang
	 * @author josephtLeiferman 
	 * This method is for unit testing
	 */
	@Test
	public void test000() {
		Floor F = new MockFloor();
		
		Belt B = new MockBelt(F);

		RobotScheduler R = new RobotScheduler(2);
		Point robotP = new Point(0, 3);
		MockRobot r001 = new MockRobot("001", robotP, R);
		R.addRobot(r001);
		robotP.setPoint(3, 0);
		MockRobot r002 = new MockRobot("002", robotP, R);
		R.addRobot(r002);

		ItemController I = new ItemController();
		I.addItem(new Item("apple", 5, "777"));
		I.addItem(new Item("banana", 5, "778"));

		OrderControl O = new OrderControl(I, R);
		Item testItem1 = new Item("apple", 1, "1");
		Item testItem2 = new Item("banana", 1, "2");

		O.addOrder(new Order(testItem1, 1, "Clinton St"));
		O.addOrder(new Order(testItem2, 1, "Johnson St"));

		Visualizer V = new Visualizer(F);

		Master M = new Master(B, F, I, O, R, V);
		M.setLimit(10);
		M.setUnitTime(0);
		M.start();
	}

}

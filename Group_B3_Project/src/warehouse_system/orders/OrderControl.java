package warehouse_system.orders;

import java.util.LinkedList;

import warehouse_system.Tickable;
import warehouse_system.inventory.ItemController;
import warehouse_system.robot.RobotScheduler;

public class OrderControl implements Tickable {
	
	/**
	 * 
	 * orders are held in a queue
	 * 
	 */
	private LinkedList<Order> orderQueue;
	private ItemController itemController;
	private RobotScheduler robotScheduler;
	

	/**
	 * 
	 * ItemController to check inventory
	 * RobotScheduler to do work after checking inventory
	 * 
	 * @param itemController
	 * @param robotScheduler
	 */
	public OrderControl(ItemController itemController) {
		this.itemController = itemController;
	}
	
	/**
	 * adds an order object to the queue of orders
	 * 
	 * @author charlesc3929
	 * @param orderToBeAdded
	 */
	public void addOrder(_Order orderToBeAdded) {
		orderQueue.add(orderToBeAdded);
	}

	@Override
	public void tick(int tick) {
		if(orderQueue.isEmpty()) {
			System.out.println("There are no orders");
			return;
		}
		
		System.out.println("Order:" + orderQueue.peek().getItemName());
		if(itemController.itemAvailable(Order orderQueue.peek())) {
			orderQueue.poll();
		}
		else {
			System.out.println("There are no orders");
			orderQueue.poll();
		}
	}
}

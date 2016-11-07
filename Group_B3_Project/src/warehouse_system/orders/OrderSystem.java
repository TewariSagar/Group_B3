package warehouse_system.orders;

import java.util.LinkedList;
import java.util.Queue;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class OrderSystem implements Tickable, Report{
	/**
	 * This works as the orders placement subsystem
	 */
	
	private Queue<Order> orderQueue;
	private int lastTick = -2;
	private int delay = 2;				// default: delay = 2 tick
	
	public OrderSystem(){
		orderQueue = new LinkedList<Order>();
	}
	
	public OrderSystem(LinkedList<Order> orderQueue){
		this.orderQueue = orderQueue;
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
	}

	@Override
	public void tick(int tick) {
		if(orderQueue.isEmpty()){
			printEvent("there's no order currently.");
			return;
		}
		if(tick - lastTick < delay){
			return;
		}
		lastTick = tick;
		Order o = orderQueue.poll();
		((Tickable)o).tick(tick);
		
	}

	@Override
	public void printEvent(String event) {
		System.out.println("OrderSystem: " + event);
	}
	
	public boolean hasOrder(){
		return !orderQueue.isEmpty();
	}
	
	public void enqueue(Order o){
		orderQueue.offer(o);
	}
	
	public Order dequeue(){
		return orderQueue.poll();
	}
	
}

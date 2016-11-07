package warehouse_system;

import warehouse_system.belt.Belt;
import warehouse_system.floor.Floor;
import warehouse_system.inventory.ItemController;
import warehouse_system.orders.OrderSystem;
import warehouse_system.robot.RobotScheduler;
import warehouse_system.visualizer.Visualizer;

public class Master implements Runnable {
	/**
	 * 1. Master starts and continues simulation process
	 * 2. Ticking Simulation: Master publishes ticks to other components
	 */
	private int limit = 100;				// default: limit = 100 ticks
	private int unitTime = 1000;			// default: 1 second per tick
	private boolean running = false;
	
	private Belt B;
	private Floor F;
	private ItemController I;
	private OrderSystem O;
	private RobotScheduler R;
	private Visualizer V;
	
	public Master(Belt b, Floor f, ItemController i, OrderSystem o, RobotScheduler r, Visualizer v) {
		B = b;
		F = f;
		I = i;
		O = o;
		R = r;
		V = v;
	}

	@Override
	public void run() {
		int tick = 0;
		while (running && tick < limit) {
			System.out.println(tick + " tick");
			tick(tick);
			System.out.println();
			
			unitTime();
			
			tick++;
		}

	}
	
	public void start() {
		running = true;
		new Thread(this).start();
	}
	
	public void stop(){
		running = false;
	}
	
	public void setLimit(int count){
		limit = count;
	}
	
	public void setUnitTime(int milliseconds){
		unitTime = milliseconds;
	}
	
	private void unitTime(){
		try {
			Thread.sleep(unitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * tick(tick) works as a central clock that publishes 
	 * each tick to other components
	 */
	private void tick(int tick){
		O.tick(tick);
		I.tick(tick);
		R.tick(tick);							// updating RobotScheduler to control robots
		B.tick(tick);
		V.tick(tick);						    // repainting everything
	}
	
}

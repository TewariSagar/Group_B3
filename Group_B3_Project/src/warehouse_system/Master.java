package warehouse_system;

import warehouse_system.belt.Belt;
import warehouse_system.floor.Floor;
import warehouse_system.inventory.ItemController;
import warehouse_system.orders.OrderControl;
import warehouse_system.robot.RobotScheduler;
import warehouse_system.visualizer.Visualizer;

/**
 * @author Di Huang
 * 1. Master starts and continues simulation process
 * 2. Ticking Simulation: Master publishes ticks to other components
 */
public class Master implements Runnable {
	
	// default: limit = 100 ticks
	// default: 1 second per tick
	private int limit = 100;
	private int unitTime = 1000;
	private boolean running = false;
	
	private Belt B;
	private Floor F;
	private ItemController I;
	private OrderControl O;
	private RobotScheduler R;
	private Visualizer V;
	
	/**
	 * @author Di Huang
	 * @param b for Belt role
	 * @param f for Floor role
	 * @param i for Inventory role
	 * @param o for Order role
	 * @param r for Robot role
	 * @param v for Visualizer role
	 * This constructor adds all components for possible test
	 */
	public Master(Belt b, Floor f, ItemController i, OrderControl o, RobotScheduler r, Visualizer v) {
		B = b;
		F = f;
		I = i;
		O = o;
		R = r;
		V = v;
	}
	
	/**
	 * @author Di Huang
	 * The thread runs according to this method
	 */
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
	
	/**
	 * @author Di Huang
	 * The thread starts by this method
	 */
	public void start() {
		running = true;
		new Thread(this).start();
	}
	
	/**
	 * @author Di Huang
	 * The thread stops by this method
	 */
	public void stop(){
		running = false;
	}
	
	/**
	 * @author Di Huang
	 * @param count
	 * This method sets the number of iterations of ticking 
	 */
	public void setLimit(int count){
		limit = count;
	}
	
	/**
	 * @author Di Huang
	 * @param milliseconds
	 * This method sets unit time of interval
	 */
	public void setUnitTime(int milliseconds){
		unitTime = milliseconds;
	}
	
	/**
	 * @author Di Huang
	 * This method just works inside the class for some
	 * convenience purpose
	 */
	private void unitTime(){
		try {
			Thread.sleep(unitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Di Huang
	 * @param tick value
	 * This method works as a central clock that publishes 
	 * each tick to other components
	 */
	private void tick(int tick){
		// getting orders
		O.tick(tick);
		// updating RobotScheduler to control robots
		R.tick(tick);
		// repainting everything
		V.tick(tick);
	}
	
}

package warehouse_system;

import warehouse_system.belt.Belt;
import warehouse_system.floor.Floor;
import warehouse_system.inventory.Inventory;
import warehouse_system.orders.Orders;
import warehouse_system.robot.RobotScheduler;
import warehouse_system.visualizer.Visualizer;

/**
 * Description: 
 * 1. Master starts and continues simulation process
 * 2. we use ticking for simulation, so Master will 
 * publish ticks(clk) to other components
 */

public class Master implements Runnable {
	
	private final int limitation = 50;

	private Belt B;
	private Floor F;
	private Inventory I;
	private Orders O;
	private RobotScheduler R;
	private Visualizer V;
	
	public Master(){
		// initializing needed components
		B = new Belt();
		F = new Floor();
		I = new Inventory();
		O = new Orders();
		R = new RobotScheduler();
		V = new Visualizer();
		
	}
	
	public static void main(String[] args) {
		// starting simulation
		new Master().start();
		
	}

	@Override
	public void run() {
		int clk = 0;
		while (clk < limitation) {
			System.out.println(clk + " tick");
			tick(clk);
			System.out.println();
			
			unitTime(800);					// 800 milliseconds per tick
			
			clk++;
		}

	}
	
	private void start() {
		new Thread(this).start();
	}
	
	private void tick(int clk){
		B.tick(clk);
		F.tick(clk);
		I.tick(clk);
		O.tick(clk);
		R.tick(clk);
		V.tick(clk);
	}
	
	private void unitTime(int milliseconds){
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

package warehouse_system;

public class Master implements Runnable {

	private boolean running = false;
	
	public static void main(String[] args) {
		// testing simulated events
		new Master().start();
	}

	@Override
	public void run() {
		while (running) {
			// updating stuffs every 3 milliseconds
			tick();				
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}
	
	public void start() {
		running = true;
		new Thread(this).start();
	}

	public void stop() {
		running = false;
	}
	
	private void tick(){
		// updating work
		
	}

}

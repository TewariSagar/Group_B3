package warehouse_system.belt;

import warehouse_system.Report;
import warehouse_system.Tickable;

public class Belt implements Tickable, Report{

	@Override
	public void tick(int tick) {
		printEvent("...");
		
	}

	@Override
	public void printEvent(String event) {
		System.out.println("Belt: " + event);	
	}

}

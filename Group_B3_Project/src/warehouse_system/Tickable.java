package warehouse_system;

/**
 * This interface works as a tunnel that transmits ticks 
 * from central clock to other components
 */

public interface Tickable {
	
	public void tick(int tick);
	
}

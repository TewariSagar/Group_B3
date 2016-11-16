package warehouse_system;

/**
 * @author Di Huang
 * This interface works as a tunnel that transmits ticks 
 * from central clock to other components
 */
public interface Tickable {

	/**
	 * @author Di Huang
	 * @param tick value
	 */
	public void tick(int tick);
	
}

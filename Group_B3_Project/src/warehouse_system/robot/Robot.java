package warehouse_system.robot;
/**
 * 
 * @author Wei Gui
 *
 */
public interface Robot{
	
	/**
	 * @return ID
	 */
	public String getID();
	/**
	 * @return BatteryState
	 */
	public boolean getBatteryState();
	/**
	 * 
	 */
	public void gocharge(); 
	/**
	 * @param targetitem Just as the name, the target item that i need to get
	 * @param targetposition the target position that i need to take the item to
	 */
	public void Activate(Object targetitem,Object targetposition);
	
}

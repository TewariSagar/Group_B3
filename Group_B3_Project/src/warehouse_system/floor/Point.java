package warehouse_system.floor;
/**
 * Used for storing object locations within the warehouse
 * @author josephtleiferman
 *
 */
public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	/**
	 * 
	 * @param x value in the x direction
	 * @param y value in the y direction
	 */
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 * @return int[] containing x and y for particular point
	 */
	public int[] getPoint() {
		int[] point = {this.x,this.y};
		return point;
	}
}

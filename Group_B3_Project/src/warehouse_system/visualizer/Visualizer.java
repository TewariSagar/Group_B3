package warehouse_system.visualizer;

import java.awt.Color;

import javax.swing.JFrame;

import warehouse_system.Tickable;
import warehouse_system.floor.Floor;
import warehouse_system.floor.MockFloor;

/**
 * @author Di Huang
 */
@SuppressWarnings("serial")
public class Visualizer extends JFrame implements Tickable{
	// unit: pixel
	public static final int WIDTH = 650, HEIGHT = 400;						
	public static final String TITLE = "Warehouse System";
	
	private Floor F;
	private Screen screen;
	
	/**
	 * @author Di Huang
	 * @param F for a Floor object
	 */
	public Visualizer(Floor F){
		this.F = F;
		screen = new Screen(F); 
		initialize();
	}
	
	/**
	 * @author Di Huang
	 */
	private void initialize(){
		this.setTitle(TITLE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        
		this.setLayout(null);
		this.add(screen);
		this.setVisible(true);
	}
	
	/**
	 * @author Di Huang
	 */
	@Override
	public void tick(int clk) {
		screen.repaint();
		
	}
	
//	public static void main(String[] args) {
//		/**
//		 * this is for test only
//		 */
//		Floor F = new MockFloor();
//		Visualizer V = new Visualizer(F);
//	}
	
}

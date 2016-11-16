package warehouse_system.visualizer;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import warehouse_system.floor.Floor;

/**
 * @author Di Huang
 */
@SuppressWarnings("serial")
public class Screen extends JPanel{
	public static final int width = Floor.width * Floor.gridSize;
	public static final int height = Floor.height * Floor.gridSize;
	
	private Floor F;
	
	/**
	 * @author Di Huang
	 * @param F for a Floor object
	 */
	public Screen(Floor F){
		this.F = F;
		initialize();
	}
	
	/**
	 * @author Di Huang
	 */
	private void initialize(){
		this.setBackground(Color.BLUE);
		this.setBounds((Visualizer.WIDTH - Screen.width)/2, (Visualizer.HEIGHT - Screen.height)/2, width, height);
		this.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// paint Floor below...
		
	}
	
}
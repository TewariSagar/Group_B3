package warehouse_system.belt;

import warehouse_system.Report;
import warehouse_system.Tickable;


//timing moving the bins has not been implemented yet, still waiting for 
//integration code. 

//integration with items in the orders still needed, will be involved 
//later

import java.util.*;




public interface Belt {
  boolean binAvailable();  // true if Picker can get a new Bin
  Bin getBin();  // called by Orders when Picker wants a new Bin 
  }

//public class Belt implements Tickable, Report{
//	protected static int speed;
//    protected static int capacity = 20;
//    static ArrayList<Integer> beltGrid = new ArrayList<Integer>(capacity);
//    protected static int orderNum ;
//    
//    
//    public Belt(){
//    	orderNum = (int)(Math.random() * 100.0);
//    	speed = 2;
//    	
//    }
//    
//    //comment
//    public int getSpeed(){
//    	return speed;
//    }
//    public void setSpeed(int newSpeed){
//    	speed = newSpeed;
//    }
//    public int getOrderNum(){
//    	return orderNum;
//     //	System.out.println("Order Number: " + orderNum);
//    }
//    public static void setOrderNum(int newOrder){
//    	orderNum = newOrder;
//    	
//    }
//    public static void moveRight(){
//    	beltGrid.add(0 , 0);
//    }
//    public static void addBin(int orderNum){
//    	beltGrid.add(0, orderNum);
//    }
//    public static boolean isPosEmpty(int index){
//    	if (beltGrid.get(index) == 0){
//    		System.out.println("Position " + index + " is empty");
//    		return true;
//    	} 
//    	else{
//    		System.out.println("Position " + index + " is filled");
//    		return false;
//    	}
//    	
//    }
//	
//   @Override
//	public void tick(int tick) {
//		printEvent("...");
//		
//	}
//
//	@Override
//	public void printEvent(String event) {
//		System.out.println("Belt: " + event);	
//	}
//    
//    public static void main(String args[]){
//    	Bin myBin = new Bin();
//    	Belt myBelt = new Belt();
//    	addBin(52);
//    	moveRight();
//    	moveRight();
//    	addBin(122);
//    	moveRight();
//    	addBin(10);
//    	
//    	//setOrderNum(200);
//    	System.out.println("Order Number: " + orderNum);
//    	System.out.println("List of orders on Belt:    (0 means empty)" );
//    	for (int x=0; x< beltGrid.size(); x++){
//    		System.out.println("Pos. " + x + ": " + beltGrid.get(x));
//    	}
//    	isPosEmpty(1);   
//    	//System.out.print("Belt: " + beltGrid.get(0));
//    	
//    	
//    	
//    }

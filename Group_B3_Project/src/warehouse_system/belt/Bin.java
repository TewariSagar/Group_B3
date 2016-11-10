import java.util.*;

//will work with orders!

public class Bin extends Belt {
    //for binList, 0 is starting position, 19 is last position
    
	//Hashmap for an <orderNumber, itemID>
	Map<Integer, Integer> order = new HashMap<Integer, Integer>();
    
	
//	public int binBin = 1;
    
    public Bin(){
    	 order.put(Belt.orderNum, 322);
    }
    
    //this is where orders will be saved to a bin, will need to wait
    //for integration otherwise I am not too sure how to do that
}

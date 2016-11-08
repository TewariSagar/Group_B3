
package warehouse_system.floor;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author josephtleiferman
 */

public class Floor {
    public static int[] SHELVE_1 = {2,2}; // (x,y) coordinates location
    public static int[] SHELVE_2 = {3,2}; // (x,y) coordinates location
    public static final int[] CHARGER_1 = {0,2};
    public static final int[] CHARGER_2 = {0,3}; 
    public static final int[] RECEIVING_DOCK = {5,0};
    public static final int[] PICKER = {1,5};
    public static final int[] PACKER = {1,2}; 
    public static final int[][] BELT = {{0,0,0,0,0,0},{0,1,2,3,4,5}}; // entire belt line
    public static final int UPPERB = 5;
    public static final int LOWERB = 0;
    
    /** Directions will be used for the route creating
    *you can parse the route as follows 
    *<p>
    * UP = y + 1 
    * DOWN = y - 1
    * LEFT = x - 1
    * RIGHT = x + 1
    */
    public enum Directions {
        UP,DOWN,LEFT,RIGHT
    }
    HashMap<String,int[]> FLOOR_LOCATIONS = new HashMap<>();
    
    // initially just statically create these objects
    public Floor() {
        FLOOR_LOCATIONS.put("SHELVE_1",SHELVE_1);
        FLOOR_LOCATIONS.put("SHELVE_2",SHELVE_2);
        FLOOR_LOCATIONS.put("CHARGER_1",CHARGER_1);
        FLOOR_LOCATIONS.put("CHARGER_2",CHARGER_2);
        FLOOR_LOCATIONS.put("RECEIVING_DOCK",RECEIVING_DOCK);
        FLOOR_LOCATIONS.put("PICKER",PICKER);
        FLOOR_LOCATIONS.put("PACKER",PACKER);
        
        
        
    }
    /**
     *Given a string l getLocation(String l) will rerturn an int[] 
     *storing the location of that object or null if not a valid object
     *<p>
     *
     *@param l string containing locations name 
     *@return int[] location of the object (x,y)
     */
    public int[] getLocation(String l) {
        return FLOOR_LOCATIONS.get(l);
    }
     /** 
      * return true or false depending on if an object is at location [x,y]
      * <p>
      * @param l an int[] [x,y] of objects location  
      * @return boolean whether an object is at a given [x,y]
      */
    public boolean objectAt(int[] l) {
        
        for(int[] x: FLOOR_LOCATIONS.values() ) {
            if(x[0] == l[0] && x[1]==l[1]) {
                return true;
            }
        }
        return false;
    }
    /** updates location of a given shelf
     * 
     * @param object the shelves name
     * @param location the location of shelf
     * 
     */
    public void updateShelve(String object, int[] location) { 
        int [] newLocation = FLOOR_LOCATIONS.get(object);
        newLocation = location;
        FLOOR_LOCATIONS.put(object, newLocation);
    }
    /** 
     * 
     * @param start start location of a given object
     * @param end end destination
     * @return ArrayList<Directions> returns a route from start to end of type Directions ex [LEFT,RIGHT,UP,DOWN,DOWN]
     */ 
    public ArrayList<Directions> getRoute(int[] start, int[] end) {
        ArrayList<Directions> route = new ArrayList<>();
        int[] currentLocation = start.clone();
        // alternator will alternate between odd and even so that the robot will move
        // in either the x or y direction untill it is in line with either the x or y
        int alternator = 0;
        // will creat a route until object is at final location
        while(currentLocation[0]!= end[0] || currentLocation[1] != end[1]) {
            
            if(alternator%2==0 && currentLocation[0] != end[0]) {
                // find whether moving left or right will get object closer to destination
                int diff1 = Math.abs(currentLocation[0]+1 - end[0]);
                int diff2 = Math.abs(currentLocation[0]-1 - end[0]);
                int[] tempLocation = currentLocation.clone();
                if(diff1<diff2) {
                    tempLocation[0]+=1; 
                    if(!objectAt(tempLocation) && tempLocation[0]<UPPERB) {
                        currentLocation[0]+= 1;
                        route.add(Directions.RIGHT);
                    }
                }
                else {
                    tempLocation[0]-= 1;
                    if(!objectAt(tempLocation) && tempLocation[0]>LOWERB ) {
                        currentLocation[0]-= 1;
                        route.add(Directions.LEFT);
                    }
                }
            }else if(alternator%2==1 && currentLocation[1] != end[1]) {
                // find whether moving up or down will get object closer to destination
                int diff1 = Math.abs(currentLocation[1]+1 - end[1]);
                int diff2 = Math.abs(currentLocation[1]-1 - end[1]);
                int[] tempLocation = currentLocation.clone();
                if(diff1<diff2) {
                    tempLocation[1]+=1;
                    if(!objectAt(tempLocation) && tempLocation[1]>LOWERB) {
                        currentLocation[1]+= 1;
                        route.add(Directions.DOWN);
                    }
                }
                else {
                    tempLocation[1]-=1;
                    if(!objectAt(currentLocation) && tempLocation[1]<UPPERB) {
                        currentLocation[1]-= 1;
                        route.add(Directions.UP);
                    }
                }
            }
            System.out.println(Arrays.toString(currentLocation));
            
            alternator +=1;
        }
        return route;
        
    }
}


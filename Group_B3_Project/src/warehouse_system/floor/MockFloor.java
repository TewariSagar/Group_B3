package warehouse_system.floor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 * 
 * @author josephtleiferman
 *
 */
public class MockFloor implements Floor {
	public static Point SHELVE_1 = new Point(2,2); // (x,y) coordinates location
    public static Point SHELVE_2 = new Point(3,2); // (x,y) coordinates location
    public static Point ROBOT = new Point(2,0); // start robot on charger 
    public static final Point CHARGER_1 = new Point(2,0);
    public static final Point CHARGER_2 = new Point(3,0); 
    public static final Point RECEIVING_DOCK = new Point(5,0);
    public static final Point PICKER = new Point(1,5);
    public static final Point PACKER = new Point(1,2);
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
    HashMap<String,Point> FLOOR_LOCATIONS = new HashMap<>();
    
    // initially just statically create these objects
    public MockFloor() {
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
     *@return Point location of the object (x,y)
     */
    public Point getLocation(String l) {
        return FLOOR_LOCATIONS.get(l);
    }
     /** 
      * return true or false depending on if an object is at location [x,y]
      * <p>
      * @param l a Point [x,y] of objects location  
      * @return boolean whether an object is at a given [x,y]
      */
    public boolean objectAt(Point l) {
        
        for(Point x: FLOOR_LOCATIONS.values() ) {
            if(x.getPoint()[0] == l.getPoint()[0] && x.getPoint()[1]==l.getPoint()[1]) {
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
    public void updateObjectLocation(String object, Point location) { 
        Point newLocation = FLOOR_LOCATIONS.get(object);
        newLocation = location;
        FLOOR_LOCATIONS.put(object, newLocation);
    }
    /**
     * will be called when the floor is first initialized so that we can choose where the robot begins 
     * for example on a charge or at the dock
     * <p>
     * @param l location to place the robot to start with
     */
    public void placeRobot(Point l) {
    	ROBOT = l;
    	updateObjectLocation("ROBOT",l);
    }
    /** 
     * 
     * @param start start location of a given object
     * @param end end destination
     * @return ArrayList returns a route from start to end of type Directions ex [LEFT,RIGHT,UP,DOWN,DOWN]
     */ 
    public ArrayList<Directions> getRoute(Point start, Point end) {
        ArrayList<Directions> route = new ArrayList<>();
        Point currentLocation = new Point(start.getPoint()[0],start.getPoint()[1]);
        // alternator will alternate between odd and even so that the robot will move
        // in either the x or y direction until it is in line with either the x or y
        int alternator = 0;
        // will create a route until object is at final location
        while(currentLocation.getPoint()[0]!= end.getPoint()[0] || currentLocation.getPoint()[1] != end.getPoint()[1]) {
            
            if(alternator%2==0 && currentLocation.getPoint()[0] != end.getPoint()[0]) {
                // find whether moving left or right will get object closer to destination
                int diff1 = Math.abs(currentLocation.getPoint()[0]+1 - end.getPoint()[0]);
                int diff2 = Math.abs(currentLocation.getPoint()[0]-1 - end.getPoint()[0]);
                Point tempLocation = new Point(currentLocation.getPoint()[0],currentLocation.getPoint()[1]);
                if(diff1<diff2) {
                    tempLocation.getPoint()[0]+=1; 
                    if(tempLocation.getPoint()[0]<UPPERB) {
                        currentLocation.setPoint(currentLocation.getPoint()[0]+1,currentLocation.getPoint()[1]);
                        route.add(Directions.RIGHT);
                    }
                }
                else {
                    tempLocation.getPoint()[0]-= 1;
                    if( tempLocation.getPoint()[0]>LOWERB ) {
                    	currentLocation.setPoint(currentLocation.getPoint()[0]-1,currentLocation.getPoint()[1]);
                        route.add(Directions.LEFT);
                    }
                }
            }else if(alternator%2==1 && currentLocation.getPoint()[1] != end.getPoint()[1]) {
                // find whether moving up or down will get object closer to destination
                int diff1 = Math.abs(currentLocation.getPoint()[1]+1 - end.getPoint()[1]);
                int diff2 = Math.abs(currentLocation.getPoint()[1]-1 - end.getPoint()[1]);
                Point tempLocation = new Point(currentLocation.getPoint()[0],currentLocation.getPoint()[1]);
                if(diff1<diff2) {
                    tempLocation.getPoint()[1]+=1;
                    if( tempLocation.getPoint()[1]>LOWERB) {
                    	currentLocation.setPoint(currentLocation.getPoint()[0],currentLocation.getPoint()[1]+1);
                        route.add(Directions.DOWN);
                    }
                }
                else {
                    tempLocation.getPoint()[1]-=1;
                    if( tempLocation.getPoint()[1]<UPPERB) {
                    	currentLocation.setPoint(currentLocation.getPoint()[0],currentLocation.getPoint()[1]-1);
                        route.add(Directions.UP);
                    }
                }
            }
            System.out.println(Arrays.toString(currentLocation.getPoint()));
            System.out.println(Arrays.toString(route.toArray()));
            alternator +=1;
        }
        return route;
        
    }
}



package warehouse_system.floor;
import java.util.ArrayList;

/**
 *
 * @author josephtleiferman
 */
public class FloorTest {
    public static void main(String[] args) {
        Floor test = new Floor();
        ArrayList<Floor.Directions> routes= new ArrayList<>();
        int[] dock = {5,0};
        int[] charger1 = {2,0};
        System.out.println("getting Route");
        routes = test.getRoute(dock,charger1);
        System.out.println(routes.toString());
        
    }
}



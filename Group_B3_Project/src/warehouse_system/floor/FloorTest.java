
package warehouse_system.floor;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * @author josephtleiferman
 *
 */
public class FloorTest {
	Floor f = new Floor();
	@Test
	public void test() {
		// testing getLocation
		String tester = "SHELVE_1";
		int[] expected = {2,2};
		int[] got  = f.getLocation(tester);
		assertArrayEquals(expected,got);
		//testing getLocation
		int[] expected1 = {1,5};
		tester = "PICKER";
		got = f.getLocation(tester);
		assertArrayEquals(expected1 ,got);
		// testing objectAt
		boolean got1 = f.objectAt(expected);
		assertEquals(true,got1);
		//testing objectAt
		got1 = f.objectAt(expected1);
		//testing objectAt
		assertEquals(true,got1);
		//testing objectAt
		int[] notInFloor = {0,0};
		assertEquals(false,f.objectAt(notInFloor));
		//testing updateShelve
		f.updateShelve("SHELVE_1", notInFloor);
		assertArrayEquals(notInFloor,f.FLOOR_LOCATIONS.get("SHELVE_1"));
		//testing get route
		ArrayList<Floor.Directions> expectedRoute = new ArrayList<>();
		int[] shelve1 = {2,2};
		int[] charger2 = {3,0};
		expectedRoute.add(Floor.Directions.UP);
		expectedRoute.add(Floor.Directions.RIGHT);
		expectedRoute.add(Floor.Directions.UP);
		assertEquals(expectedRoute, f.getRoute(shelve1,charger2));
	}
	

}

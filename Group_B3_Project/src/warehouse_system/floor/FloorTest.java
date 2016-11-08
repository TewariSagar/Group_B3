
package warehouse_system.floor;

import static org.junit.Assert.*;

import org.junit.Test;

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
		int[] expected = {3,0};
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
		int[] got2 = {0,0};
		assertEquals(false,got2);
		//testing updateShelve
		f.updateShelve("SHELVE_1", got2);
		assertArrayEquals(got2,f.FLOOR_LOCATIONS.get("SHELVE_1"));
		//testing get route
		
		
		
	}
	

}

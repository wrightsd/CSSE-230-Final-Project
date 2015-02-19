import java.util.ArrayList;
import java.util.Iterator;


/**
 * Sample testing class for Finding shortest distance between locations.
 * @author mcgarrdg
 *
 */
public class PathfindingTest {


	public static void main(String[] args) {
		GPS gps = new GPS();
		
		ArrayList<Location> route = gps.findShortestPath("BarrowDowns", "Baraddur");
		
		Iterator i = route.iterator();
		Location l = null;
		while(i.hasNext()) {
			l = (Location) i.next();
			System.out.println(l.getName());
		
		}
	
	
	}
	

}

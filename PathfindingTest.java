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
		
		
		gps.findShortestPaths("BagEnd",  Integer.MAX_VALUE);	
		ArrayList<Location> route = gps.getPath("MountDoom");
		
		Iterator<Location> i = route.iterator();
		Location l = null;
		System.out.println("Least Distance");
		
		while(i.hasNext()) {
			l = (Location) i.next();
			System.out.println(l.getName());
		
		}
		gps.findShortestPaths("BagEnd",  80);
		ArrayList<String> destinations = gps.getDistanceList();
		System.out.println(destinations.toString());
		gps.findShortestPaths("BagEnd",  79);
		destinations = gps.getDistanceList();
		System.out.println(destinations.toString());
		
		
		gps.findLeastDangerousPaths("BagEnd",  Integer.MAX_VALUE);	
		ArrayList<Location> route2 = gps.getPath("MountDoom");
		System.out.println();
		System.out.println("Least Danger");
		i = route2.iterator();
		l = null;
		while(i.hasNext()) {
			l = (Location) i.next();
			System.out.println(l.getName());
		}
		gps.findLeastDangerousPaths("BagEnd",  194);
		destinations = gps.getDangerList();
		System.out.println(destinations.toString());
		gps.findLeastDangerousPaths("BagEnd",  195);
		destinations = gps.getDangerList();
		System.out.println(destinations.toString());
		gps.findLeastDangerousPaths("BagEnd",  1000);
		destinations = gps.getDangerList();
		System.out.println(destinations.size());
		gps.findLeastDangerousPaths("BagEnd",  1000);
		destinations = gps.getDangerList();
		System.out.println(destinations.size());
		gps.findLeastDangerousPaths("BagEnd",  1000);
		destinations = gps.getDangerList();
		System.out.println(destinations.size());
		gps.findLeastDangerousPaths("BagEnd",  1000);
		destinations = gps.getDangerList();
		System.out.println(destinations.size());
		gps.findLeastDangerousPaths("BagEnd",  1000);
		destinations = gps.getDangerList();
		System.out.println(destinations.size());
		gps.findLeastDangerousPaths("BagEnd",  1000);
		destinations = gps.getDangerList();
		System.out.println(destinations.size());
	}
	

}

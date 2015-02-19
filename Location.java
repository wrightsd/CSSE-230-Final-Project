import java.util.ArrayList;
import java.util.HashSet;

/**
 * The Location object which has connections to other Location object, and a
 * cost for the specific Location.
 * 
 * @author wrightsd
 *
 */
public class Location {
	private String name;
	private int locationCost;
	private ArrayList<Integer> locationCostList = new ArrayList<Integer>();
	private ArrayList<Path> connections = new ArrayList<Path>();
	private int gridX;
	private int gridY;

	/**
	 * The constructor for the Location object if one Location cost is given.
	 * 
	 * @param gridX
	 *            an int that is the x position of the location on the map
	 * @param gridY
	 *            an int that is the y position of the location on the map
	 * @param placeName
	 *            a String that is the name of the Location
	 * @param pointCost
	 *            an int that gives the specific cost for that Location
	 */

	public Location(int gridX, int gridY, String placeName, int pointCost) {
		this.name = placeName;
		this.locationCost = pointCost;
		this.gridX = gridX;
		this.gridY = gridY;
	}

	/**
	 * The constructor for the Location object if two Location costs are given.
	 * 
	 * @param gridX
	 *            an int that is the x position of the location on the map
	 * @param gridY
	 *            an int that is the y position of the location on the map
	 * @param placeName
	 *            a String that is the name of the Location
	 * @param lowerCost
	 *            an int that is the lesser cost of the Location
	 * @param higherCost
	 *            an int that is the higher cost of the Location
	 */
	public Location(int gridX,int gridY,String placeName, int lowerCost, int higherCost) {
		this.name = placeName;
		this.locationCostList.add(lowerCost);
		this.locationCostList.add(higherCost);

	}

	/**
	 * Adds a connection to the list of Connections
	 * 
	 * @param connection
	 *            a Road object that connects this Location to another
	 */

	public void addConnection(Path connection) {
		this.connections.add(connection);
	}
	
	/**
	 * Returns all paths the current location has.
	 * @return an ArrayList of paths.
	 */
	public ArrayList<Path> getConnections() {
		return this.connections;
	}
	
	/**
	 * Returns the neighbors of a the current Location that have not been settled by dijkstra's algorithm.
	 * @param settledL, a HashSet of settledLocations.
	 * @return an ArrayList of neighboring locations.
	 */
	public ArrayList<Location> getNeighbors(HashSet<Location> settledL) {
		ArrayList<Location> neighbors = new ArrayList<Location>();
		for(Path connection: this.connections) {
			if(!settledL.contains(connection.getNextLocation()) )
				neighbors.add(connection.getNextLocation());
		}
		return neighbors;
	}

	/**
	 * Returns the cost of the Location, as well as deciding which cost to
	 * return if two costs are associated with the Location.
	 * 
	 * @return an int which is the cost of the Location
	 */
	public int getCost() {
		if (locationCostList.isEmpty()) {
			return this.locationCost;
		}
		if (Math.random() < 0.5) {
			return (int) locationCostList.get(0);
		}
		return (int) locationCostList.get(1);
	}
	
	/**
	 * Returns the x position of the Location object.
	 * 
	 * @return an int which is the x position of the Location
	 */
	public int getGridX(){
		return this.gridX;
	}
	
	/**
	 * Returns the y position of the Location object.
	 * 
	 * @return an int which is the y position of the Location
	 */
	public int getGridY(){
		return this.gridY;
	}
	
	/**
	 * Returns the distance from this location to the specified location next.
	 * @param next, the next location
	 * @return distance from this to next.
	 */
	public int getDistance(Location next) {
		for(Path connection : connections) {
			if(connection.getNextLocation() == next) {
				return connection.getDistance();
			}
		}//for debugging purposes, should never reach here.
		return Integer.MAX_VALUE;
	}
	
	
	/**
	 * Finds the connection to the next location and gives the overall cost.
	 * @param next location to go to
	 * @return the overall cos tof the connection
	 */
	public int getOverallCost(Location next) {
		for(Path connection : connections) {
			if(connection.getNextLocation() == next) {
				return connection.getOverallCost();
			}
		}return Integer.MAX_VALUE;
	}
	
	/**
	 * Returns the name of the location.
	 * @return the name of the location.
	 */
	public String getName() {
		return this.name;
	}
}

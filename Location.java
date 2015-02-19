import java.util.ArrayList;

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
	private ArrayList locationCostList;
	private ArrayList connections;
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
	 * @param costList
	 *            an ArrayList with two integers that gives the differing
	 *            location costs
	 */
	public Location(int gridX, int gridY, String placeName, ArrayList costList) {
		this.name = placeName;
		this.gridX = gridX;
		this.gridY = gridY;
		this.locationCostList = costList;

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
	public int getGridX() {
		return this.gridX;
	}

	/**
	 * Returns the y position of the Location object.
	 * 
	 * @return an int which is the y position of the Location
	 */
	public int getGridY() {
		return this.gridY;
	}
}

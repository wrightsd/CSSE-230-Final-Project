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

	/**
	 * The constructor for the Location object if one Location cost is given.
	 * 
	 * @param placeName
	 *            a String that is the name of the Location
	 * @param pointCost
	 *            an int that gives the specific cost for that Location
	 */

	public Location(String placeName, int pointCost) {
		this.name = placeName;
		this.locationCost = pointCost;
	}

	/**
	 * The constructor for the Location object if two Location costs are given.
	 * 
	 * @param placeName
	 *            a String that is the name of the Location
	 * @param lowerCost
	 *            an int that is the lesser cost of the Location
	 * @param higherCost
	 *            an int that is the higher cost of the Location
	 */
	public Location(String placeName, int lowerCost, int higherCost) {
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

	public void addConnection(Road connection) {
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
}
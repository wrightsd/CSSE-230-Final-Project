/**
 * The Road object which which connects to Locations together with a cost for
 * the connection based on the distance as well as the difficulty of the path.
 * 
 * @author wrightsd
 *
 */
public class Path {
	private Location nextLocation;
	private int distance;
	private int overallCost;

	/**
	 * The constructor for the Road object.
	 * 
	 * @param nextLocation
	 *            a Location that is to be connected to the previous.
	 * @param distance
	 *            an int that is the path distance regardless of difficulty,
	 *            used for speed
	 * @param overallCost
	 *            an int that gives the cost of the path based on the distance
	 *            and difficulty of the path.
	 */
	public Path(Location nextLocation, int distance, int overallCost) {
		this.nextLocation = nextLocation;
		this.distance = distance;
		this.overallCost = overallCost;
	}

	/**
	 * Returns the distance of the path (used for fastest path).
	 * 
	 * @return an int that is the distance of the path
	 */
	public int getDistance() {
		return this.distance;
	}

	/**
	 * Returns the overall cost of the path.
	 * 
	 * @return an int that is the cost of the path.
	 */
	public int getOverallCost() {
		return this.overallCost;
	}

	/**
	 * Returns the next location along the road object.
	 * 
	 * @return a Location that is the next location object along the path.
	 */
	public Location getNextLocation() {
		return this.nextLocation;

	}
}

/**
 * This class is a representation of a Flight object and contains data about
 * each flight (start, destination and price of flight)
 * 
 * @author snigd
 *
 */
public class FlightInfo {
	private String start;
	private String dest;
	private int price;

	/**
	 * Constructor for a flight that sets the starting, destination and price of a
	 * flight
	 * 
	 * @param start
	 * @param dest
	 * @param price
	 */
	public FlightInfo(String start, String dest, int price) {
		this.start = start;
		this.dest = dest;
		this.price = price;
	}

	/**
	 * This method gets the stored starting location
	 * @return start
	 */
	public String getStart() {
		return this.start;
	}

	/**
	 * This method sets the starting location of the flight
	 * @param start
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * This method gets the stores destination
	 * @return dest
	 */
	public String getDest() {
		return this.dest;
	}

	/**
	 * This method sets the destination of the flight
	 * @param dest
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}

	/**
	 * This method gets the stored price
	 * @return price
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * This method sets the price of the flight
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

}


import java.util.ArrayList;

/**
 * This class represent each airport node, each of which has a name and stores
 * an arrayList of flights
 * 
 * @author snigd
 *
 */
public class CityAirport {

	private String airportName;
	private ArrayList<FlightInfo> flights;

	/**
	 * Constructor for an airport that takes a name and sets an empty arrayList
	 * 
	 * @param airportName
	 */
	public CityAirport(String airportName) {
		this(airportName, new ArrayList<>());
	}

	/**
	 * Second constructor which takes both a name and an arrayList
	 * 
	 * @param airportName
	 * @param flights
	 */
	public CityAirport(String airportName, ArrayList<FlightInfo> flights) {
		this.airportName = airportName;
		this.flights = flights;
	}

	/**
	 * This method gets the stored name
	 * 
	 * @return airportName
	 */
	public String getName() {
		return this.airportName;
	}

	/**
	 * This method sets the name of the airport
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.airportName = name;
	}

	/**
	 * This method gets the stored flights
	 * 
	 * @return flights
	 */
	public ArrayList<FlightInfo> getFlights() {
		return flights;
	}

	/**
	 * This method adds a flight to the arrayList of flights in an airport
	 * 
	 * @param flights
	 */
	public void addFlight(FlightInfo flight) {
		flights.add(flight);
	}

}

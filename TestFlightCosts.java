import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
public class TestFlightCosts {

	/**
	 * Ensures that cities can be added to the graph properly. If the removeCity method returns
	 * false after adding a city, then the test fails.
	 */
	@Test
	public void testAddCity() {
		Backend test = new Backend("Flights.txt", "Cities.txt");
		test.addCity("Chicago");
		if (!test.removeCity("Chicago")) {
			fail("The city was not successfully added");
		}
	}

	/**
	 * Ensures that flights can be added to the graph properly. If the removeFlight method returns
	 * false after adding a flight, then the test fails.
	 */
	@Test
	public void testAddFlight() {
		Backend test = new Backend("Flights.txt", "Cities.txt");
		test.addFlight("Austin", "San Francisco", 147);
		if (!test.removeFlight("Austin", "San Francisco")) {
			fail("The flight was not successfully added");
		}
	}
	
	/**
	 * Tests the proper functionality of the getCheapestFlightPath and getCheapestFlightCost methods 
	 * by ensuring that the cheapest connecting flight is found when a direct flight between two
	 * cities does not exist. The test fails if the correct connecting city is not found or the total 
	 * cost is incorrect.
	 */
	@Test
	public void testCheapestFlight() {
		Backend test = new Backend("Flights.txt", "Cities.txt");
		test.getCheapestFlightPath("Austin", "San Francisco");
		test.getCheapestFlightCost("Austin", "San Francisco");
		if (test.getCheapestFlightCost("Austin", "San Francisco") != 285) {
			fail("This is not the cheapest flight cost!");
		}
		if (!test.getCheapestFlightPath("Austin", "San Francisco").get(1).getName().contains("Detroit")) {
			fail("This is not the cheapest connexting flight!");
		}
	}
}

import java.util.ArrayList;

public class CityData {
  
  // Name of the city
  private String name;
  
  // List of flights originating from this city
  private ArrayList<FlightData> flights;
  
  public CityData(String name) {
    this(name, new ArrayList<>());
  }
  
  public CityData(String name, ArrayList<FlightData> flights) {
    this.name = name;
    this.flights = flights;
  }

  public String getName() {
    return name;
  }

  public ArrayList<FlightData> getFlights() {
    return flights;
  }
  
  public void addFlight(FlightData flight) {
    flights.add(flight);
  }
}

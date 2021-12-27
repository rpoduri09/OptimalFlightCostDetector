public class FlightData {
  
  // The city name where the flight will take off from
  private String origin;
  
  // The city name where the flight will land
  private String destination;
  
  // The cost of the flight
  private double cost;
  
  public FlightData(String origin, String destination, double cost) {
    this.origin = origin;
    this.destination = destination;
    this.cost = cost;
  }

  public String getOrigin() {
    return origin;
  }

  public String getDestination() {
    return destination;
  }

  public double getCost() {
    return cost;
  }
  
  
}

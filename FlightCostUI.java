import java.util.List;
import java.util.Scanner;

/**
 * This is the command line interface class for our optimum flight cost detector
 * @author rohitpoduri
 *
 */
public class FlightCostUI {
  final static String flightsFilePath = "FlightsData.txt"; // file path for flights
  final static String citiesFilePath = "Cities.txt"; // file path for cities
  final static Backend flightDetector = new Backend(flightsFilePath, citiesFilePath);

  /**
   * This is the main method which includes the command line interface for the project.
   * So the user is supposed to input an origin airport and a destination ariport
   * so that the optimum cost and path to take are printed to the console. You are
   * not allowed to have a flight from the same airport to the same airport, and 
   * if the flights do not exist to your destination or from your origin, an exception
   * is thrown.
   * @param args
   */
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    Boolean exit = false;
    System.out.println("Optimum Flight Cost Calculator: ");
    while (!exit) {
      System.out.println("Enter the origin airport (or enter exit to quit): ");
      String inputOrigin = scnr.nextLine().toUpperCase();
      if (inputOrigin.equalsIgnoreCase("exit")) {
        System.out.println("Thank you! Have a nice day!");
        exit = false;
        scnr.close();
        break;
      }
      // enter in your destination here or exit if you'd like to
      System.out.println("Enter your desired destination (or enter exit to quit): ");
      String destination = scnr.nextLine().toUpperCase();
      if (destination.equalsIgnoreCase("exit")) {
        System.out.println("Thank you! Have a nice day!");
        exit = false;
        scnr.close();
        break;
      }
      if(!destination.equals(inputOrigin)) {
      try {
      // The best path to take to your destination along with the cost is printed to the console
      System.out.println("The best path to take to your destination would be: ");
      List<CityData> bestPath = flightDetector.getCheapestFlightPath(inputOrigin, destination);
      for(int i = 0; i < bestPath.size(); i++) {
        if(bestPath.get(i).getName().equals(destination)) {
        System.out.println(bestPath.get(i).getName());
        break;
        }
        System.out.print(bestPath.get(i).getName() + "->");
      }
      System.out.println("The cheapest cost of getting to your destination is: $"
          + flightDetector.getCheapestFlightCost(inputOrigin, destination));
      } catch(NullPointerException e) {
        System.out.println("Warning! Please enter a city that is in the database.");
      }
      } else {
        // A flight to origin is impossible
      System.out.println("You can't have a flight to your origin airport, please try again");
      }
    }
  }

}

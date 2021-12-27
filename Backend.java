import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backend {
	private CS400Graph<CityData> graph;
	private ArrayList<CityData> list;
	
	// Initialize without input
	public Backend() {
		graph = new CS400Graph<CityData>();
		list = new ArrayList();
	}
	
	public Backend(String flights, String cities) {
		list = new ArrayList();
		graph = new CS400Graph<CityData>();
		Scanner s;
		Scanner s2;
	    try {
	    	File data = new File(cities);
	    	s = new Scanner(data);
	    	File fdata = new File(flights);
	    	s2 = new Scanner(fdata);
	    	String[] lines;
	    	// Adds cities into the graph
	    	while(s.hasNextLine()) {
	    		CityData newCity = new CityData(s.nextLine());
	    		graph.insertVertex(newCity);
	    		list.add(newCity); 	  	
	    	}
	    	// Adds edges between cities into the graph
	    	while (s2.hasNextLine()) {
	    		lines = s2.nextLine().split(",");
	    		CityData origin = null;
	    		CityData destination = null;
	    		for (int i = 0; i < list.size(); i++) {
	    			if (list.get(i).getName().contentEquals(lines[0])) {
	    				origin = list.get(i);
	    			}
	    			if (list.get(i).getName().contentEquals(lines[1])) {
	    				destination = list.get(i);
	    			}
	    		}
	    		graph.insertEdge(origin, destination, Integer.parseInt(lines[2]));
	    		FlightData newFlight = new FlightData(
	  					lines[0], lines[1], Integer.parseInt(lines[2]));
	    		origin.addFlight(newFlight);
	    		
	    	}
	    }
	    catch(NumberFormatException n) {
	    	System.out.println("Error converting input to valid format");
	    } 
	    catch(FileNotFoundException f) {
	        System.out.println("Error locating file");
	    } 
	    catch (IndexOutOfBoundsException i) {
	        System.out.println("Error reading data");
	    }

	}
	
	
	/**
	 * Add a city into the graph using a string name. 
	 * @param name of the city being added
	 * @return true if added successfully and false otherwise
	 */
	public boolean addCity(String name) {
		CityData newCity = new CityData(name);
		try {
			graph.insertVertex(newCity);
			list.add(newCity);
			return true;
		}
		catch (Exception e1) {
			return false;
		}
	}
	
	/**
	 * Removes a city from the graph
	 * @param name of the city being removed
	 * @return true if removed successfully and false otherwise
	 */
	public boolean removeCity(String name) {
		CityData remove = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contentEquals(name)) {
				remove = list.get(i);
			}
		}
		try {
			graph.removeVertex(remove);
			return true;
		}
		catch (Exception e1) {
			return false;
		}
	}
	
	/**
	 * Adds flight between two city to the graph (edge)
	 * @param origin is a string of the starting location
	 * @param destination is a string of the arriving location
	 * @param cost is an int of how much the flight costs
	 * @return true if the flightdata has been successfully added and false otherwise
	 */
	public boolean addFlight(String origin, String destination, int cost) {
		CityData start = null;
		CityData finish = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contentEquals(origin)) {
				start = list.get(i);
			}
			if (list.get(i).getName().contentEquals(destination)) {
				finish = list.get(i);
			}
		}
		try {
			graph.insertEdge(start, finish, cost);
			FlightData newFlight = new FlightData(origin, destination, cost);
			start.addFlight(newFlight);
			return true;
		}
		catch (Exception e1) {
			return false;
		}
	}
	
	/**
	 * A method that removes a flight from the graph
	 * @param origin is a string of the starting location
	 * @param destination is a string of the arriving location
	 * @return true if the flight was succesfully removed and false otherwise
	 */
	public boolean removeFlight(String origin, String destination) {
		CityData start = null;
		CityData finish = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contentEquals(origin)) {
				start = list.get(i);
			}
			if (list.get(i).getName().contentEquals(destination)) {
				finish = list.get(i);
			}
		}
		try {
			graph.removeEdge(start, finish);
			return true;
		}
		catch (Exception e1) {
			return false;
		}
	}
	
	/**
	 * A method that calls the shortestPath method in CS400Graph and returns a list 
	 * of citydata that the user should travel along to minimize the cost of traveling
	 * @param origin is a string of the origin
	 * @param destination is a string of the destination
	 * @return a list of citydata that user should travel in to minimize cost
	 */
	public List<CityData> getCheapestFlightPath(String origin, String destination) {
		List<CityData> sol = null;
		try {
			CityData start = null;
			CityData finish = null;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().contentEquals(origin)) {
					start = list.get(i);
				}
				if (list.get(i).getName().contentEquals(destination)) {
					finish = list.get(i);
				}
			}
			sol = graph.shortestPath(start, finish);
		}
		catch (Exception e1) {
			System.out.println("Flight from " + origin + " to " + destination + " does not exist.");
		}
		return sol;
	}
	
	/**
	 * A method that calls the getPathCost method in CS400Graph and returns the cost
	 * getting from the origin to the destination
	 * @param origin is the starting location of the flight
	 * @param destination is the ending location of the flight
	 * @return the total cost of the flight
	 */
	public int getCheapestFlightCost(String origin, String destination) {
		if (origin.contentEquals(destination)) {
			return 0;
		}
		int sol = 0;
		try {
			CityData start = null;
			CityData finish = null;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().contentEquals(origin)) {
					start = list.get(i);
				}
				if (list.get(i).getName().contentEquals(destination)) {
					finish = list.get(i);
				}
			}
			sol = graph.getPathCost(start, finish);
		}
		catch (Exception e1) {
			System.out.println("Flight from " + origin + " to " + destination + " does not exist.");
		}
		return sol;
	}
}

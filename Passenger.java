package gameProj;

import java.util.ArrayList;

public class Passenger {
	private static int counter = 1;
	private int id;
	private ArrayList<Road> path = new ArrayList<Road>();
	
	public Passenger(Map m) {
		this.id = counter++;
		this.path = m.getRandomPath();
		this.path.get(0).getEntryJunction().addPassengerToQueue(this);
		System.out.println(this+ " is waiting for vehicle at "+ this.path.get(0).getEntryJunction() +", path: " + this.path);
	}
	
	public ArrayList<Road> getPath() {
		return path;
	}
	
	public String toString() {
		return "Passenger " + id;
	}
}

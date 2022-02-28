package gameProj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Junction extends Point {

	private static int counter = 1;
	private int id;
	private ArrayList<Road> entranceRoads = new ArrayList<Road>();
	private ArrayList<Road> exitRoads = new ArrayList<Road>();
	private TrafficLight tl = null;
	private Queue<Passenger> queue = new LinkedList<Passenger>();

	public Junction() {
		super();
		this.id = counter++;
		System.out.println("Creating Junction " + this.id + " at Point " + super.toString());
	}

	public Junction(double x, double y) {
		super(x, y);
		this.id = counter++;
		System.out.println("Creating Junction " + this.id + " at Point " + super.toString());
	}

	public String toString() {
		return "Junction " + this.id;
	}

	public void addEnterRoad(Road road) {
		entranceRoads.add(road);
	}

	public void addExitRoad(Road road) {
		exitRoads.add(road);
	}

	public Road getRandomEnterRoad() {
		int numRoads = this.entranceRoads.size();
		return this.entranceRoads.get(super.rnd.nextInt(numRoads));
	}

	public Road getRandomExitRoad() {
		int numRoads = this.exitRoads.size();
		return this.exitRoads.get(super.rnd.nextInt(numRoads));
	}

	public ArrayList<Road> getEnteringRoads() {
		return entranceRoads;
	}

	public void setEntranceRoads(ArrayList<Road> entranceRoads) {
		this.entranceRoads = entranceRoads;
	}

	public ArrayList<Road> getExitingRoads() {
		return exitRoads;
	}

	public void setExitRoads(ArrayList<Road> exitRoads) {
		this.exitRoads = exitRoads;
	}

	public boolean isSameJunction(Junction j1) {
		return (j1.getX() == super.getX() && j1.getY() == super.getY());
	}

	public void setTrafficLight(TrafficLight tl) {
		this.tl = tl;
	}

	public TrafficLight getTrafficLight() {
		return tl;
	}

	public boolean hasTrafficLight() {
		return tl != null;
	}
	
	public void addPassengerToQueue(Passenger p) {
		this.queue.add(p);
	}
	
	public Passenger getFirstInQueue() {
		return this.queue.poll();
	}
}

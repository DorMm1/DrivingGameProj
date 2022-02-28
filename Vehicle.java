package gameProj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Vehicle implements Dynamic {

	private static int counter = 1;
	private int id;
	final int MAX_SPEED = 120;
	final int MIN_SPEED = 30;
	private ArrayList<Road> path;
	private int currentRoadIndex = 0;
	private int speed;
	private double distance;
	private boolean flagMoving = true;
	private Passenger passenger = null;

	public Vehicle(Map m) {
		this.id = counter++;
		Random r = new Random();
		this.speed = r.nextInt(MAX_SPEED - MIN_SPEED) + MIN_SPEED;
		this.path = m.getRandomPath();
		this.distance = this.path.get(currentRoadIndex).getLength();
		System.out.println("Creating " + this + ", speed: " + this.speed + ", path " + this.path);
	}
	
	public boolean work() {
		return this.move();
	}

	public boolean move() {
		if (currentRoadIndex == 0 && distance == this.path.get(currentRoadIndex).getLength() && passenger == null) {
			this.collectPassenger();
		}
		if (distance > 0) { // continue on the same road
			distance -= speed;
			boolean didCollectPass = false;
			if (distance <= 0 && passenger == null) didCollectPass = this.collectPassenger();
			if (!didCollectPass) System.out.println(this + " is moving on the " + this.path.get(currentRoadIndex));
		} else if (this.path.size() > this.currentRoadIndex + 1) { // continue to the next road
			if (this.path.get(currentRoadIndex).isGreen()) { // TL is green
				this.currentRoadIndex++;
				this.distance = this.path.get(currentRoadIndex).getLength();
				System.out.println(this + " is moving on the " + this.path.get(currentRoadIndex));				
			} else // TL is not green, wait in the same road
				System.out.println(this + " is waiting for green light on " + this.path.get(currentRoadIndex).getExitJunction());
		} else { // vehicle is finished his path
			if (this.flagMoving) {
				Report r = new Report();
				r.addVehicleFinish(this);
			}
			this.flagMoving = false;
			System.out.println(this + " arrived to it's destination: " + this.path.get(currentRoadIndex).getEnd());
			return false;
		}
		return true;
	}
	
	public Boolean collectPassenger() {
		Junction currentJunction = this.path.get(currentRoadIndex).getExitJunction();
		Passenger p = currentJunction.getFirstInQueue();
		if (p != null) {
			passenger = p;
			this.path = p.getPath();
			this.currentRoadIndex = 0;
			this.distance = this.path.get(currentRoadIndex).getLength();
			System.out.println(this + " is collecting " + p + " at " + currentJunction);
			return true;
		}
		return false;
	}

	public String toString() {
		return "Vehicle " + this.id;

	}

	public String pathToString() {
		String str = "[";
		for (Road r : this.path) {
			str += r.toString();
		}
		return str;
	}
	
	public boolean isFinishedPath() {
		return !this.flagMoving;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
	
	public ArrayList<Road> getPath() {
		return path;
	}
}

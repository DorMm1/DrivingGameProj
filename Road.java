package gameProj;

public class Road {
	private static int counter = 1;
	private int id;
	private Junction entryJunction;
	private Junction exitJunction;

	private double length;

	public Road(Junction enter, Junction exit) {
		this.id = counter++;
		if (enter.isSameJunction(exit)) {
			this.exitJunction = new Junction();
			System.out.println("Road can not connect a junction to itself, the end junction has been replaced with " + this.exitJunction);
		} else {
			this.exitJunction = exit;
		}
		this.entryJunction = enter;
		this.length = this.entryJunction.calcDistance(this.exitJunction);

		enter.addExitRoad(this);
		exit.addEnterRoad(this);
		System.out.println("Creating " + this + ", length: " + String.format("%.2f", this.length));
	}

	public String toString() {
		return "Road from " + this.entryJunction + " to " + this.exitJunction;
	}

	public Junction getStart() {
		return entryJunction;
	}

	public Junction getEnd() {
		return exitJunction;
	}

	public double getLength() {
		return length;
	}
	
	public Junction getEntryJunction() {
		return entryJunction;
	}

	public Junction getExitJunction() {
		return exitJunction;
	}

	public int getId() {
		return id;
	}
	
	public boolean isGreen() {
		if (this.exitJunction.hasTrafficLight()) {
			return this.exitJunction.getTrafficLight().getCurrentGreen().getId() == this.id;
		} else return true;
	}
}

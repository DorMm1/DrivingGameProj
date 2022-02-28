package gameProj;

public class SequentialTL extends TrafficLight {
	
	private int currentGreenRaodIndex = 0;

	public SequentialTL(Junction junction) {
		super(junction);
		super.setGreenRoad(super.getJunction().getEnteringRoads().get(0));
		System.out.println(this);
	}

	public void check() {
		if (super.delayOver()) {
			this.changeGreenRoad();
		}
	}

	public void changeGreenRoad() {
		this.currentGreenRaodIndex++;
		if (this.currentGreenRaodIndex >= super.getJunction().getEnteringRoads().size()) {
			this.currentGreenRaodIndex = 0;
		}
		Road nextGreenRoad = super.getJunction().getEnteringRoads().get(this.currentGreenRaodIndex);
		super.setGreenRoad(nextGreenRoad);
	}
	
	public String toString() {
		return "Sequential TrafficLights " + super.getJunction() + ", delay= " + super.getDelay() + ": green light on " + super.getCurrentGreen();
	}
}

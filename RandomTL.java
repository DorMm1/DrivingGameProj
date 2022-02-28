package gameProj;

//import java.util.ArrayList;

public class RandomTL extends TrafficLight {

	public RandomTL(Junction junction) {
		super(junction);
		this.changeGreenRoad();
		System.out.println(this);
	}

	public void check() {
		if (super.delayOver()) {
			this.changeGreenRoad();
		}
	}

	public void changeGreenRoad() {
		super.setGreenRoad(super.getJunction().getRandomEnterRoad());
	}
	
	public String toString() {
		return "Random TrafficLights " + super.getJunction() + ", delay= " + super.getDelay() + ": green light on " + super.getCurrentGreen();
	}
}

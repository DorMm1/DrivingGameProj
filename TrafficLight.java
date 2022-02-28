package gameProj;

import java.util.Random;

public abstract class TrafficLight implements Dynamic {

	public Random rnd = new Random();
	private final int delay = rnd.nextInt(3) + 2; // constant time of delay

	private int delayCounter;
	private Road greenRoad;
	private Junction junction;

	public TrafficLight(Junction junction) {
		this.junction = junction;
		this.delayCounter = this.delay;
	}

	public abstract void check();
	
	public boolean work() {
		this.check();
		return false;
	}

	public Road getCurrentGreen() {
		return greenRoad;
	}

	public void setGreenRoad(Road greenRoad) {
		this.greenRoad = greenRoad;
		System.out.println(this);
	}

	protected boolean delayOver() {
		// checks if delay time is over and we need to change the light
		this.delayCounter--;
		if (this.delayCounter == 0) {
			this.delayCounter = this.delay;
			return true;
		} else {
			return false;
		}
	}

	public Junction getJunction() {
		return junction;
	}

	public int getDelay() {
		return delay;
	}
}

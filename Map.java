package gameProj;

import java.util.ArrayList;
import java.util.Random;

public class Map {

	private Random rnd = new Random();
	private ArrayList<Junction> junctions = new ArrayList<Junction>();
	private ArrayList<Road> roads = new ArrayList<Road>();
	private ArrayList<TrafficLight> tls = new ArrayList<TrafficLight>();

	public Map(int numOfJuncs) {
		for (int i = 0; i < numOfJuncs; i++) {
			this.junctions.add(new Junction());
		}
		createRoads();
		createTrafficLights();
	}

	public Map(ArrayList<Junction> junctionsList, ArrayList<Road> roadsList) {
		this.junctions = junctionsList;
		this.roads = roadsList;
		createTrafficLights();
	}

	public void createRoads() {
		for (Junction start : this.junctions) {
			for (Junction end : this.junctions) {
				if (!start.isSameJunction(end) && this.rnd.nextBoolean()) {
					this.roads.add(new Road(start, end));
				}
			}
		}
	}

	public void createTrafficLights() {
		for (Junction j : junctions) {
			if (j.getEnteringRoads().size() > 0 && this.rnd.nextBoolean() && this.rnd.nextBoolean()) {
				TrafficLight tl;
				if (this.rnd.nextBoolean()) {
					tl = new RandomTL(j);
					j.setTrafficLight(tl);
				} else {
					tl = new SequentialTL(j);
					j.setTrafficLight(tl);
				}
				this.tls.add(tl);
			}
		}
	}

	public ArrayList<Road> getRandomPath() {
		ArrayList<Road> path = new ArrayList<Road>();
		Junction currentJunction;
		do {
			currentJunction = this.junctions.get(this.rnd.nextInt(this.junctions.size()));
		} while (currentJunction.getExitingRoads().size() == 0);

		while (path.size() < 4 && currentJunction.getExitingRoads().size() > 0) {
			Road nextRoad = currentJunction.getRandomExitRoad();
			path.add(nextRoad);
			currentJunction = nextRoad.getEnd();
		}
		return path;
	}

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}

	public ArrayList<Road> getRoads() {
		return roads;
	}
	
	public ArrayList<TrafficLight> getTls() {
		return tls;
	}
}

package gameProj;

import java.util.ArrayList;

public class DrivingGame {

	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private ArrayList<Dynamic> arr = new ArrayList<Dynamic>();
	private Map map;

	public DrivingGame(int numOfJuncs, int numOfVehicles) {
		this.map = new Map(numOfJuncs);
		for (int i = 0; i < numOfVehicles; i++) {
			Vehicle v = new Vehicle(this.map);
			this.arr.add(v);
		}
		this.arr.addAll(this.map.getTls());
	}
	
	public void play() {
		ArrayList<String> carsFinished = new ArrayList<String>();
		Report r = new Report();
		r.init();
		int vehiclesNum = this.vehicles.size();
		int turn = 0;
		boolean isAllVehiclesFinished = false;
		while (!isAllVehiclesFinished) {
			turn++;
			System.out.println("Turn " + turn);
			isAllVehiclesFinished = true;
			for (Dynamic item : this.arr) {
				boolean isMoving = item.work();
				if (isMoving) isAllVehiclesFinished = false;
			}
//			for (Junction junc : this.map.getJunctions()) { // for continue TL
//				if (junc.getTrafficLight() != null) {
//					junc.getTrafficLight().check();
//				}
//			}
//			for (int i = 0; i < this.vehicles.size(); i++) { // for move vehicles
//				this.vehicles.get(i).move();
//				if (this.vehicles.get(i).isFinishedPath() && carsFinished.indexOf(this.vehicles.get(i).toString()) == -1) { 
//					// add the finished cars to ArrayList for check all cars are finished
//					carsFinished.add(this.vehicles.get(i).toString());
//				}
//			}

			if (turn % 3 == 0) {
				new Passenger(map);
			}
		}
	}

	public void play(int turns) {
		for (int i = 1; i <= turns; i++) {
			System.out.println("Turn " + i);
			for (Junction junc : this.map.getJunctions()) {
				if (junc.getTrafficLight() != null) {
					junc.getTrafficLight().check();
				}
			}
			for (Vehicle v : this.vehicles) {
				v.move();
			}
		}
	}
}

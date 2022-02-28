package gameProj;

import java.util.Random;

public class Point {

	private final int MAX_X = 800;
	private final int MAX_Y = 600;
	private final int MIN = 0;

	private double x;
	private double y;
	public Random rnd = new Random();

	public Point() {
		this.x = rnd.nextInt(MAX_X);
		this.y = rnd.nextInt(MAX_Y);
	}

	public Point(double x, double y) {
		this.setX(x);
		this.setY(y);
		System.out.println("Creating Point " + this.toString());
	}

	public String toString() {
		return "(" + String.format("%.2f", this.x) + ", " + String.format("%.2f", this.y) + ")";
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		try {
			if (x < MIN || x > MAX_X) throw new Exception(x + " is illegal value for X");
			this.x = x;
		} catch (Exception e) {
			double randomNum = rnd.nextInt(MAX_X) - rnd.nextDouble();
			System.out.println(x + " is illegal value for X and has been replaced with " + randomNum);
			this.x = randomNum;
		}
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		try {
			if (y < MIN || x > MAX_Y) throw new Exception(y + " is illegal value for Y");
			this.y = y;
		} catch (Exception e) {
			double randomNum = rnd.nextInt(MAX_Y) - rnd.nextDouble();
			System.out.println(y + " is illegal value for X and has been replaced with " + randomNum);
			this.y = randomNum;
		}
	}

	public double calcDistance(Point p1) {
		double disX = Math.pow(this.x - p1.getX(), 2);
		double disY = Math.pow(this.y - p1.getY(), 2);
		return Math.sqrt(disY + disX);

	}

}

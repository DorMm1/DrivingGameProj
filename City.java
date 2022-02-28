package gameProj;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;

public class City extends Canvas {

	final int WIDTH = 1000;
	final int HEIGHT = 1000;
	private Frame frame = new Frame("Smart City");

	public City(Map m) {
		frame.add(this);
		frame.setLayout(null);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		drawJunctions(m.getJunctions());
		drawRoads(m.getRoads());
	}

	public void drawJunctions(ArrayList<Junction> junctions) {
		for (Junction j : junctions) {
			Graphics g = frame.getGraphics();
			g.setColor(Color.red);
			g.fillOval((int) j.getX(), (int) j.getY(), 5, 5);
		}
	}

	public void drawRoads(ArrayList<Road> roads) {
		for (Road r : roads) {
			Graphics g = frame.getGraphics();
			g.setColor(Color.black);
			g.drawLine((int) r.getStart().getX(), (int) r.getStart().getY(),
					(int) r.getEnd().getX(), (int) r.getEnd().getY());
		}
	}
}

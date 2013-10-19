package model.backbone.agent;

import model.backbone.building.helpers.Point;

public class Agent {

	private Point currentLocation;
	private int floor;
	private boolean isEscaped;

	public static double size = 20;
	public static double step = 0.005;

	public Agent(Point location, int floor) {
		currentLocation = location;
		this.floor = floor;
	}

	public Agent(int x, int y, int floor) {
		currentLocation = new Point(x, y);

	}

	public Point getLocation() {
		return currentLocation;
	}

	public void setLocation(Point location) {
		this.currentLocation = location;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isEscaped() {
		return isEscaped;
	}

	public void setEscaped(boolean isEscaped) {
		this.isEscaped = isEscaped;
	}

	public static double getSize() {
		return size;
	}

	public static void setSize(double size) {
		Agent.size = size;
	}

	public void printAgent() {
		System.out.println("agent " + currentLocation.stringRepresentation());
	}

}

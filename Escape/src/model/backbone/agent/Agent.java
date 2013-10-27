package model.backbone.agent;

import model.backbone.building.helpers.Point;

public class Agent {

	public enum DestinationType { Exit, Sign, None}
	private Point currentLocation;
	private int floor;
	private boolean isEscaped;
	private boolean isDead;
	private DestinationType destination;
	private Point DestinationPoint;

	private int myHitPoints = 700;
	
	public static int size = 30;
//	public static double step = 0.005;

	public Agent(Point location, int floor) {
		currentLocation = location;
		this.floor = floor;
		destination = DestinationType.None;
		DestinationPoint = null;
		isEscaped = false;
		isDead = false;
	}

	public Agent(int x, int y, int floor) {
		this(new Point(x,y), floor);
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

	public static void setSize(int size) {
		Agent.size = size;
	}

	public void printAgent() {
		System.out.println("agent " + currentLocation.stringRepresentation());
	}

	public DestinationType getDestinationType() {
		return this.destination;
	}
	
	public Point getDestinationPoint() {
		return this.DestinationPoint;
	}
	
	public void setDestination(DestinationType dest, Point destPoint) {
			if (this.destination == DestinationType.Exit) return;
			this.destination = dest;
			this.DestinationPoint = destPoint;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void ageHim() {
		myHitPoints -= 1;
		if(myHitPoints < 1) {
			isDead = true;
		}
	}
	
}

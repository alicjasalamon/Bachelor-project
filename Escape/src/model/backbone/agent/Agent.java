package model.backbone.agent;

import model.backbone.building.elements.Floor;
import model.backbone.building.helpers.Point;

public class Agent {
	
	private Point currentLocation;
	private Floor currentFloor;
	private boolean isEscaped;
	
	public static double size = 1.0;

	public Agent(Point location, Floor floor){
		currentLocation = location;
		currentFloor = floor;
	}
	
	public Agent(double x, double y, int floor)
	{
		currentLocation = new Point(x,y);
		
	}
	
	public Point getLocation() {
		return currentLocation;
	}


	public void setLocation(Point location) {
		this.currentLocation = location;
	}


	public Floor getCurrentFloor() {
		return currentFloor;
	}


	public void setCurrentFloor(Floor currentFloor) {
		this.currentFloor = currentFloor;
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

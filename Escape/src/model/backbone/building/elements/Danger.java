package model.backbone.building.elements;

import model.backbone.building.helpers.Point;

public class Danger {

	private Point center;
	private double radius;
	public static double initialRadius = 0.225;
	// y = 0.0035 * slider + 0.05
	
	public Danger() {
		
		center = new Point();
		radius = 0;
	}
	
	public Danger(double x, double y, double r)
	{
		center = new Point(x,y);
		radius = r;
	}
	
	public Danger(Point p, double r)
	{
		center = p;
		radius = r;
	}
	
	
	public Point getCenter() {
		return center;
	}

	public double getRadius() {
		return radius;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void printDanger() {

		System.out.println("danger: center " + center.stringRepresentation() + " r " + radius);
	}
	
	public String forXMLRepresentation()
	{
		return "x=\"" + center.getX() + "\" y=\"" + center.getY() + "\" r=\"" +  radius + "\"";
	}

}

package model.backbone.building.elements;

import model.backbone.building.helpers.Point;

public class Danger {

	private Point center;
	private int radius;
	public static int initialRadius = 140;
	// y = 0.0035 * slider + 0.05
	
	public Danger() {
		
		center = new Point();
		radius = 0;
	}
	
	public Danger(int x, int y, int r)
	{
		center = new Point(x,y);
		radius = r;
	}
	
	public Danger(Point p, int r)
	{
		center = p;
		radius = r;
	}
	
	
	public Point getCenter() {
		return center;
	}

	public int getRadius() {
		return radius;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public void setRadius(int radius) {
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
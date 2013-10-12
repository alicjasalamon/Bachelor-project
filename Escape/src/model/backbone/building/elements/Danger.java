package model.backbone.building.elements;

import model.backbone.building.helpers.Point;

public class Danger {

	Point center;
	double radius;
	
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

	public void printDanger() {

		System.out.println("danger: center " + center.stringRepresentation() + " r " + radius);
	}
	
	public String forXMLRepresentation()
	{
		return "x=\"" + center.getX() + "\" y=\"" + center.getY() + "\" r=\"" +  radius + "\"";
	}

}

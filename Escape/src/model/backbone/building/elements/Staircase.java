package model.backbone.building.elements;

import model.backbone.building.helpers.Point;

public class Staircase {

	private Point point1;
	private Point point2;
	
	public Staircase()
	{
		point1 = new Point();
		point2 = new Point();
	}
	
	public Staircase(Point a, Point b)
	{
		point1 = a;
		point2 = b;
	}
	
	public Staircase(int x1, int y1, int x2, int y2)
	{
		point1 = new Point(x1, y1);
		point2 = new Point(x2, y2);
	}
	
	public Point getPoint1() {
		return point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void printStaircase() {
		System.out.println("staircase: " + point1.stringRepresentation() + " - " + point2.stringRepresentation());
	}

	public String forXMLRepresentation()
	{
		return "x1=\"" + point1.getX() + "\" y1=\"" + point1.getY() + "\" x2=\"" + point2.getX() + "\" y2=\"" + point2.getY() + "\"";
	}
}

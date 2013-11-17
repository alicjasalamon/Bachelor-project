package model.backbone.building.elements;

import model.backbone.building.helpers.Point;

public class Staircase {

	private Point point1;
	private int width;
	private int height;
	
	public Staircase()
 	{
		point1 = new Point();
		width = 0;
		height = 0;
	}
	
	public Staircase(Point a, int l, int h)
	{
		point1 = a;
		width = l;
		height = h;
	}
	
	public Staircase(int x1, int y1, int l, int h)
	{
		point1 = new Point(x1, y1);
		width = l;
		height = h;
	}
	
	public Point getPoint1() {
		return point1;
	}

	public int getLenght() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void printStaircase() {
		System.out.println("staircase: " + point1.stringRepresentation() + " - " + width + " " + height);
	}

	public String forXMLRepresentation()
	{
		return "x=\"" + point1.getX() + "\" y=\"" + point1.getY() + "\" width=\"" + width + "\" height=\"" + height + "\"";
	}
}

package model.backbone.building.elements;

import model.backbone.building.helpers.Point;

public class Staircase {

	private Point point1;
	private int lenght;
	private int height;
	
	public Staircase()
 	{
		point1 = new Point();
		lenght = 0;
		height = 0;
	}
	
	public Staircase(Point a, int l, int h)
	{
		point1 = a;
		lenght = l;
		height = h;
	}
	
	public Staircase(int x1, int y1, int l, int h)
	{
		point1 = new Point(x1, y1);
		lenght = l;
		height = h;
	}
	
	public Point getPoint1() {
		return point1;
	}

	public int getLenght() {
		return lenght;
	}

	public int getHeight() {
		return height;
	}

	public void printStaircase() {
		System.out.println("staircase: " + point1.stringRepresentation() + " - " + lenght + " " + height);
	}

	public String forXMLRepresentation()
	{
		return "x1=\"" + point1.getX() + "\" y1=\"" + point1.getY() + "\" lenght=\"" + lenght + "\" height=\"" + height + "\"";
	}
}

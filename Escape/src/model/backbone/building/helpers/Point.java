package model.backbone.building.helpers;

public class Point {

	public int x;
	public int y;
	
	public Point()
	{
		x=0;
		y=0;
	}
	
	public Point(Point p)
	{
		this.x = p.x;
		this.y = p.y;
	}
	
	public Point(Point p, int xOffset, int yOffset)
	{
		this.x = p.x+xOffset;
		this.y = p.y+yOffset;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public String stringRepresentation() {
		return "(" + x + ", " + y + ")";
	}
}

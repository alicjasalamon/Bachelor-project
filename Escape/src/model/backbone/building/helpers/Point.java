package model.backbone.building.helpers;

public class Point {

	private double x;
	private double y;
	
	public Point()
	{
		x=0;
		y=0;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public String stringRepresentation() {
		return "(" + x + ", " + y + ")";
	}
}

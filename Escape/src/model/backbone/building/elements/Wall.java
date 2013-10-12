package model.backbone.building.elements;

import model.backbone.building.helpers.Point;

public class Wall {

	private Point begin;
	private Point end;
	
	public Wall(){
		begin = new Point();
		end = new Point();
	}
	
	public Wall(Point a, Point b){
		begin = a;
		end = b;
	}
	
	public Wall(double x1, double y1, double x2, double y2){
		begin = new Point(x1, y1);
		end = new Point(x2, y2);
	}
	
	public Point getBegin() {
		return begin;
	}

	public Point getEnd() {
		return end;
	}

	
	public void printWall() {
		System.out.println("wall " + begin.stringRepresentation() + " - " + end.stringRepresentation());
	}
	
	public String forXMLRepresentation()
	{
		return "x1=\"" + begin.getX() + "\" y1=\"" + begin.getY() + "\" x2=\"" + end.getX() + "\" y2=\"" + end.getY() + "\"";
	}

}

package model.backbone.building.elements;

import model.backbone.building.helpers.Point;

public class Sign {

	private Point begin;
	private Point end;
	private Point target;
	
	public Sign(Point a, Point b, Point target){
		begin = a;
		end = b;
		this.target = target;
	}
	
	public Sign(int x1, int y1, int x2, int y2, int x3, int y3){
		begin = new Point(x1, y1);
		end = new Point(x2, y2);
		target = new Point(x3,y3);
	}
	
	public Point getBegin() {
		return begin;
	}

	public Point getEnd() {
		return end;
	}

	public Point getTarget() {
		return target;
	}
	
	public void printSign() {
		System.out.println("sign " + begin.stringRepresentation() + " - " + end.stringRepresentation());
	}
	
	public String forXMLRepresentation()
	{
		return "x1=\"" + begin.getX() + "\" y1=\"" + begin.getY() + "\" x2=\"" + end.getX() + "\" y2=\"" + end.getY() + "\"";
	}

}

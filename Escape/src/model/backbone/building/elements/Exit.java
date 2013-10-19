package model.backbone.building.elements;

import model.backbone.building.helpers.Point;

public class Exit {

	private Point begin;
	private Point end;
	
	public Exit(){
		begin = new Point();
		end = new Point();
	}
	
	public Exit(Point a, Point b){
		begin = a;
		end = b;
	}
	
	public Exit(int x1, int y1, int x2, int y2){
		begin = new Point(x1, y1);
		end = new Point(x2, y2);
	}
	
	
	public Point getBegin() {
		return begin;
	}

	public Point getEnd() {
		return end;
	}

	public void printExit() {
		System.out.println("exit " + begin.stringRepresentation() + " - " + end.stringRepresentation());
	}
	
	public String forXMLRepresentation()
	{
		return "x1=\"" + begin.getX() + "\" y1=\"" + begin.getY() + "\" x2=\"" + end.getX() + "\" y2=\"" + end.getY() + "\"";
	}

}

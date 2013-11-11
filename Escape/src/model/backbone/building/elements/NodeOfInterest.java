package model.backbone.building.elements;

import model.backbone.building.helpers.Point;

public class NodeOfInterest {


	private Point begin;
	private Point end;
	
	public NodeOfInterest(int x, int y, int x2, int y2 )
	{
		begin = new Point(x,y);
		end = new Point(x2,y2);
	}
	
	public Point getBegin() {
		return begin;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}


	
}

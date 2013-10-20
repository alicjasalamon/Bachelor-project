package model.backbone.utils;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import model.backbone.building.helpers.Point;

public class MathUtils {

	//p1 and p2 are end points of one line, p3 and p4 are end points of the other
	public static boolean doLinesIntersect(Point p1, Point p2, Point p3, Point p4) {
		return Line2D.linesIntersect(p1.x, p1.y, p2.x, p2.y,
				p3.x, p3.y, p4.x, p4.y);
	}

	public static int getDistanceBetweenTwoPoints(Point p1, Point p2) {
		return (int)Point2D.distance((double)p1.getX(),(double)p1.getY(),(double)p2.getX(),(double)p2.getY());
	}

	public static Point getMiddlePointOfTheLine(Point p1, Point p2) {
		return new Point((int)((p1.x+p2.x)/2),(int) ((p1.y+p2.y)/2));
	}
	
	public static int getDistanceBetweenPointAndLine(Point linePoint1, Point linePoint2, Point point ) {
		return (int) Line2D.ptSegDist(linePoint1.getX(), linePoint1.getY(), linePoint2.getX(), linePoint2.getY(), point.getX(), point.getY());
	}
	
}

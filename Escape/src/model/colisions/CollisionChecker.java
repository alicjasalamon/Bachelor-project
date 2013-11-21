package model.colisions;

import resources.SimulationResources;
import model.backbone.building.Building;
import model.backbone.building.elements.Wall;
import model.backbone.building.helpers.BuildingExplorer;

public class CollisionChecker {
	
	private Building building = SimulationResources.building;
	private int floor;
	
	
	public CollisionChecker(Building building, int floor) {
		super();
		this.building = building;
		this.floor = floor;
	}

	public boolean willDangeCauseCollision(int x, int y, int r)
	{
		
		return false;
	}
	
	public boolean willAgentCauseCollision(int x, int y)
	{
		boolean collision = false;
		
		for(Wall wall : building.getFloors().get(floor).getWalls() )
		{
			int x1 = wall.getBegin().x;
			int y1 = wall.getBegin().y;
			int x2 = wall.getEnd().x;
			int y2 = wall.getEnd().y;
			
			//System.out.println(x + " " + y + "\t\t" + x1 + " " + y1+ " " + x2 + " " +y2);
			
			double result;
			if(isPointProjectionOnLine(x, y, x1, y1, x2, y2))
			{	
		//		System.out.println("projekcja");
				int a = getA(x1, y1, x2, y2);
				int b = getB(x1, y1, x2, y2);
				int c = getC(x1, y1, x2, y2);
				result = distancePointLine(x2, y2, a, b, c);
			}
			else
			{
	//			System.out.println("nie projekcja");
				result = Math.min(distancePointPoint(x, y, x1, y1), distancePointPoint(x, y, x2, y2));
			}
			
			System.out.println(result);
			
			//if(result<10) collision = true;
			
		}
		
		return collision;
	}
	
	private int getA(int x1, int y1, int x2, int y2)
	{
		return y1-y2;
	}
	
	private int getB(int x1, int y1, int x2, int y2)
	{
		return x2-x1;
	}
	
	private int getC(int x1, int y1, int x2, int y2)
	{
		return y2*x1 - y1*x2;
	}
	
	private double distancePointPoint(int x1, int y1, int x2, int y2)
	{
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
	private double distancePointLine(int x, int y, double a, double b, double c)
	{
	//	System.out.println("ZIUM " +a + " "+ b + " "+ c+ " " + Math.abs(a*x+b*y+c));
		return (double)Math.abs(a*x+b*y+c)/(double)Math.sqrt(a*a+b*b);
	}
	
	private boolean isPointProjectionOnLine(int x, int y, int x1, int y1, int x2, int y2)
	{
		int minx = Math.min(x1, x2);
		int maxx = Math.max(x1, x2);
		int miny = Math.min(y1, y2);
		int maxy = Math.max(y1, y2);
		
		//System.out.println((x<maxx) + " " + (x>minx) + " " +  (y<maxy) + " " +  (y>miny));
		if((x<maxx && x>minx) || (y<maxy && y>miny))
			return true;
		return false;
	
	}
	
	public static void main(String args[])
	{
		BuildingExplorer be = new BuildingExplorer();
		Building building = be.parseBuilding("building_schema\\building1.xml");
		
		CollisionChecker collisionChecker = new CollisionChecker(building, 0);
		collisionChecker.willAgentCauseCollision(300, 300);
	}
	
}

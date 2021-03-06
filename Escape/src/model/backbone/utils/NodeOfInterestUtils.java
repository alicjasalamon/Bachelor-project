package model.backbone.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.backbone.agent.Agent;
import model.backbone.building.Building;
import model.backbone.building.elements.Floor;
import model.backbone.building.elements.NodeOfInterest;
import model.backbone.building.elements.Wall;
import model.backbone.building.helpers.Point;
import resources.SimulationResources;

public class NodeOfInterestUtils {

	private Building building;
	private Map<Integer, Integer[][]> adjacentSquaresMap;
	//some of those points, will pass filtering and become NodesOfInterest
	private Map<Integer, List<Point>> interestingPoints;
	
	public void initialize() {
		building = SimulationResources.building;
		interestingPoints = new HashMap<Integer, List<Point>>();
		adjacentSquaresMap = new HashMap<Integer, Integer[][]>();
		
		List<Floor> floors = building.getFloors();
		
		int sizeX = SimulationResources.building.getResolutionX() + 1;
		int sizeY = SimulationResources.building.getResolutionY() + 1;
		
		for (int floorNumber = 0; floorNumber < floors.size();floorNumber++) {
			Floor floor = building.getFloors().get(floorNumber); 
			List<Wall> walls = floor.getWalls();
			
			Integer adjacentSquares[][] = new Integer[sizeX][sizeY];
			
			//fill in with zeros
			for (int i = 0; i < sizeX; i++) {
				for (int j = 0; j < sizeY; j++) {
					adjacentSquares[i][j] = 0;
				}
			}
			//Add walls to map
			for (Wall w : walls) {
				if (w.getBegin().getX() == w.getEnd().getX()) {
					
					int lowY = w.getBegin().getY() < w.getEnd().getY() ? w.getBegin().getY() : w.getEnd().getY();
					int highY = w.getBegin().getY() > w.getEnd().getY() ? w.getBegin().getY() : w.getEnd().getY();
					
					for (int i = lowY; i < highY; i++) {
						adjacentSquares[w.getBegin().getX()][i] = -1;
					}
					
				} else if (w.getBegin().getY() == w.getEnd().getY()) {
					
					int lowX = w.getBegin().getX() < w.getEnd().getX() ? w.getBegin().getX() : w.getEnd().getX();
					int highX = w.getBegin().getX() > w.getEnd().getX() ? w.getBegin().getX() : w.getEnd().getX();
					
					for (int i = lowX; i < highX; i++) {
						adjacentSquares[i][w.getBegin().getY()] = -1;
					}
					
				}
			}
			
			List<Point> points = new ArrayList<Point>();
			//iterate over all points on map
			for (int i = 0; i < sizeX; i++) {
				for (int j = 0; j < sizeY; j++) {
					
					//adding 1 to adjacentSum for every adjacent square that is not a wall
					int adjacentSum = 0;
					//not interested in walls
					if ( adjacentSquares[i][j] == -1) continue;
					
					for (int xOffset = -1; xOffset < 2; xOffset++) {	
						for (int yOffset = -1; yOffset < 2; yOffset++) {
							
							if (xOffset == 0 && yOffset == 0) continue; 
							
							if (i+xOffset >= 0 && i+xOffset < sizeX && j+yOffset >= 0  && j+yOffset < sizeY) {
								if (adjacentSquares[i+xOffset][j+yOffset] != -1) {
									adjacentSum++;
								}
							}
							
						}
					}
					
					adjacentSquares[i][j] = adjacentSum;
					if (adjacentSum == 7) points.add(new Point(i,j));
				}
			}
			interestingPoints.put(floorNumber, points);
			adjacentSquaresMap.put(floorNumber, adjacentSquares);
		}
		
		for (int floorNumber = 0; floorNumber < floors.size();floorNumber++) {
			
			Floor floor = building.getFloors().get(floorNumber); 
			List<NodeOfInterest> nodes = new ArrayList<NodeOfInterest>();
			//list of filtered points
			List<Point> pointsOfInterest = new ArrayList<Point>();
			
			//filtering points
			for ( Point p : interestingPoints.get(floorNumber)) {
				
				if ((adjacentSquaresMap.get(floorNumber)[p.x+1][p.y] == 7
						&& adjacentSquaresMap.get(floorNumber)[p.x-1][p.y] == 7)
				|| (adjacentSquaresMap.get(floorNumber)[p.x][p.y+1] == 7
						&& adjacentSquaresMap.get(floorNumber)[p.x][p.y-1] == 7)) {
					pointsOfInterest.add(p);
				}
				
			}
			
			//connecting points 
			while (pointsOfInterest.size() > 0) {
				
				int distance = -1;
				Point closestPoint = null;
				Point p = pointsOfInterest.get(0); 
				
				for (Point p2 : pointsOfInterest) {
					if ((p.x == p2.x) && (p.y == p2.y)) continue;
					
					
					if (distance == -1 || distance > MathUtils.getDistanceBetweenTwoPoints(p, p2)) {
						distance = MathUtils.getDistanceBetweenTwoPoints(p, p2);
						closestPoint = p2;
					}
				}
				
				if ( closestPoint != null && (p.x == closestPoint.x || p.y == closestPoint.y)) {
					
					nodes.add(new NodeOfInterest(p.x,p.y,closestPoint.x,closestPoint.y));
					pointsOfInterest.remove(p);
					pointsOfInterest.remove(closestPoint);
					
				} else {
					
					nodes.add(createNodeFromSinglePoint(p, floorNumber));
					pointsOfInterest.remove(p);
				}
				
			}
			
			//final effect
			floor.setNodesOfInterest(nodes);
			
		}
		
	}
	
	private NodeOfInterest createNodeFromSinglePoint(Point p, int floorNumber) {
		
		if (adjacentSquaresMap.get(floorNumber)[p.x+1][p.y] == -1) {			
			return new NodeOfInterest(p.x-30,p.y,p.x-30,p.y);
		}
		else if (adjacentSquaresMap.get(floorNumber)[p.x-1][p.y] == -1) {			
			return new NodeOfInterest(p.x+30,p.y,p.x+30,p.y);
		}
		else if (adjacentSquaresMap.get(floorNumber)[p.x][p.y+1] == -1) {			
			return new NodeOfInterest(p.x,p.y-30,p.x,p.y-30);
		}
		else {			
			return new NodeOfInterest(p.x,p.y+30,p.x,p.y+30);
		}
	}
	
	public Point getFartherNoiPoint(NodeOfInterest noi, Agent agent) {
		
		Point start = noi.getBegin();
		Point end = noi.getEnd();
		Point middle = MathUtils.getMiddlePointOfTheLine(start, end);
		if (start.x == end.x && start.y == end.y) {
			return noi.getBegin();
		}
		if (adjacentSquaresMap.get(agent.getFloor())[start.x-1][start.y] == -1
				|| adjacentSquaresMap.get(agent.getFloor())[start.x+1][start.y] == -1) {
			if (agent.getLocation().y < start.y) {
				return new Point(middle.x,middle.y+25);
			} else {
				return new Point(middle.x,middle.y-25);
			}
		}
		if (adjacentSquaresMap.get(agent.getFloor())[start.x][start.y-1] == -1
				|| adjacentSquaresMap.get(agent.getFloor())[start.x][start.y+1] == -1) {
			if (agent.getLocation().x < start.x) {
				return new Point(middle.x +25,middle.y);
			} else {
				return new Point(middle.x -25,middle.y);
			}
		}
		
		return null;
	}
}

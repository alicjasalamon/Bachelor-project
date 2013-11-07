package model.backbone.algorithm;

import java.util.ArrayList;

import model.backbone.agent.Agent;
import model.backbone.agent.Agent.DestinationType;
import model.backbone.building.elements.Exit;
import model.backbone.building.helpers.Point;
import model.backbone.utils.AlgorithUtilities;
import model.backbone.utils.CollisionUtils;
import model.backbone.utils.MathUtils;
import resources.SimulationResources;

/**
 * To create a new Algorithm you need to extend this class and override setDestination
 * Optionally you can override setAgentDirection and moveAgent for full control of agent's behavior
 */
public abstract class Algorithm {
	
	//Set agent's destination to which he will try to get
	public abstract void setAgentDestination(Agent agent);
	
	//Set agent's direction towards his destination for the next move
	public void setAgentDirection(Agent agent) {
		if (!(agent.getDestinationType() == DestinationType.None)) {
			
			if (CollisionUtils.areThereObstaclesInMyPath(agent, agent.getDestinationPoint())) {
				if (!agent.isAvoidingCollision()) {					
					CollisionUtils.rerouteMe(agent);
				}
			} else {
				agent.setAvoidingCollision(false);
			}
			//Determine the destination
			Point destination = agent.getDestinationPoint();
			if (agent.isAvoidingCollision()) {
				
				ArrayList<Point> tempDestPoints = agent.getTemporaryDestinationPoints();
				for (Point p : tempDestPoints) {
					if (MathUtils.getDistanceBetweenTwoPoints(agent.getLocation(), p) < 5) {
						ArrayList<Point> newPoints = new ArrayList<Point>(tempDestPoints);
						newPoints.remove(p);
						agent.setTemporaryDestinationPoints(newPoints);
					}
				}
				
				tempDestPoints = agent.getTemporaryDestinationPoints();
				
				for (Point p : tempDestPoints) {
					if (!CollisionUtils.areThereObstaclesInMyPath(agent, p)) {
						destination = p;
						break;
					}
				}
			}
			
			int xDest = (agent.getLocation().getX() == destination.getX()) ? 0 :
				(agent.getLocation().getX() > destination.getX()) ? -1 : 1;
			int yDest = agent.getLocation().getY() == destination.getY() ? 0 :
				(agent.getLocation().getY() > destination.getY()) ? -1 : 1;
			

		
			//if (AlgorithUtilities.howFarToClosestExit(agent) < 50) agent.setDirection(new Point(xDest, yDest));
			if (CollisionUtils.canIMoveThere(agent, xDest, yDest)) {
				agent.setDirection(new Point(xDest, yDest));
			} 
			else if (CollisionUtils.canIMoveThere(agent, xDest, 0)) {
				agent.setDirection(new Point(xDest, 0));
			}
			else if (CollisionUtils.canIMoveThere(agent, 0, yDest)) {
				agent.setDirection(new Point(0, yDest));
			}
			else if (CollisionUtils.canIMoveThere(agent, xDest, -yDest)) {
				agent.setDirection(new Point(xDest, -yDest));
			} 
			else if (CollisionUtils.canIMoveThere(agent, -xDest, yDest)){
				agent.setDirection(new Point(-xDest, yDest));
			} else {
				agent.setDirection(new Point(0, 0));
			}
		} 
	}
	
	public void moveAgent(Agent agent) {
		
		Point direction = agent.getDirection();
		if (direction == null) return;
		agent.setLocation(new Point(agent.getLocation().getX() + direction.getX(),
						agent.getLocation().getY() + direction.getY()));
		
		ArrayList<Exit> exits = (ArrayList<Exit>) SimulationResources.building.getFloors().get(agent.getFloor()).getExits();
		
		for (Exit e : exits) {			
			if (MathUtils.getDistanceBetweenPointAndLine(e.getBegin(), e.getEnd(), agent.getLocation()) < 25) {
				agent.setEscaped(true);
			}
		}
	}

}

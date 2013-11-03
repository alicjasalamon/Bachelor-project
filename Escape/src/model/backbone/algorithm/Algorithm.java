package model.backbone.algorithm;

import java.util.ArrayList;

import model.backbone.agent.Agent;
import model.backbone.agent.Agent.DestinationType;
import model.backbone.building.elements.Exit;
import model.backbone.building.helpers.Point;
import model.backbone.utils.AlgorithUtilities;
import model.backbone.utils.MathUtils;
import resources.SimulationResources;

/**
 * To create a new Algorithm you need to extend this class and override setDestination
 * Optionally you can override setAgentDirection and moveAgent for full control of agents behaviour
 */
public abstract class Algorithm {
	
	//Set agent's destination to which he will try to get
	public abstract void setAgentDestination(Agent agent);
	
	//Set agent's direction towards his destination for the next move
	public void setAgentDirection(Agent agent) {
		if (!(agent.getDestinationType() == DestinationType.None)) {
			
			//Determine the destination
			int xDest = (agent.getLocation().getX() == agent.getDestinationPoint().getX()) ? 0 :
				(agent.getLocation().getX() > agent.getDestinationPoint().getX()) ? -1 : 1;
			int yDest = agent.getLocation().getY() == agent.getDestinationPoint().getY() ? 0 :
				(agent.getLocation().getY() > agent.getDestinationPoint().getY()) ? -1 : 1;
			

			//Pick the route with some randomness if the distance is high:
			//If the distance from the target is higher on one axis
			//it is more likely for that agent to move to the target in a straight line
//			if (MathUtils.getDistanceBetweenTwoPoints(agent.getLocation(), agent.getDestinationPoint()) > 70) {
				//Determine the the target distance
			int xDist = Math.abs(agent.getLocation().getX()- agent.getDestinationPoint().getX());
			int yDist = Math.abs(agent.getLocation().getY()- agent.getDestinationPoint().getY());
//				
//				if (AlgorithUtilities.rand.nextFloat() > (xDist/(xDist+yDist))) {
//					xDest = 0;
//				} else {
//					yDest = 0;
//				}
//			}
			
//			//Try to move
//			while (!AlgorithUtilities.canIMoveThere(agent, xDest, yDest)) {
//				
//			}
			if (AlgorithUtilities.howFarToClosestExit(agent) < 50) agent.setDirection(new Point(xDest, yDest));
			if (AlgorithUtilities.canIMoveThere(agent, xDest, yDest)) {
				agent.setDirection(new Point(xDest, yDest));
			} 
			else if (AlgorithUtilities.canIMoveThere(agent, xDest, 0)) {
				agent.setDirection(new Point(xDest, 0));
			}
			else if (AlgorithUtilities.canIMoveThere(agent, 0, yDest)) {
				agent.setDirection(new Point(0, yDest));
			}
			else if (AlgorithUtilities.canIMoveThere(agent, xDest, -yDest)) {
				agent.setDirection(new Point(xDest, -yDest));
			} 
			else if (AlgorithUtilities.canIMoveThere(agent, -xDest, yDest)){
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

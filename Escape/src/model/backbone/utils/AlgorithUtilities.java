package model.backbone.utils;

import java.util.ArrayList;
import java.util.Random;

import model.backbone.agent.Agent;
import model.backbone.agent.Agent.DestinationType;
import model.backbone.building.elements.Exit;
import model.backbone.building.elements.Sign;
import model.backbone.building.elements.Wall;
import model.backbone.building.helpers.Point;
import resources.SimulationResources;

public class AlgorithUtilities {

	public static Random rand = new Random();
	
	
	//Checks whether the target is behind the wall
	public static boolean canISeeIt(Agent me, Point myTarget) {
		
		ArrayList<Wall> walls = (ArrayList<Wall>) SimulationResources.building.getFloors().get(me.getFloor()).getWalls();

		for (Wall w : walls) {			
			if (MathUtils.doLinesIntersect(me.getLocation(), myTarget, w.getBegin(), w.getEnd())) {
				return false;
			}
		}
		return true;		
	}
	
	//Checks whether agent can see any exit points
	public static boolean canISeeAnyExit(Agent me) {
		
		ArrayList<Exit> exits = (ArrayList<Exit>) SimulationResources.building.getFloors().get(me.getFloor()).getExits();

		for (Exit e : exits) {			
			if (canISeeIt(me, e.getBegin()) || canISeeIt(me, e.getEnd())
					|| canISeeIt(me, MathUtils.getMiddlePointOfTheLine(e.getBegin(), e.getEnd()))) {
				return true;
			}
		}
		return false;
	}
	
	//Checks whether agent can see any signs
	public static boolean canISeeAnySigns(Agent me) {
		
		ArrayList<Sign> signs = (ArrayList<Sign>) SimulationResources.building.getFloors().get(me.getFloor()).getSigns();

		for (Sign s : signs) {			
			if (canISeeIt(me, s.getBegin()) || canISeeIt(me, s.getEnd())
					|| canISeeIt(me, MathUtils.getMiddlePointOfTheLine(s.getBegin(), s.getEnd()))) {
				return true;
			}
		}
		return false;
	}
	
	//Agent tries to propagate his information about the exit to others
	public static void letThemKnowAboutTheExit(Agent me) {
		ArrayList<Agent> agents = (ArrayList<Agent>) SimulationResources.building.getAgents();
	
		for (Agent a : agents) {
			//check if its not the same agent!
			if (a.equals(me)) continue;
			//Can the agents hear each other?
			if (a.getFloor() == me.getFloor() && canISeeIt(me, a.getLocation())) {
				
				//Random chance for reaction to hearing information
				if (rand.nextInt(100) > 20) {
					
					//React to information by changing destination
					a.setDestination(me.getDestinationType(), me.getDestinationPoint());
				}
				// else ignore information
			}
		}
	}
	
	public static void moveTowardsTheDestination(Agent me) {
		if (!(me.getDestinationType() == DestinationType.None)) {
			
			//Determine the destination
			int xDest = (me.getLocation().getX() == me.getDestinationPoint().getX()) ? 0 :
				(me.getLocation().getX() > me.getDestinationPoint().getX()) ? -1 : 1;
			int yDest = me.getLocation().getY() == me.getDestinationPoint().getY() ? 0 :
				(me.getLocation().getY() > me.getDestinationPoint().getY()) ? -1 : 1;
			
			//Flag determining if the agent should "hug the wall"
			boolean wallHugger= false;
			//Check if you are close to the wall
			//X axis:
			if (!canISeeIt(me, new Point(me.getLocation().getX()+20*xDest, me.getLocation().getY()))) {
				xDest = 0;
				wallHugger = true;
			} else if (!canISeeIt(me, new Point(me.getLocation().getX(), me.getLocation().getY()+20*yDest))) {
				yDest = 0;
				wallHugger = true;
			}
			//Pick the route with some randomness if the distance is high:
			//If the distance from the target is higher on one axis
			//it is more likely for that agent to move to the target in a straight line
			if (!wallHugger && MathUtils.getDistanceBetweenTwoPoints(me.getLocation(), me.getDestinationPoint()) > 70) {
				//Determine the the target distance
				int xDist = Math.abs(me.getLocation().getX()- me.getDestinationPoint().getX());
				int yDist = Math.abs(me.getLocation().getY()- me.getDestinationPoint().getY());
				
				if (rand.nextFloat() > (xDist/(xDist+yDist))) {
					xDest = 0;
				} else {
					yDest = 0;
				}
			}
			//Try to move
			if (canIMoveThere(me, xDest, yDest)) {
				moveAgent(me,new Point(xDest,yDest));
			}
		}
		
	}
	
	public static boolean canIMoveThere(Agent me, int xDest, int yDest) {
		ArrayList<Agent> agents = (ArrayList<Agent>) SimulationResources.building.getAgents();
		ArrayList<Wall> walls = (ArrayList<Wall>) SimulationResources.building.getFloors().get(me.getFloor()).getWalls();
		Point myDestination = new Point(me.getLocation().getX()+xDest, me.getLocation().getY()+yDest);
		//Check if agent will not come too close to the wall
		for (Wall w : walls) {
			if (MathUtils.getDistanceBetweenPointAndLine(w.getBegin(), w.getEnd(), myDestination) < 30) {
				return false;
			}
		}
		
		//Check if any other agent will block this agent's path
		for (Agent a : agents) {
			//check if its not the same agent!
			if (a.equals(me)) continue;
			//Are the agents on the same floor
			if (a.getFloor() == me.getFloor()) {
					//Is any other agent too close to our destination
					if (MathUtils.getDistanceBetweenTwoPoints(a.getLocation(), myDestination) < 30) {
						return false;
					}	
			}
		}
		
		return true;
	}
	
	public static void setDestinationToNearestExit(Agent me) {
		ArrayList<Exit> exits = (ArrayList<Exit>) SimulationResources.building.getFloors().get(me.getFloor()).getExits();
		Exit nearestExit = null;
		int exitDistance = 0;
		
		for (Exit e : exits) {			
			if (canISeeIt(me, e.getBegin()) || canISeeIt(me, e.getEnd())
					|| canISeeIt(me, MathUtils.getMiddlePointOfTheLine(e.getBegin(), e.getEnd()))) {
				if (nearestExit == null || exitDistance > MathUtils.getDistanceBetweenPointAndLine(e.getBegin(), e.getEnd(), me.getDestinationPoint())) {
					nearestExit = e;
					exitDistance = MathUtils.getDistanceBetweenPointAndLine(e.getBegin(), e.getEnd(), me.getLocation());
				} 
			}
		}
		me.setDestination(DestinationType.Exit, MathUtils.getMiddlePointOfTheLine(nearestExit.getBegin(), nearestExit.getEnd()));
	}
	
	public static void setDestinationAccordingToNearestSign(Agent me) {
		ArrayList<Sign> signs = (ArrayList<Sign>) SimulationResources.building.getFloors().get(me.getFloor()).getSigns();
		Sign nearestSign = null;
		int signDistance = 0;
		
		for (Sign s : signs) {			
			if (canISeeIt(me, s.getBegin()) || canISeeIt(me, s.getEnd())
					|| canISeeIt(me, MathUtils.getMiddlePointOfTheLine(s.getBegin(), s.getEnd()))) {
				if (nearestSign == null || signDistance > MathUtils.getDistanceBetweenPointAndLine(s.getBegin(), s.getEnd(), me.getLocation())) {
					nearestSign = s;
					signDistance = MathUtils.getDistanceBetweenPointAndLine(s.getBegin(), s.getEnd(), me.getLocation());
				} 
			}
		}
		
		me.setDestination(DestinationType.Sign, nearestSign.getTarget());
	}
	
	public static void moveAgent(Agent me, Point direction) {
		me.setLocation(new Point(me.getLocation().getX() + direction.getX(),
						me.getLocation().getY() + direction.getY()));
		
		ArrayList<Exit> exits = (ArrayList<Exit>) SimulationResources.building.getFloors().get(me.getFloor()).getExits();
		
		for (Exit e : exits) {			
			if (MathUtils.getDistanceBetweenPointAndLine(e.getBegin(), e.getEnd(), me.getLocation()) < 15) {
				me.setEscaped(true);
			}
		}
	}
	
	
}

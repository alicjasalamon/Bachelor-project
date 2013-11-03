package model.backbone.utils;

import java.util.ArrayList;

import model.backbone.agent.Agent;
import model.backbone.agent.Agent.DestinationType;
import model.backbone.building.elements.Danger;
import model.backbone.building.elements.Exit;
import model.backbone.building.elements.Sign;
import model.backbone.building.elements.Wall;
import model.backbone.building.helpers.Point;
import resources.SimulationResources;

public class AlgorithUtilities {

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
				if (MathUtils.rand.nextInt(100) > 20) {
					
					//React to information by changing destination
					a.setDestination(me.getDestinationType(), me.getDestinationPoint());
				}
				// else ignore information
			}
		}
	}
	
	
	
	public static boolean canIMoveThere(Agent me, int xDest, int yDest) {
		ArrayList<Agent> agents = (ArrayList<Agent>) SimulationResources.building.getAgents();
		ArrayList<Wall> walls = (ArrayList<Wall>) SimulationResources.building.getFloors().get(me.getFloor()).getWalls();
		ArrayList<Danger> dangers = (ArrayList<Danger>) SimulationResources.building.getFloors().get(me.getFloor()).getDangers();
		
		Point myDestination = new Point(me.getLocation().getX()+xDest, me.getLocation().getY()+yDest);
		if (me.getLastLocation() != null &&
				myDestination.stringRepresentation().equals(me.getLastLocation().stringRepresentation())) return false;
		//Check if agent will not come too close to the wall
		for (Wall w : walls) {
			if (MathUtils.getDistanceBetweenPointAndLine(w.getBegin(), w.getEnd(), myDestination) < 30
					&& MathUtils.getDistanceBetweenPointAndLine(w.getBegin(), w.getEnd(), myDestination)
					< MathUtils.getDistanceBetweenPointAndLine(w.getBegin(), w.getEnd(), me.getLocation()) ) {
				return false;
			}
		}
		//Check if agent will not come too close to the danger
		for (Danger d : dangers) {
			if (MathUtils.getDistanceBetweenTwoPoints(d.getCenter(), myDestination) < d.getRadius()+20
					&& MathUtils.getDistanceBetweenTwoPoints(d.getCenter(), myDestination)
					< MathUtils.getDistanceBetweenTwoPoints(d.getCenter(), me.getLocation())  ) {
				return false;
			}
		}
		
		//Check if any other agent will block this agent's path
		for (Agent a : agents) {
			//check if its not the same agent!
			if (a.equals(me) || a.isEscaped()) continue;
			//Are the agents on the same floor
			if (a.getFloor() == me.getFloor()) {
					//Is any other agent too close to our destination
				if (MathUtils.getDistanceBetweenTwoPoints(a.getLocation(), myDestination) < 40
						&& MathUtils.getDistanceBetweenTwoPoints(a.getLocation(), myDestination)
						< MathUtils.getDistanceBetweenTwoPoints(a.getLocation(), me.getLocation())) {
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
//		int distanceToEnd, distanceToBegin,distanceToMiddle;
//		distanceToEnd = MathUtils.getDistanceBetweenTwoPoints(nearestExit.getEnd(), me.getLocation());
//		distanceToBegin = MathUtils.getDistanceBetweenTwoPoints(nearestExit.getBegin(), me.getLocation());
//		distanceToMiddle = MathUtils.getDistanceBetweenTwoPoints(MathUtils.getMiddlePointOfTheLine(nearestExit.getBegin(), nearestExit.getEnd()), me.getLocation());
//		if (distanceToEnd > distanceToBegin ) {
//			if (distanceToBegin > distanceToMiddle) {
//				me.setDestination(DestinationType.Exit, MathUtils.getMiddlePointOfTheLine(nearestExit.getBegin(), nearestExit.getEnd()));
//			} else {
//				me.setDestination(DestinationType.Exit, nearestExit.getBegin());
//			}
//		} else {
//			if (distanceToEnd > distanceToMiddle) {
//				me.setDestination(DestinationType.Exit, MathUtils.getMiddlePointOfTheLine(nearestExit.getBegin(), nearestExit.getEnd()));
//			} else {
//				me.setDestination(DestinationType.Exit, nearestExit.getEnd());
//			}
//		}
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
	
	public static int howFarToClosestExit(Agent me) {
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
		
		return exitDistance;
	}
	
	
	
	
	
}

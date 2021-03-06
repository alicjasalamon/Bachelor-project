package model.backbone.utils;

import java.util.ArrayList;

import model.backbone.agent.Agent;
import model.backbone.agent.Agent.DestinationType;
import model.backbone.building.elements.Exit;
import model.backbone.building.elements.NodeOfInterest;
import model.backbone.building.elements.Sign;
import model.backbone.building.elements.Staircase;
import model.backbone.building.elements.Wall;
import model.backbone.building.helpers.Point;
import resources.SimulationResources;

public class AlgorithmUtilities {


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

	public static boolean canISeeAnyStaircases(Agent me) {
		
		ArrayList<Staircase> staircases = (ArrayList<Staircase>) SimulationResources.building.getStairCases();

		for (Staircase s : staircases) {			
			if (canISeeIt(me, new Point(s.getPoint1().x+s.getLenght()/2,s.getPoint1().y)) || 
					canISeeIt(me, new Point(s.getPoint1().x-s.getLenght()/2,s.getPoint1().y)) || 
					canISeeIt(me, new Point(s.getPoint1().x,s.getPoint1().y+s.getHeight()/2)) || 
					canISeeIt(me, new Point(s.getPoint1().x,s.getPoint1().y-s.getHeight()/2))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean canISeeAnyNodesOfInterest(Agent me) {
		
		ArrayList<NodeOfInterest> nodes = (ArrayList<NodeOfInterest>) SimulationResources.building.getFloors().get(me.getFloor()).getNodesOfInterest();

		for (NodeOfInterest n : nodes) {			
			if (canISeeIt(me, n.getBegin()) || canISeeIt(me, n.getEnd())
					|| canISeeIt(me, MathUtils.getMiddlePointOfTheLine(n.getBegin(), n.getEnd()))) {
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
	
	public static void setDestinationToNearestStaircase(Agent me) {
		ArrayList<Staircase> staircases = (ArrayList<Staircase>) SimulationResources.building.getStairCases();

		
		Staircase nearestStaircase = null;
		int staircaseDistance = 0;
		
		for (Staircase s : staircases) {				
			if (canISeeIt(me, new Point(s.getPoint1().x+s.getLenght()/2,s.getPoint1().y)) || 
					canISeeIt(me, new Point(s.getPoint1().x-s.getLenght()/2,s.getPoint1().y)) || 
					canISeeIt(me, new Point(s.getPoint1().x,s.getPoint1().y+s.getHeight()/2)) || 
					canISeeIt(me, new Point(s.getPoint1().x,s.getPoint1().y-s.getHeight()/2))) {
				if (nearestStaircase == null || staircaseDistance > MathUtils.getDistanceBetweenTwoPoints(s.getPoint1(),me.getLocation())) {
					nearestStaircase = s;
					staircaseDistance = MathUtils.getDistanceBetweenTwoPoints(s.getPoint1(),me.getLocation());
				} 
			}
		}
		
		
		me.setDestination(DestinationType.Staircase, nearestStaircase.getPoint1());
		
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
		NodeOfInterest nearestNode = null;
		if (canISeeAnyNodesOfInterest(me)) {
			ArrayList<NodeOfInterest> nodes = (ArrayList<NodeOfInterest>) SimulationResources.building.getFloors().get(me.getFloor()).getNodesOfInterest();
			
			int nodeDistance = 0;
			
			for (NodeOfInterest n : nodes) {			
				if (canISeeIt(me, n.getBegin()) || canISeeIt(me, n.getEnd())
						|| canISeeIt(me, MathUtils.getMiddlePointOfTheLine(n.getBegin(), n.getEnd()))) {
					if (nearestNode == null || nodeDistance > MathUtils.getDistanceBetweenPointAndLine(n.getBegin(), n.getEnd(), me.getLocation())) {
						nearestNode = n;
						nodeDistance = MathUtils.getDistanceBetweenPointAndLine(n.getBegin(), n.getEnd(), me.getLocation());
					} 
				}
			}
		}
		
		if (canISeeIt(me,nearestSign.getTarget())) {
			me.setDestination(DestinationType.Sign,nearestSign.getTarget());
		} else {
			me.setDestination(DestinationType.Sign, MathUtils.getMiddlePointOfTheLine(nearestSign.getBegin(), nearestSign.getEnd()));
		}
		rerouteThroughNoiIfPossible(nearestNode, me);
		
	}
	
	public static void setDestinationAccordingToNearestNodeOfInterest(Agent me) {
		ArrayList<NodeOfInterest> nodes = (ArrayList<NodeOfInterest>) SimulationResources.building.getFloors().get(me.getFloor()).getNodesOfInterest();
		NodeOfInterest nearestNode = null;
		int nodeDistance = 0;
		
		for (NodeOfInterest n : nodes) {			
			if (canISeeIt(me, n.getBegin()) || canISeeIt(me, n.getEnd())
					|| canISeeIt(me, MathUtils.getMiddlePointOfTheLine(n.getBegin(), n.getEnd()))) {
				if (nearestNode == null || nodeDistance > MathUtils.getDistanceBetweenPointAndLine(n.getBegin(), n.getEnd(), me.getLocation())) {
					nearestNode = n;
					nodeDistance = MathUtils.getDistanceBetweenPointAndLine(n.getBegin(), n.getEnd(), me.getLocation());
				} 
			}
		}
	
		
		me.setDestination(DestinationType.NOI, SimulationResources.utils.getFartherNoiPoint(nearestNode, me));
		
		
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
	
	public static void moveToFirstFloor(Agent me) {
		me.setOnStaircase(true);
		me.setStaircaseTime((me.getFloor())*250);
	}
	
	public static void rerouteThroughNoiIfPossible(NodeOfInterest noi, Agent me) {
		
		Point dest = me.getDestinationPoint();
		Point loc = me.getLocation();
		
		//check if noi is helpful
		if (MathUtils.getDistanceBetweenPointAndLine(noi.getBegin(), noi.getEnd(), dest) >
				MathUtils.getDistanceBetweenTwoPoints(dest, loc)) {
			return;
		}
		ArrayList<Wall> walls = (ArrayList<Wall>) SimulationResources.building.getFloors().get(me.getFloor()).getWalls();
		boolean reroute = false;
		for (Wall w : walls) {			
			if (MathUtils.doLinesIntersect(new Point(loc.x,dest.y), dest, w.getBegin(), w.getEnd())) {
				reroute = true;
			}
			if (MathUtils.doLinesIntersect(new Point(loc.y,dest.x), dest, w.getBegin(), w.getEnd())) {
				reroute = true;
			}
			if (MathUtils.doLinesIntersect(new Point(loc.x,dest.y), loc, w.getBegin(), w.getEnd())) {
				reroute = true;
			}
			if (MathUtils.doLinesIntersect(new Point(loc.y,dest.x), loc, w.getBegin(), w.getEnd())) {
				reroute = true;
			}
		}
		
		if (reroute) {
			me.setSecondaryDestination(me.getDestinationType());
			me.setSecondaryDestinationPoint(dest);
			me.clearDestination();
			me.setDestination(DestinationType.NOI, SimulationResources.utils.getFartherNoiPoint(noi, me));
			me.setRerouting(true);
		}
		
	}
	
}

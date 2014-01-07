package model.backbone.algorithm;

import java.util.Random;

import model.backbone.agent.Agent;
import model.backbone.agent.Agent.DestinationType;
import model.backbone.building.helpers.Point;
import model.backbone.utils.AlgorithmUtilities;
import model.backbone.utils.CollisionUtils;

public class PogoPeopleAlgorithm extends Algorithm {

	Random rand = new Random(System.currentTimeMillis());
	
	@Override
	public void setAgentDestination(Agent agent) {
		agent.setDestination(DestinationType.None,agent.getLocation());
	}

	@Override
	public void setAgentDirection(Agent agent) {
		int x, y;
		x = rand.nextInt(3)-1;
		y = rand.nextInt(3)-1;
		agent.setDirection(new Point(x,y));
	}
	
	@Override
	public void moveAgent(Agent agent) {
		if (CollisionUtils.canIMoveThere(agent, agent.getDirection().x, agent.getDirection().y)) {
			agent.setLocation(new Point(agent.getLocation().x+agent.getDirection().x,agent.getLocation().y+agent.getDirection().y));			
		}
	}
}

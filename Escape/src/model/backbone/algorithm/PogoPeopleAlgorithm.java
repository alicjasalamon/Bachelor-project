package model.backbone.algorithm;

import java.util.Random;

import model.backbone.agent.Agent;
import resources.GUIResources;

public class PogoPeopleAlgorithm implements Algorithm {

	Random rand = new Random(System.currentTimeMillis());
	
	@Override
	public void moveAgent(Agent agent) {
		double x, y, angle;
		angle = rand.nextDouble() * 6.28;
		
		x = Math.sin(angle) * Agent.step;
		y = Math.cos(angle) * Agent.step;
		
		agent.getLocation().setX(agent.getLocation().getX() + x);
		agent.getLocation().setY(agent.getLocation().getY() + y);
	}

}

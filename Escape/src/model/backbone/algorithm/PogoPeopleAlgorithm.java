package model.backbone.algorithm;

import java.util.Random;

import model.backbone.agent.Agent;
import model.backbone.building.helpers.Point;
import resources.GUIResources;

public class PogoPeopleAlgorithm extends Algorithm {

	Random rand = new Random(System.currentTimeMillis());
	
	@Override
	public void setAgentDestination(Agent agent) {
		int x, y;
		x = rand.nextInt(2)-1;
		y = rand.nextInt(2)-1;
		
		agent.getLocation().setX(agent.getLocation().getX() + x);
		agent.getLocation().setY(agent.getLocation().getY() + y);
	}

}

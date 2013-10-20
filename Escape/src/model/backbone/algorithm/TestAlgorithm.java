package model.backbone.algorithm;

import model.backbone.agent.Agent;
import model.backbone.agent.Agent.DestinationType;
import model.backbone.utils.AlgorithUtilities;

public class TestAlgorithm implements Algorithm {

	@Override
	public void makeYourMove(Agent agent) {
		
		//Update agent's destination
		if (!(agent.getDestinationType() == DestinationType.Exit)) {
			lookAround(agent);
		}
		
		//Helping others
//		if (agent.getDestinationType() == DestinationType.Exit) {
//			//Randomly chose to let others know about the exit or not
//			if (AlgorithUtilities.rand.nextInt(100) > 50) {
//				AlgorithUtilities.letThemKnowAboutTheExit(agent);
//			}
//		}
		
		AlgorithUtilities.moveTowardsTheDestination(agent);
		
	}

	public void lookAround(Agent agent) {
		
		//Can the agent see an exit
		if (AlgorithUtilities.canISeeAnyExit(agent)) {
			AlgorithUtilities.setDestinationToNearestExit(agent);
			return;
		}
		
		//Can the agent see a helping sign
		if (agent.getDestinationType() != DestinationType.Sign && AlgorithUtilities.canISeeAnySigns(agent)) {
			AlgorithUtilities.setDestinationAccordingToNearestSign(agent);
			return;
		}

	}
	
}


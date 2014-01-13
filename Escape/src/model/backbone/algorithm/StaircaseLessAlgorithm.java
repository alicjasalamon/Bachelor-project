package model.backbone.algorithm;

import model.backbone.agent.Agent;
import model.backbone.agent.Agent.DestinationType;
import model.backbone.utils.AlgorithmUtilities;

public class StaircaseLessAlgorithm extends Algorithm {

	@Override
	public void setAgentDestination(Agent agent) {
		
		if (agent.isRerouting()) return;
		//Can the agent see an exit
		if (AlgorithmUtilities.canISeeAnyExit(agent)) {
			AlgorithmUtilities.setDestinationToNearestExit(agent);
			return;
		}
		
		//Can the agent see a helping sign
		if (agent.getDestinationType() != DestinationType.Sign && AlgorithmUtilities.canISeeAnySigns(agent)) {
			AlgorithmUtilities.setDestinationAccordingToNearestSign(agent);
			return;
		}
		
		//Can the agent see a node of interest
		if (AlgorithmUtilities.canISeeAnyNodesOfInterest(agent)) {
			AlgorithmUtilities.setDestinationAccordingToNearestNodeOfInterest(agent);
		}
		
		
	}

}

package model.backbone.simulation;

import model.backbone.agent.Agent;
import model.backbone.algorithm.Algorithm;
import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import resources.StatisticsResources;

public class SimulationThread extends Thread{
	
	private boolean shouldSimulationRun;
	private Algorithm simulationAlgorithm;
	
	public SimulationThread() {
		try {
			this.shouldSimulationRun = true;
			simulationAlgorithm = SimulationResources.simulator.getAlgorithm();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
    public void run() {
    	for (;;) {
    		try {
    			if (StatisticsResources.agentsStart == StatisticsResources.agentsEscaped) {
    				SimulationResources.simulationState = SimulationState.Stopped;
    				return;
    			}
				for(Agent a : SimulationResources.building.getAgents())
				{
					if (!a.isEscaped()) {
						
						if (a.isOnStaircase()) {
							a.decreaseStaircaseTime();
						} else {
							simulationAlgorithm.setAgentDestination(a);		
							simulationAlgorithm.setAgentDirection(a);
							simulationAlgorithm.moveAgent(a);
							a.ageHim();
							GUIResources.mapPanel.repaint();
						}
					}
				}
				StatisticsResources.steps++;
				if (!shouldSimulationRun) return;
				
				Thread.sleep((100 - SimulationResources.simulator.getSimulationSpeed())+1);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
    
    public void stopSimulation() {
    	shouldSimulationRun = false;
    }
    
	
}

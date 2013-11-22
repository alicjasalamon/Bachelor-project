package model.backbone.simulation;

import model.backbone.agent.Agent;
import model.backbone.algorithm.Algorithm;
import resources.GUIResources;
import resources.SimulationResources;

public class SimulationThread extends Thread{
	
	private boolean shouldSimulationRun;
	private Algorithm simulationAlgorithm;
	
	public SimulationThread() {
		this.shouldSimulationRun = true;
		simulationAlgorithm = SimulationResources.simulator.getAlgorithm();
	}
	
    public void run() {
    	for (;;) {
			
			if (SimulationResources.building.getAgents().size() == 0) {
				
				//TODO Tuta
			}
			for(Agent a : SimulationResources.building.getAgents())
			{
				if (!a.isEscaped()) {
					simulationAlgorithm.setAgentDestination(a);		
					simulationAlgorithm.setAgentDirection(a);
					simulationAlgorithm.moveAgent(a);
					a.ageHim();
					GUIResources.mapPanel.repaint();
					
				}
			}
			if (!shouldSimulationRun) return;
			try {
				Thread.sleep((100 - SimulationResources.simulator.getSimulationSpeed())*4 + 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
    
    public void stopSimulation() {
    	shouldSimulationRun = false;
    }
    
	
}

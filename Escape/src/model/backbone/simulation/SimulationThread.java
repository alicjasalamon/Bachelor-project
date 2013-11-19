package model.backbone.simulation;

import model.backbone.agent.Agent;
import model.backbone.algorithm.Algorithm;
import resources.GUIResources;
import resources.SimulationResources;

public class SimulationThread extends Thread{
	
	private boolean shouldSimulationRun;
	private Algorithm simulationAlgorithm;
	@SuppressWarnings("unused")
	private int simulationSpeed; 
	
	public SimulationThread() {
		this.shouldSimulationRun = false;
	}
	
	public void initialize(Algorithm algorithm, int simulationSpeed) {
		this.simulationAlgorithm = algorithm;
		this.simulationSpeed = simulationSpeed;
	}
	
    public void run() {
    	try {
	        for (;;) {
	        	if (!shouldSimulationRun) wait();
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
				try {
					Thread.sleep((100 - SimulationResources.simulator.getSimulationSpeed())*4 + 10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    }
    
    public void allowSimulation() {
    	shouldSimulationRun = true;
    }
    
    public void stopSimulation() {
    	shouldSimulationRun = false;
    }
    
    public void setSimulationSpeed(int newSpeed) {
    	simulationSpeed = newSpeed;
    }
	
}

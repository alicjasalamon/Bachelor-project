package model.backbone.simulation;

import java.util.Random;

import model.backbone.agent.Agent;
import model.backbone.algorithm.Algorithm;
import resources.GUIResources;
import resources.SimulationResources;

public class SimulationThread extends Thread{
	
	private Random rand;
	private boolean shouldSimulationRun;
	private Algorithm simulationAlgorithm;
	private int simulationSpeed; 
	
	public SimulationThread(Algorithm algorithm, int simulationSpeed) {
		this.shouldSimulationRun = false;
		this.rand = new Random(System.currentTimeMillis());
		this.simulationAlgorithm = algorithm;
		this.simulationSpeed = simulationSpeed;
	}
	
    public void run() {
    	try {
	        for (;;) {
	        	if (!shouldSimulationRun) wait();
				for(Agent a : SimulationResources.building.getAgents())
				{
					simulationAlgorithm.moveAgent(a);
					GUIResources.mapPanel.repaint();
				}
				try {
					Thread.sleep((100 - simulationSpeed)*4 + 10);
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

package model.backbone.simulation;

import resources.SimulationResources;
import model.backbone.algorithm.Algorithm;

public class Simulator {


	private Algorithm algorithm;
	private int simulationSpeed;
	private SimulationThread simulationThread;
	 
	public void startSimulation() {
		
		SimulationResources.utils.initialize();	
		simulationThread = new SimulationThread();
		simulationThread.start();		
	}
	
	public void pauseSimulation() {
		this.simulationThread.stopSimulation();
	}
	
	public void stopSimulation() {
		//TODO
	}
	
	public void setSimulationSpeed(int speed) {
		this.simulationSpeed = speed;
	}
	
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
    	
    }
	public int getSimulationSpeed() {
		return simulationSpeed;
	}
	
	public Algorithm getAlgorithm() {
		return algorithm;
	}
}

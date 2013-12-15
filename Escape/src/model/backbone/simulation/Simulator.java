package model.backbone.simulation;

import java.io.File;

import resources.SimulationResources;
import resources.StatisticsResources;
import model.backbone.algorithm.Algorithm;
import model.compiler.AlgorithmCompiler;

public class Simulator {


	private Algorithm algorithm;
	private int simulationSpeed;
	private SimulationThread simulationThread;
	 
	public void startSimulation() {
		
		SimulationResources.utils.initialize();	
		StatisticsResources.agentsStart = SimulationResources.building.getAgents().size();
		simulationThread = new SimulationThread();
		simulationThread.start();		
	}
	
	public void pauseSimulation() {
		this.simulationThread.stopSimulation();
	}
	
	public void stopSimulation() {
		this.simulationThread.stopSimulation();
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
	
	public boolean setAlgorithm(File file) {
		try {
			Object algorithmInstance = AlgorithmCompiler.getInstanceOfCompiledAlgorithm(file);
			Algorithm alg = (Algorithm) algorithmInstance;
			this.setAlgorithm(alg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

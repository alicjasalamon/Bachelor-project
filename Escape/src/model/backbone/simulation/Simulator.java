package model.backbone.simulation;

import model.backbone.algorithm.Algorithm;



public class Simulator {

	private enum OveralSimulationState { Started,  Stopped };
	private enum PreciseSimulationState { Running, Paused };
	
	private OveralSimulationState overalState;
	private PreciseSimulationState preciseState;
	private Algorithm algorithm;
	private int simulationSpeed;
	private SimulationThread simulationThread;
	 
	 
	public void initialize() {
		this.preciseState = PreciseSimulationState.Paused;
		this.overalState = OveralSimulationState.Stopped;
		this.simulationSpeed = 10;
	}
	
	public void startSimulation() {
		if (this.overalState == OveralSimulationState.Stopped) {
			this.overalState = OveralSimulationState.Started;
			this.preciseState = PreciseSimulationState.Running;
			simulationThread = new SimulationThread(algorithm, simulationSpeed);
			simulationThread.allowSimulation();
			simulationThread.start();
		} else if (this.preciseState == PreciseSimulationState.Paused ){
			this.preciseState = PreciseSimulationState.Running;
			this.simulationThread.allowSimulation();
			this.simulationThread.notifyAll();
			
		}
		
	}
	
	public void pauseSimulation() {
		this.preciseState = PreciseSimulationState.Paused;
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
}

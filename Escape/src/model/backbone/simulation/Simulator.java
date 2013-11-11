package model.backbone.simulation;

import resources.SimulationResources;
import model.backbone.algorithm.Algorithm;
import model.backbone.algorithm.TestAlgorithm;



public class Simulator {

	private enum OveralSimulationState { Started,  Stopped };
	private enum PreciseSimulationState { Running, Paused };
	
	private OveralSimulationState overalState;
	private PreciseSimulationState preciseState;
	private Algorithm algorithm;
	private int simulationSpeed;
	private SimulationThread simulationThread;
	 
	 
	public Simulator() {
		this.preciseState = PreciseSimulationState.Paused;
		this.overalState = OveralSimulationState.Stopped;
		this.simulationSpeed = 90;
		simulationThread = new SimulationThread();
	}
	
	public void startSimulation() {
		if (this.overalState == OveralSimulationState.Stopped) {
			//May look weird but its initialization of the Simulator
			 
			this.overalState = OveralSimulationState.Started;
			this.preciseState = PreciseSimulationState.Running;
			this.setAlgorithm(new TestAlgorithm());
			simulationThread.initialize(algorithm,simulationSpeed);
			//TODO Tutaj do podpiecia wybieranie algorytmow
			SimulationResources.utils.initialize();	
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
	public int getSimulationSpeed() {
		return simulationSpeed;
	}
}

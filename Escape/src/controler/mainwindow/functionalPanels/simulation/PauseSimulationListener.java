package controler.mainwindow.functionalPanels.simulation;

import resources.SimulationResources;

public class PauseSimulationListener extends SimulationListener {

	@SuppressWarnings("deprecation")
	@Override
	public void act() {
		
		SimulationResources.simulationThread.suspend();

		
	}}
package controler.mainwindow.functionalPanels.simulation;

import resources.SimulationResources;
import model.backbone.simulation.Simulator;

public class PauseSimulationListener extends SimulationListener {

	@SuppressWarnings("deprecation")
	@Override
	public void act() {
		
		SimulationResources.simulator.pauseSimulation();

		
	}}
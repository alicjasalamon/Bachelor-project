package controler.mainwindow.functionalPanels.simulation;

import resources.SimulationResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class RunSimulationListener implements ClickAction {

	@Override
	public void act() {
		
		SimulationResources.simulator.startSimulation();
	}


}
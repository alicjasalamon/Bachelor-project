package controler.mainwindow.functionalPanels.simulation;

import resources.SimulationResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class PauseSimulationListener implements ClickAction {

	@Override
	public void act() {
		SimulationResources.simulator.pauseSimulation();
		
		
		
	}
}
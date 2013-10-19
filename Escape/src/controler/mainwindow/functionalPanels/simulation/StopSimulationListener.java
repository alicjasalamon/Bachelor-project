package controler.mainwindow.functionalPanels.simulation;

import resources.SimulationResources;
import model.backbone.simulation.Simulator;
import controler.mainwindow.functionalPanels.ClickAction;

public class StopSimulationListener implements ClickAction {

	@SuppressWarnings("deprecation")
	@Override
	public void act() {
	
		SimulationResources.simulator.stopSimulation();
		
	}


}

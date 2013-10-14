package controler.mainwindow.functionalPanels.simulation;

import resources.SimulationResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class StopSimulationListener implements ClickAction {

	@SuppressWarnings("deprecation")
	@Override
	public void act() {
	
		SimulationResources.simulationThread.stop();
		SimulationListener.simulationClicksNumber=0;
		
	}


}

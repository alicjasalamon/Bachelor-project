package controler.mainwindow.functionalPanels.simulation;

import resources.SimulationResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class RunSimulationListener implements ClickAction {

	@SuppressWarnings("deprecation")
	@Override
	public void act() {
		
		if(SimulationListener.simulationClicksNumber==0)
		{	
			SimulationListener.simulationClicksNumber++;
			SimulationResources.simulationThread.start();
		}
		else
			SimulationResources.simulationThread.resume();
		
	}


}

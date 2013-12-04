package controler.mainwindow.functionalPanels.simulation;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import resources.StatisticsResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class PauseSimulationListener implements ClickAction {

	@Override
	public void act() {

		if (SimulationResources.simulationState == SimulationState.Running) {
			
			SimulationResources.simulator.pauseSimulation();
			StatisticsResources.timer.cancel();
			GUIResources.setSuccesMessage("Simulation is paused");
			SimulationResources.simulationState = SimulationState.Paused;
			
		} else if (SimulationResources.simulationState == SimulationState.Stopped) {
			
			GUIResources.setErrorMessage("You cannot pause simulation. Run it first.");
		}

	}
}
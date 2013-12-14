package controler.mainwindow.functionalPanels.simuEnvironment;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import controler.mainwindow.functionalPanels.ClickAction;

public class AddAgentListener implements ClickAction {

	@Override
	public void act() {

		if (SimulationResources.simulationState == SimulationState.Stopped) {
			GUIResources.drawDanger = false;
			GUIResources.drawAgent = true;

			GUIResources.setSuccesMessage("Click on map to add an Agent");
		} else {
			GUIResources.setErrorMessage("You cannot add agents while simulation is running");
		}

	}

}

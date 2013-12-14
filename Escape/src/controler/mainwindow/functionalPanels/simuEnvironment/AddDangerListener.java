package controler.mainwindow.functionalPanels.simuEnvironment;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import controler.mainwindow.functionalPanels.ClickAction;

public class AddDangerListener implements ClickAction {

	@Override
	public void act() {

		if (SimulationResources.simulationState == SimulationState.Stopped) {
			GUIResources.drawDanger = true;
			GUIResources.drawAgent = false;
			GUIResources.setSuccesMessage("click on map to add a Danger");

		} else {
			GUIResources.setErrorMessage("You cannot add dangers while simulation is running");
		}
	}

}

package controler.mainwindow.functionalPanels.algorithm;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import view.codeEditors.CodeEditor;
import controler.mainwindow.functionalPanels.ClickAction;

public class CreateNewAlgorithmListener implements ClickAction {

	@Override
	public void act() {

		if (SimulationResources.simulationState == SimulationState.Stopped) {
			new CodeEditor("Java", "new");
			GUIResources.setSuccesMessage("Algorithm successfully created");
		} else {
			GUIResources.setErrorMessage("You cannot create new algorithm while simulation is running");
		}

	}
}

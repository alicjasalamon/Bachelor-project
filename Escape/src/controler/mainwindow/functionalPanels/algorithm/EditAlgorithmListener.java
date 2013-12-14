package controler.mainwindow.functionalPanels.algorithm;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import view.codeEditors.CodeEditor;
import controler.mainwindow.functionalPanels.ClickAction;

public class EditAlgorithmListener implements ClickAction {

	@Override
	public void act() {

		if (SimulationResources.simulationState == SimulationState.Stopped) {
			new CodeEditor("Java", "edit");
			GUIResources.setSuccesMessage("Algorithm successfully edited");
		} else {
			GUIResources.setErrorMessage("You cannot edit new algorithm while simulation is running");
		}
	}


}

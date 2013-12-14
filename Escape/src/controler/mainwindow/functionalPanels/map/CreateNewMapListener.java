package controler.mainwindow.functionalPanels.map;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import view.codeEditors.CodeEditor;
import controler.mainwindow.functionalPanels.ClickAction;

public class CreateNewMapListener implements ClickAction {

	@Override
	public void act() {

		if (SimulationResources.simulationState == SimulationState.Stopped) {
			new CodeEditor("XML", "new");
		} else {
			GUIResources.setErrorMessage("You cannot create new map while simulation is running");
		}
		
	}


}

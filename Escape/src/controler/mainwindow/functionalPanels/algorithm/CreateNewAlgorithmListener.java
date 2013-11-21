package controler.mainwindow.functionalPanels.algorithm;

import resources.GUIResources;
import view.codeEditors.CodeEditor;
import controler.mainwindow.functionalPanels.ClickAction;

public class CreateNewAlgorithmListener implements ClickAction {

	@Override
	public void act() {
		new CodeEditor("Java", "new");
		//jesli sie skompiluje i uda dodac to
		GUIResources.setSuccesMessage("Algorithm successfully created");
		
		//else
		//GUIResources.setErrorMessage("Algorithm compilation failed");
	}


}

package controler.mainwindow.functionalPanels.algorithm;

import resources.GUIResources;
import view.codeEditors.CodeEditor;
import controler.mainwindow.functionalPanels.ClickAction;

public class EditAlgorithmListener implements ClickAction {

	@Override
	public void act() {
		new CodeEditor("Java", "edit");
		//jesli sie skompiluje i uda dodac to
		GUIResources.setSuccesMessage("Algorithm successfully edited");
		
		//else
		//GUIResources.setErrorMessage("Algorithm compilation failed");
	}


}

package controler.mainwindow.functionalPanels.algorithm;

import view.codeEditors.CodeEditor;
import controler.mainwindow.functionalPanels.ClickAction;

public class CreateNewAlgorithmListener implements ClickAction {

	@Override
	public void act() {
		new CodeEditor("Java", "new");
	}


}

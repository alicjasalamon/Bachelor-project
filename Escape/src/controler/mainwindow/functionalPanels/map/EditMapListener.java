package controler.mainwindow.functionalPanels.map;

import view.codeEditors.CodeEditor;
import controler.mainwindow.functionalPanels.ClickAction;

public class EditMapListener implements ClickAction {

	@Override
	public void act() {
		// TODO Auto-generated method stub
		new CodeEditor("XML", "edit");
	}


}

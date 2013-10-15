package controler.mainwindow.functionalPanels.map;

import resources.GUIResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class AddDangerListener implements ClickAction {

	@Override
	public void act() {
		
		GUIResources.drawDanger = true;
		GUIResources.drawAgent = false;

	}

}

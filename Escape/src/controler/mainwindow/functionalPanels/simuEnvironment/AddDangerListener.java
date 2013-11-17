package controler.mainwindow.functionalPanels.simuEnvironment;

import resources.GUIResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class AddDangerListener implements ClickAction {

	@Override
	public void act() {

		GUIResources.drawDanger = true;
		GUIResources.drawAgent = false;
		GUIResources.setSuccesMessage("click on map to add a Danger");
	}

}

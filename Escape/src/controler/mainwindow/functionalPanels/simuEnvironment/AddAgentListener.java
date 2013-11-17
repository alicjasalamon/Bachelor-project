package controler.mainwindow.functionalPanels.simuEnvironment;

import resources.GUIResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class AddAgentListener implements ClickAction {

	@Override
	public void act() {

		GUIResources.drawDanger = false;
		GUIResources.drawAgent = true;
		
		GUIResources.setSuccesMessage("click on map to add an Agent");
	}


}

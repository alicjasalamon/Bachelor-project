package controler.mainwindow.functionalPanels.algorithm;

import java.awt.FileDialog;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import view.mainwindow.functionalPanels.mainPanels.SetAlgorithmPanel;
import controler.mainwindow.functionalPanels.ClickAction;

public class LoadAlgorithmListener implements ClickAction {

	@Override
	public void act() {

		if (SimulationResources.simulationState == SimulationState.Stopped) {
			FileDialog fd = new FileDialog(GUIResources.mainFrame, "Load algorithm", FileDialog.LOAD);
			fd.setDirectory("algorithms");
			fd.setVisible(true);

			String filename = fd.getFile();

			if (!SimulationResources.algorithmsNames.contains(filename.substring(0, filename.length() - 5))) {
				SimulationResources.algorithmsNames.add(filename.substring(0, filename.length() - 5));

				GUIResources.functionalMenuPanel.removeAll();
				GUIResources.functionalMenuPanel.add(new SetAlgorithmPanel());
				GUIResources.functionalMenuPanel.repaint();
				GUIResources.setSuccesMessage("Algorithm successfully loaded");
			} else
				GUIResources.setErrorMessage("That algorithms has been already loaded");

		}
		else{
			GUIResources.setErrorMessage("You cannot load new algorithm while simulation is running");
		}
			

	}

}

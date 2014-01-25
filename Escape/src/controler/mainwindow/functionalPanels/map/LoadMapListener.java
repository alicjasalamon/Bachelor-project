package controler.mainwindow.functionalPanels.map;

import java.awt.FileDialog;

import model.backbone.building.helpers.BuildingExplorer;
import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import view.mainwindow.simulationMap.TabbedMapPanel;
import controler.mainwindow.functionalPanels.ClickAction;

/*
 * tu cos jest nie tak, przy ladowaniu
 * drugiej mapy sie nie odswieza
 */

public class LoadMapListener implements ClickAction {

	@Override
	public void act() {

		if (SimulationResources.simulationState == SimulationState.Stopped) {

			FileDialog fd = new FileDialog(GUIResources.mainFrame, "Choose a building", FileDialog.LOAD);
			fd.setDirectory("building_schema");
			fd.setVisible(true);
			String filename = fd.getFile();

			if (filename != null) {
				SimulationResources.building = new BuildingExplorer().parseBuilding("building_schema/" + filename);

				GUIResources.mapPanel.removeAll();
				TabbedMapPanel newTabbedMapPanel = new TabbedMapPanel();
				GUIResources.mapPanel.add(newTabbedMapPanel);

				//GUIResources.functionalMenuPanel.repaint();
				GUIResources.mainFrame.repaint();
			//	GUIResources.mapPanel.repaint();

				SimulationResources.mapName = filename.substring(0, filename.lastIndexOf('.'));
				GUIResources.setSuccesMessage("Map successfully loaded");
			}

		} else {
			GUIResources.setErrorMessage("You cannot change map while simulation is running");
		}
	}

}
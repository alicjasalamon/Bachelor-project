package controler.mainwindow.functionalPanels.map;

import java.awt.FileDialog;

import model.backbone.building.helpers.BuildingExplorer;

import resources.GUIResources;
import resources.SimulationResources;

import controler.mainwindow.functionalPanels.ClickAction;

public class LoadMapListener implements ClickAction {

	@Override
	public void act() {

		FileDialog fd = new FileDialog(GUIResources.mainFrame, "Choose a building", FileDialog.LOAD);
		fd.setDirectory("building_schema");
		fd.setVisible(true);
		String filename = fd.getFile();
	
		if (filename != null) {
			SimulationResources.building = new BuildingExplorer().parseBuilding("building_schema/" + filename);
			GUIResources.mapPanel.repaint();
		}

	}

}
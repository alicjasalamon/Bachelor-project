package controler.mainwindow.functionalPanels.map;

import java.awt.FileDialog;

import model.backbone.building.helpers.BuildingExplorer;
import resources.GUIResources;
import resources.SimulationResources;
import view.MapXMLEditor;
import controler.mainwindow.functionalPanels.ClickAction;

public class CreateNewMapListener implements ClickAction {

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
		FileDialog fd = new FileDialog(GUIResources.mainFrame, "Choose a building", FileDialog.SAVE);
		fd.setDirectory("building_schema");
		fd.setVisible(true);

		String filename = fd.getFile();
		
		SimulationResources.building = new BuildingExplorer().parseBuilding("building_schema/" + filename);
		GUIResources.mapPanel.repaint();
		
		new MapXMLEditor(fd);
		System.out.println("lol");
		
	}


}

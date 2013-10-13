package view.mainwindow.functionalPanels.mainPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

import resources.GUIResources;

import view.mainwindow.functionalPanels.FunctionalButton;
import view.mainwindow.functionalPanels.FunctionalButtonBackgroundPanel;
import view.mainwindow.functionalPanels.FunctionalPanel;
import view.mainwindow.functionalPanels.FunctionalSlider;
import view.mainwindow.functionalPanels.FunctionalSliderBackgroundPanel;

public class EditMapPanel extends FunctionalPanel{

	private static final long serialVersionUID = -5433820953259752619L;
	
	JPanel addDangerPanel;
	JButton addDanger;
	
	JPanel dangerSizePanel;
	JSlider dangerSize;
	
	JPanel loadMapPanel;
	JButton loadMap;
	
	JPanel editMapPanel;
	JButton editMap;
	
	JPanel createMapPanel;
	JButton createMap;
	
	public EditMapPanel()
	{
		
		addDanger = new FunctionalButton("functionalPanelsIcons\\Danger.png", "Add danger");
		addDangerPanel = new FunctionalButtonBackgroundPanel(addDanger, GUIResources.functionalAddDangerComponents);
		
		dangerSize = new FunctionalSlider();
		dangerSizePanel = new FunctionalSliderBackgroundPanel(dangerSize, "Set danger size", "functionalPanelsIcons\\Size.png");

		loadMap = new FunctionalButton("functionalPanelsIcons\\LoadMap.png", "Load map");
		loadMapPanel = new FunctionalButtonBackgroundPanel(loadMap, GUIResources.functionalLoadMapComponents);
		
		editMap = new FunctionalButton("functionalPanelsIcons\\EditMap.png", "Edit map");
		editMapPanel = new FunctionalButtonBackgroundPanel(editMap, GUIResources.functionalEditMapComponents);
		
		createMap = new FunctionalButton("functionalPanelsIcons\\NewMap.png", "Create new map");
		createMapPanel = new FunctionalButtonBackgroundPanel(createMap, GUIResources.functionalCreateNewMapComponents);
		
		add(addDangerPanel);
		add(dangerSizePanel);
		add(loadMapPanel);
		add(editMapPanel);
		add(createMapPanel);
		
	}
}

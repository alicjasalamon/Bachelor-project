package view.mainwindow.functionalPanels.mainPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

import controler.mainwindow.functionalPanels.map.AddDangerListener;
import controler.mainwindow.functionalPanels.map.CreateNewMapListener;
import controler.mainwindow.functionalPanels.map.EditMapListener;
import controler.mainwindow.functionalPanels.map.LoadMapListener;

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
		addDangerPanel = new FunctionalButtonBackgroundPanel(addDanger, GUIResources.functionalAddDangerComponents, new AddDangerListener());
		
		dangerSize = new FunctionalSlider();
		dangerSizePanel = new FunctionalSliderBackgroundPanel(dangerSize, "Set danger size", "functionalPanelsIcons\\Size.png", GUIResources.functionalSetDangerSizeComponents);

		loadMap = new FunctionalButton("functionalPanelsIcons\\LoadMap.png", "Load map");
		loadMapPanel = new FunctionalButtonBackgroundPanel(loadMap, GUIResources.functionalLoadMapComponents, new LoadMapListener() );
		
		editMap = new FunctionalButton("functionalPanelsIcons\\EditMap.png", "Edit map");
		editMapPanel = new FunctionalButtonBackgroundPanel(editMap, GUIResources.functionalEditMapComponents, new EditMapListener());
		
		createMap = new FunctionalButton("functionalPanelsIcons\\NewMap.png", "Create new map");
		createMapPanel = new FunctionalButtonBackgroundPanel(createMap, GUIResources.functionalCreateNewMapComponents, new CreateNewMapListener());
		
		add(addDangerPanel);
		add(dangerSizePanel);
		add(loadMapPanel);
		add(editMapPanel);
		add(createMapPanel);
		
	}
}

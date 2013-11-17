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
import controler.mainwindow.functionalPanels.map.AddDangerListener;
import controler.mainwindow.functionalPanels.map.CreateNewMapListener;
import controler.mainwindow.functionalPanels.map.DangerSizeListener;
import controler.mainwindow.functionalPanels.map.EditMapListener;
import controler.mainwindow.functionalPanels.map.LoadMapListener;

public class EditMapPanel extends FunctionalPanel{

	private static final long serialVersionUID = -5433820953259752619L;
	

	
	JPanel loadMapPanel;
	JButton loadMap;
	
	JPanel editMapPanel;
	JButton editMap;
	
	JPanel createMapPanel;
	JButton createMap;
	
	public EditMapPanel()
	{
		

		loadMap = new FunctionalButton("functionalPanelsIcons\\LoadMap.png", "Load map");
		loadMapPanel = new FunctionalButtonBackgroundPanel(loadMap, GUIResources.functionalLoadMapComponents, new LoadMapListener() );
		
		editMap = new FunctionalButton("functionalPanelsIcons\\EditMap.png", "Edit map");
		editMapPanel = new FunctionalButtonBackgroundPanel(editMap, GUIResources.functionalEditMapComponents, new EditMapListener());
		
		createMap = new FunctionalButton("functionalPanelsIcons\\NewMap.png", "Create new map");
		createMapPanel = new FunctionalButtonBackgroundPanel(createMap, GUIResources.functionalCreateNewMapComponents, new CreateNewMapListener());
		
		add(loadMapPanel);
		add(editMapPanel);
		add(createMapPanel);
		
	}
}

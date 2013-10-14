package view.mainwindow.functionalPanels.mainPanels;

import javax.swing.JButton;
import javax.swing.JPanel;

import controler.mainwindow.functionalPanels.statisctics.SaveStatisticsListener;
import controler.mainwindow.functionalPanels.statisctics.ShowStatisticsListener;

import resources.GUIResources;

import view.mainwindow.functionalPanels.FunctionalButton;
import view.mainwindow.functionalPanels.FunctionalButtonBackgroundPanel;
import view.mainwindow.functionalPanels.FunctionalPanel;

public class StatisticsPanel extends FunctionalPanel{

	private static final long serialVersionUID = -6754941615816635166L;
	
	JButton showStatistics;
	JPanel showStatisticsPanel;
	
	JButton saveStatistics;
	JPanel saveStatisticsPanel;
	
	public StatisticsPanel() {
		
		showStatistics = new FunctionalButton("functionalPanelsIcons\\Show.png", "Show statistics");
		showStatisticsPanel = new FunctionalButtonBackgroundPanel(showStatistics, GUIResources.functionalShowStatisticsComponents, new ShowStatisticsListener());
		
		saveStatistics = new FunctionalButton("functionalPanelsIcons\\Save.png", "Save statistics");
		saveStatisticsPanel = new FunctionalButtonBackgroundPanel(saveStatistics, GUIResources.functionalSaveStatisticsComponents, new SaveStatisticsListener());
				
		add(showStatisticsPanel);
		add(saveStatisticsPanel);
	}

}

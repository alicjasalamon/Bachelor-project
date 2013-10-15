package controler.mainwindow.functionalPanels.statisctics;

import resources.GUIResources;
import view.mainwindow.statistics.StatisticsPanel;
import controler.mainwindow.functionalPanels.ClickAction;

public class ShowStatisticsListener implements ClickAction {

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
		GUIResources.mapPanel.removeAll();
		GUIResources.mapPanel.add(new StatisticsPanel());
		
		GUIResources.functionalMenuPanel.repaint();
		GUIResources.mainFrame.repaint();
		GUIResources.mainFrame.setVisible(true);
		
		GUIResources.isMapOnMainPanel = false;
		GUIResources.isStatisticOnMainPanel =true;
		
	}


}

package controler.mainwindow.functionalPanels.statisctics;

import resources.GUIResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class ShowStatisticsListener implements ClickAction {

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
		GUIResources.mainPanel.removeAll();
		GUIResources.mainPanel.add(GUIResources.statisticPanel);
//		
//		GUIResources.mapPanel.removeAll();
//		GUIResources.mapPanel.add(new StatisticsPanel());
////		
		GUIResources.mainPanel.repaint();
		GUIResources.functionalMenuPanel.repaint();
		GUIResources.mainFrame.repaint();
		GUIResources.mainFrame.setVisible(true);
		
		GUIResources.isMapOnMainPanel = false;
		GUIResources.isStatisticOnMainPanel =true;
		
	}


}

package controler.mainwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import resources.GUIResources;


public class SetFunctionalPanelListener implements ActionListener{
	
	JPanel functionalPanel;
	
	public SetFunctionalPanelListener(JPanel jPanel) {
		functionalPanel = jPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GUIResources.functionalMenuPanel.removeAll();
		GUIResources.functionalMenuPanel.add(functionalPanel);
		GUIResources.functionalMenuPanel.repaint();
		GUIResources.mainFrame.repaint();
		GUIResources.mainFrame.setVisible(true);
	}

}

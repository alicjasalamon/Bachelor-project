package controler.mainwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import resources.Resources;


public class SetFunctionalPanelListener implements ActionListener{
	
	JPanel functionalPanel;
	
	public SetFunctionalPanelListener(JPanel jPanel) {
		functionalPanel = jPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Resources.functionalMenuPanel.removeAll();
		Resources.functionalMenuPanel.add(functionalPanel);
		Resources.functionalMenuPanel.repaint();
		Resources.mainFrame.repaint();
		Resources.mainFrame.setVisible(true);
	}

}

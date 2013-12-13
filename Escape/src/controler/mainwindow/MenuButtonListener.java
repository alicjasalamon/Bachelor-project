package controler.mainwindow;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import resources.GUIResources;
import view.mainwindow.ElementColection;
import view.mainwindow.functionalPanels.mainPanels.SetAlgorithmPanel;

public class MenuButtonListener implements MouseListener {

	private ElementColection elementColection;
	private Color mouseIn;
	private Color mouseOut;
	private JPanel functionalPanel;

	public MenuButtonListener(ElementColection elementColection, Color mouseIn, Color mouseOut, JPanel functionalPanel) {

		this.elementColection = elementColection;
		this.mouseIn = mouseIn;
		this.mouseOut = mouseOut;
		this.functionalPanel = functionalPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (functionalPanel instanceof SetAlgorithmPanel)
			functionalPanel = new SetAlgorithmPanel();

		if (!GUIResources.isMapOnMainPanel) {
			GUIResources.mainPanel.removeAll();
			GUIResources.mainPanel.add(GUIResources.mapPanel);
			GUIResources.mapPanel.repaint();

			GUIResources.isMapOnMainPanel = true;
			GUIResources.isStatisticOnMainPanel = false;

		}
		GUIResources.functionalMenuPanel.removeAll();
		GUIResources.functionalMenuPanel.add(functionalPanel);
		GUIResources.functionalMenuPanel.repaint();

		GUIResources.mainFrame.repaint();
		GUIResources.mainFrame.setVisible(true);

		GUIResources.setSuccesMessage("");
		GUIResources.drawDanger = false;
		GUIResources.drawAgent = false;

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		for (JComponent j : elementColection.getMenuEditMapComponents()) {
			j.setBackground(mouseIn);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

		for (JComponent j : elementColection.getMenuEditMapComponents()) {
			j.setBackground(mouseOut);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

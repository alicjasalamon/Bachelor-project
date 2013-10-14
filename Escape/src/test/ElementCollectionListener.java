package test;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import resources.GUIResources;

public class ElementCollectionListener implements MouseListener {

	private ElementColection elementColection;
	private Color mouseIn;
	private Color mouseOut;
	private JPanel functionalPanel;

	public ElementCollectionListener(ElementColection elementColection, Color mouseIn, Color mouseOut, JPanel functionalPanel) {

		this.elementColection = elementColection;
		this.mouseIn = mouseIn;
		this.mouseOut = mouseOut;
		this.functionalPanel = functionalPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		GUIResources.functionalMenuPanel.removeAll();
		GUIResources.functionalMenuPanel.add(functionalPanel);

		GUIResources.functionalMenuPanel.repaint();
		GUIResources.mainFrame.repaint();
		GUIResources.mainFrame.setVisible(true);
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

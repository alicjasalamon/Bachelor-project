package controler.mainwindow;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import view.mainwindow.ElementColection;

import controler.mainwindow.functionalPanels.ClickAction;

public class FunctionalSliderListener implements MouseListener {

	private ElementColection elementColection;
	private Color mouseIn;
	private Color mouseOut;

	public FunctionalSliderListener(ElementColection elementColection, Color mouseIn, Color mouseOut) {

		this.elementColection = elementColection;
		this.mouseIn = mouseIn;
		this.mouseOut = mouseOut;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

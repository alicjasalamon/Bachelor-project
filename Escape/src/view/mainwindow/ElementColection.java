package view.mainwindow;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;

public class ElementColection {

	private ArrayList<JComponent> menuEditMapComponents = new ArrayList<JComponent>();

	public ElementColection() {
	}
	
	public ElementColection(ArrayList<JComponent> menuEditMapComponents) {
		this.menuEditMapComponents = menuEditMapComponents;
	}

	public ArrayList<JComponent> getMenuEditMapComponents() {
		return menuEditMapComponents;
	}

	public void addElement(JComponent jComponent) {
		menuEditMapComponents.add(jComponent);
	}

	public void addMouseListener(MouseListener mouseListener) {
		for (JComponent j : menuEditMapComponents) {
			j.addMouseListener(mouseListener);
		}
	}
	
	public void refresh()
	{
		for (JComponent j : menuEditMapComponents) {
			j.repaint();
		}
	}

}


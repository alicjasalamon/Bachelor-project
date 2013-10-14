package view.mainwindow.menubuttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import resources.ColorSet;
import test.ElementColection;
import test.ElementCollectionListener;
import view.mainwindow.BasicControl;

public class MenuButtonBackgroundPanel extends BasicControl {

	private static final long serialVersionUID = 7416615924647206051L;

	JComponent innerComponent;

	public MenuButtonBackgroundPanel(JComponent innerComponent, ElementColection elementColection, JPanel functionalPanel) {
		
		this.innerComponent = innerComponent;
		setPreferredSize(new Dimension(250, 50));
		setBackground(Color.WHITE);
		add(innerComponent);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
		
		elementColection.addElement(this);
		elementColection.addElement(innerComponent);
		elementColection.addMouseListener(new ElementCollectionListener(elementColection, ColorSet.LIGHT_GRAY, ColorSet.WHITE, functionalPanel));
	}

}

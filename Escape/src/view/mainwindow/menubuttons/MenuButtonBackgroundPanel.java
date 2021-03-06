package view.mainwindow.menubuttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import controler.mainwindow.MenuButtonListener;

import resources.ColorSet;
import view.mainwindow.BasicControl;
import view.mainwindow.ElementColection;

public class MenuButtonBackgroundPanel extends BasicControl {

	private static final long serialVersionUID = 7416615924647206051L;

	JComponent innerComponent;

	public MenuButtonBackgroundPanel(JComponent innerComponent, ElementColection elementColection, JPanel functionalPanel) {
		
		super(null);
		this.innerComponent = innerComponent;
		setPreferredSize(new Dimension(250, 50));
		setBackground(Color.WHITE);
		add(innerComponent);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
		
		elementColection.addElement(this);
		elementColection.addElement(innerComponent);
		elementColection.addMouseListener(new MenuButtonListener(elementColection, ColorSet.LIGHT_GRAY, ColorSet.WHITE, functionalPanel));
	}

}

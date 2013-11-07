package view.mainwindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import resources.ColorSet;
import resources.GUIResources;
import view.mainwindow.functionalPanels.FunctionalPanel;
import view.mainwindow.logo.LogoPanel;
import view.mainwindow.menubuttons.MenuButtonsPanel;
import view.mainwindow.simulationMap.TabbedMapPanel;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = -7602245394038939684L;

	public MainWindow() {
		
		super("ESCAPE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0, 0);
		setBackground(ColorSet.WHITE);
		setLayout(new BorderLayout());
		
		GUIResources.mainMenuPanel = new MenuButtonsPanel();
		GUIResources.functionalMenuPanel = new FunctionalPanel();
		GUIResources.mapPanel = new TabbedMapPanel();
		GUIResources.messagePanel = new ErrorPanel();
		
		JPanel helpPanel = new JPanel();
		helpPanel.setLayout(new BorderLayout());
		helpPanel.setPreferredSize(new Dimension(580, 500));
		helpPanel.add(GUIResources.mainMenuPanel, BorderLayout.WEST);
		helpPanel.add(GUIResources.functionalMenuPanel, BorderLayout.CENTER);
		helpPanel.add(GUIResources.messagePanel, BorderLayout.SOUTH);
		
		JPanel emptyPanel = new JPanel();
		emptyPanel.setBackground(Color.PINK);
		emptyPanel.setPreferredSize(new Dimension(30, 10));
	//	helpPanel.add(emptyPanel, BorderLayout.EAST);

		add(new LogoPanel(), BorderLayout.NORTH);
//		add(GUIResources.mainMenuPanel, BorderLayout.WEST);		
//		add(GUIResources.functionalMenuPanel, BorderLayout.CENTER);
		
		add(helpPanel, BorderLayout.WEST);
		add(GUIResources.mapPanel, BorderLayout.EAST);
		
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		System.out.println(getWidth() + " " + getHeight());
	}

}
package view.mainwindow;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import resources.ColorSet;
import resources.GUIResources;
import view.mainwindow.functionalPanels.FunctionalPanel;
import view.mainwindow.logo.LogoPanel;
import view.mainwindow.menubuttons.MenuButtonsPanel;
import view.mainwindow.simulationMap.TabbedMapPanel;
import view.mainwindow.statistics.StatisticsPanel;

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
		GUIResources.statisticPanel = new StatisticsPanel();
		GUIResources.messagePanel = new ErrorPanel();
		
		GUIResources.mainPanel = new JPanel();
		GUIResources.mainPanel.setLayout(new GridLayout(1, 1));
		GUIResources.mainPanel.add(GUIResources.mapPanel);
		GUIResources.mainPanel.setBackground(ColorSet.WHITE);
		
		JPanel helpPanel = new JPanel();
		helpPanel.setLayout(new BorderLayout());
		helpPanel.setPreferredSize(new Dimension(580, 500));
		helpPanel.add(GUIResources.mainMenuPanel, BorderLayout.WEST);
		helpPanel.add(GUIResources.functionalMenuPanel, BorderLayout.CENTER);
		helpPanel.add(GUIResources.messagePanel, BorderLayout.SOUTH);
		add(new LogoPanel(), BorderLayout.NORTH);

		add(helpPanel, BorderLayout.WEST);
		add(GUIResources.mainPanel, BorderLayout.EAST);
		
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
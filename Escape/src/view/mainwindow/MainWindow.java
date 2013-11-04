package view.mainwindow;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import resources.ColorSet;
import resources.GUIResources;
import view.mainwindow.errorPanel.ErrorPanel;
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
		
		add(new LogoPanel(), BorderLayout.NORTH);
		add(GUIResources.mainMenuPanel, BorderLayout.WEST);		
		add(GUIResources.functionalMenuPanel, BorderLayout.CENTER);
		add(GUIResources.mapPanel, BorderLayout.EAST);
		add(GUIResources.messagePanel, BorderLayout.SOUTH);
		
		
		
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		System.out.println(getWidth() + " " + getHeight());
	}

}

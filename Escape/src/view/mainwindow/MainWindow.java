package view.mainwindow;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import resources.ColorSet;
import resources.Resources;
import view.mainwindow.functionalPanels.FunctionalPanel;
import view.mainwindow.logo.LogoPanel;
import view.mainwindow.menubuttons.MenuButtonsPanel;
import view.mainwindow.simualtionMap.MapPanel;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = -7602245394038939684L;

	public MainWindow() {
		
		super("ESCAPE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0, 0);
		setBackground(ColorSet.WHITE);
		setLayout(new BorderLayout());
		
		Resources.mainMenuPanel = new MenuButtonsPanel();
		Resources.functionalMenuPanel = new FunctionalPanel();
		Resources.mapPanel = new MapPanel(Resources.building);
		
		add(new LogoPanel(), BorderLayout.NORTH);
		add(Resources.mainMenuPanel, BorderLayout.WEST);		
		add(Resources.functionalMenuPanel, BorderLayout.CENTER );
		add(Resources.mapPanel, BorderLayout.EAST);
		
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}

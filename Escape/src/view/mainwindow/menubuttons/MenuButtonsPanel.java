package view.mainwindow.menubuttons;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import resources.ColorSet;
import resources.GUIResources;
import view.mainwindow.functionalPanels.mainPanels.AddAgentsPanel;
import view.mainwindow.functionalPanels.mainPanels.EditMapPanel;
import view.mainwindow.functionalPanels.mainPanels.SetAlgorithmPanel;
import view.mainwindow.functionalPanels.mainPanels.SimulationPanel;
import view.mainwindow.functionalPanels.mainPanels.StatisticsPanel;

public class MenuButtonsPanel extends JPanel {

	private static final long serialVersionUID = -5641920951460455251L;
	
	JPanel editMapPanel;
	JButton editMapButton;
	
	JPanel agentsPanel;
	JButton agentsButton;

	JPanel setAlgoPanel;
	JButton setAlgoButton;

	JPanel simulationPanel;
	JButton simulationButton;
	
	JPanel statiscticsPanel;
	JButton statiscticsButton;
	
	public MenuButtonsPanel() {
		
		setPreferredSize(new Dimension(250,10));
		setBackground(ColorSet.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		editMapButton = new MenuButton("buttonIcons\\Maps.png", "Manage maps");
		editMapPanel = new MenuButtonBackgroundPanel(editMapButton, GUIResources.menuEditMapComponents, new EditMapPanel());
		
		agentsButton = new MenuButton("buttonIcons\\Agents.png", "Set simulation environment");
		agentsPanel = new MenuButtonBackgroundPanel(agentsButton, GUIResources.menuManageAgentsComponents, new AddAgentsPanel());
		
		setAlgoButton = new MenuButton("buttonIcons\\Algo.png", "Set algorithm");
		setAlgoPanel = new MenuButtonBackgroundPanel(setAlgoButton, GUIResources.menuSetAlgorithmComponents, new SetAlgorithmPanel());

		simulationButton = new MenuButton("buttonIcons\\Run.png", "Simulate");
		simulationPanel = new MenuButtonBackgroundPanel(simulationButton, GUIResources.menuSimulateComponents, new SimulationPanel());
		
		statiscticsButton = new MenuButton("buttonIcons\\Stats.png", "Show statistics");
		statiscticsPanel = new MenuButtonBackgroundPanel(statiscticsButton, GUIResources.menuShowStaticticsComponents, new StatisticsPanel());
		
		JPanel empty = new JPanel();
		empty.setBackground(ColorSet.WHITE);
		empty.setPreferredSize(new Dimension(250,0));
		
		add(empty);
		add(editMapPanel);
		add(agentsPanel);
		add(setAlgoPanel);
		add(simulationPanel);
		add(statiscticsPanel);
		
	}

}

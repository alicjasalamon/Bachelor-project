package view.mainwindow.menubuttons;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import resources.ColorSet;
import view.mainwindow.functionalPanels.mainPanels.AddAgentsPanel;
import view.mainwindow.functionalPanels.mainPanels.EditMapPanel;
import view.mainwindow.functionalPanels.mainPanels.SetAlgorithmPanel;
import view.mainwindow.functionalPanels.mainPanels.SimulationPanel;
import view.mainwindow.functionalPanels.mainPanels.StatisticsPanel;
import controler.mainwindow.SetFunctionalPanelListener;

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
		setLayout(new FlowLayout(FlowLayout.LEFT, 5,10));
		
		editMapButton = new MenuButton("buttonIcons\\Maps.png", "Edit map");
		editMapPanel = new MenuButtonBackgroundPanel(editMapButton);
		
		agentsButton = new MenuButton("buttonIcons\\Agents.png", "Manage agents");
		agentsPanel = new MenuButtonBackgroundPanel(agentsButton);
		
		setAlgoButton = new MenuButton("buttonIcons\\Algo.png", "Set algorithm");
		setAlgoPanel = new MenuButtonBackgroundPanel(setAlgoButton);

		simulationButton = new MenuButton("buttonIcons\\Run.png", "Simulate");
		simulationPanel = new MenuButtonBackgroundPanel(simulationButton);
		
		statiscticsButton = new MenuButton("buttonIcons\\Stats.png", "Show statistics");
		statiscticsPanel = new MenuButtonBackgroundPanel(statiscticsButton);
		
		editMapButton.addActionListener(new SetFunctionalPanelListener(new EditMapPanel()));
		agentsButton.addActionListener(new SetFunctionalPanelListener(new AddAgentsPanel()));
		setAlgoButton.addActionListener(new SetFunctionalPanelListener(new SetAlgorithmPanel()));
		simulationButton.addActionListener(new SetFunctionalPanelListener(new SimulationPanel()));
		statiscticsButton.addActionListener(new SetFunctionalPanelListener(new StatisticsPanel()));
		
		add(editMapPanel);
		add(agentsPanel);
		add(setAlgoPanel);
		add(simulationPanel);
		add(statiscticsPanel);
		
	}

}

package view.mainwindow.functionalPanels.mainPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

import controler.mainwindow.functionalPanels.simulation.PauseSimulationListener;
import controler.mainwindow.functionalPanels.simulation.RunSimulationListener;
import controler.mainwindow.functionalPanels.simulation.SpeedSimulationListener;
import controler.mainwindow.functionalPanels.simulation.StopSimulationListener;

import resources.GUIResources;

import view.mainwindow.functionalPanels.FunctionalButton;
import view.mainwindow.functionalPanels.FunctionalButtonBackgroundPanel;
import view.mainwindow.functionalPanels.FunctionalPanel;
import view.mainwindow.functionalPanels.FunctionalSlider;
import view.mainwindow.functionalPanels.FunctionalSliderBackgroundPanel;

public class SimulationPanel extends FunctionalPanel{

	private static final long serialVersionUID = -5668933651913886087L;
	
	JButton runSimu;
	JPanel runSimuPanel;
	
	JButton pauseSimu;
	JPanel pauseSimuPanel;
	
	JButton stopSimu;
	JPanel stopSimuPanel;
	
	JSlider speedSimu;
	JPanel speedSimuPanel;
	
	public SimulationPanel() {
		
		runSimu = new FunctionalButton("functionalPanelsIcons\\Run.png", "Run simulation");
		runSimuPanel = new FunctionalButtonBackgroundPanel(runSimu, GUIResources.functionalRunSimulationComponents, new RunSimulationListener());
		
		pauseSimu = new FunctionalButton("functionalPanelsIcons\\Pause.png", "Pause simulation");
		pauseSimuPanel = new FunctionalButtonBackgroundPanel(pauseSimu, GUIResources.functionalPauseSimulationComponents, new PauseSimulationListener());
		
		stopSimu = new FunctionalButton("functionalPanelsIcons\\Stop.png", "Stop simulation");
		stopSimuPanel = new FunctionalButtonBackgroundPanel(stopSimu, GUIResources.functionalStopSimulationComponents, new StopSimulationListener());
		
		speedSimu = new FunctionalSlider();
		speedSimu.addChangeListener(new SpeedSimulationListener());
		speedSimuPanel = new FunctionalSliderBackgroundPanel(speedSimu, "Set simulation speed", "functionalPanelsIcons\\Speed.png", GUIResources.functionalSpeedSimulationComponents);
				
		add(runSimuPanel);
		add(pauseSimuPanel);
		add(stopSimuPanel);
		add(speedSimuPanel);
	}
}

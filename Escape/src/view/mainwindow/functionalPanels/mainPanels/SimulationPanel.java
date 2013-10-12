package view.mainwindow.functionalPanels.mainPanels;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.mainwindow.functionalPanels.FunctionalButton;
import view.mainwindow.functionalPanels.FunctionalButtonBackgroundPanel;
import view.mainwindow.functionalPanels.FunctionalPanel;

public class SimulationPanel extends FunctionalPanel{

	private static final long serialVersionUID = -5668933651913886087L;
	
	JButton runSimu;
	JPanel runSimuPanel;
	
	JButton pauseSimu;
	JPanel pauseSimuPanel;
	
	JButton stopSimu;
	JPanel stopSimuPanel;
	
	public SimulationPanel() {
		
		runSimu = new FunctionalButton("functionalPanelsIcons\\Run.png", "Run simulation");
		runSimuPanel = new FunctionalButtonBackgroundPanel(runSimu);
		
		pauseSimu = new FunctionalButton("functionalPanelsIcons\\Pause.png", "Pause simulation");
		pauseSimuPanel = new FunctionalButtonBackgroundPanel(pauseSimu);
		
		stopSimu = new FunctionalButton("functionalPanelsIcons\\Stop.png", "Stop simulation");
		stopSimuPanel = new FunctionalButtonBackgroundPanel(stopSimu);
				
		add(runSimuPanel);
		add(pauseSimuPanel);
		add(stopSimuPanel);
	}
}

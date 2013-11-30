package controler.mainwindow.functionalPanels.simulation;

import java.util.Timer;
import java.util.TimerTask;

import resources.GUIResources;
import resources.SimulationResources;
import controler.mainwindow.functionalPanels.ClickAction;
import controler.mainwindow.functionalPanels.simuEnvironment.SimulationTimerTask;

public class RunSimulationListener implements ClickAction {

	@Override
	public void act() {
		
		SimulationResources.simulator.startSimulation();
		GUIResources.setSuccesMessage("Simulation is running");
		
		TimerTask task = new SimulationTimerTask(10);
		 
    	Timer timer = new Timer();
    	timer.schedule(task, 0, 1000);
	}


}
package controler.mainwindow.functionalPanels.simulation;

import java.util.Timer;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import resources.StatisticsResources;
import controler.mainwindow.functionalPanels.ClickAction;
import controler.mainwindow.functionalPanels.statisctics.SimulationTimerTask;

public class RunSimulationListener implements ClickAction {

	@Override
	public void act() {
		
		
		if(SimulationResources.simulationState == SimulationState.Stopped)
		{
			StatisticsResources.resetStatisticsData();
		}
		if(SimulationResources.simulationState == SimulationState.Paused ||
				SimulationResources.simulationState == SimulationState.Stopped)
		{
			StatisticsResources.saveAgentsPosition();
			SimulationResources.simulator.startSimulation();
			runSimulationTimer();
		
		}
		SimulationResources.simulationState = SimulationState.Running;
		GUIResources.setSuccesMessage("Simulation is running");
	}
	
	private void runSimulationTimer()
	{
		StatisticsResources.timer = new Timer();
		StatisticsResources.task = new SimulationTimerTask();
		StatisticsResources.timer.schedule(StatisticsResources.task , 0, 1000);
	}

}
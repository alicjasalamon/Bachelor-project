package controler.mainwindow.functionalPanels.simulation;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import resources.StatisticsResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class StopSimulationListener implements ClickAction {

        @Override
        public void act() {
        
        	if (SimulationResources.simulationState == SimulationState.Running ||
        			SimulationResources.simulationState == SimulationState.Paused) {
        
        		SimulationResources.simulator.stopSimulation();
 				GUIResources.setSuccesMessage("Simulation is stopped");
    			SimulationResources.simulationState = SimulationState.Stopped;
    			StatisticsResources.timer.cancel();
    		} else if (SimulationResources.simulationState == SimulationState.Stopped) {
    			
    			GUIResources.setErrorMessage("There is no simulation to stop");
    		}
                
                
        }


}
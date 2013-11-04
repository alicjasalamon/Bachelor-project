package controler.mainwindow.functionalPanels.simulation;

import resources.SimulationResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class StopSimulationListener implements ClickAction {

        @Override
        public void act() {
        
                SimulationResources.simulator.stopSimulation();
                
        }


}
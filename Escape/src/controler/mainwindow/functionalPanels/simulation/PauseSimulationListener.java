package controler.mainwindow.functionalPanels.simulation;

import resources.SimulationResources;

public class PauseSimulationListener extends SimulationListener {

        @Override
        public void act() {
                
                SimulationResources.simulator.pauseSimulation();

                
        }}
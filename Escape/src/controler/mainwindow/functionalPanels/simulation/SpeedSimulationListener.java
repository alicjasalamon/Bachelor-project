package controler.mainwindow.functionalPanels.simulation;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import resources.SimulationResources;

public class SpeedSimulationListener implements ChangeListener{

	@Override
	public void stateChanged(ChangeEvent e) {
		
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			SimulationResources.simulator.setSimulationSpeed(source.getValue() + 1);
		}
	}
}

package controler.mainwindow.functionalPanels.simuEnvironment;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.backbone.building.elements.Danger;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;

public class DangerSizeListener implements ChangeListener {

	/*
	 * Danger size formula: y = ax + b; 
	 * x is jSlider value
	 */
	private static final double a = 1.4;
	private static final double b = 60;

	@Override
	public void stateChanged(ChangeEvent e) {
		
		if (SimulationResources.simulationState == SimulationState.Stopped) {
			
			JSlider source = (JSlider) e.getSource();
			if (!source.getValueIsAdjusting()) {

				int newValue = (int) (a *  source.getValue() + b);
				GUIResources.dangerSizeSliderValue = source.getValue();
				Danger.initialRadius = newValue;
				
				if(GUIResources.lastDanger!=null) {
					GUIResources.lastDanger.setRadius( source.getValue());
					GUIResources.lastDanger.setRadius((int) newValue);	
				}
				GUIResources.mapPanel.repaint();

			}
			GUIResources.setSuccesMessage("");
		} else {
			GUIResources.setErrorMessage("You cannot change danger size while simulation is running");
		}

	}

}
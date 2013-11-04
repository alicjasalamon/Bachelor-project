package controler.mainwindow.functionalPanels.map;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import resources.GUIResources;

public class DangerSizeListener implements ChangeListener {

	/*
	 * Danger size formula: y = ax + b; 
	 * x is jSlider value
	 */
	private static final double a = 1.4;
	private static final double b = 60;

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO 

		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {

			double newValue = a *  source.getValue() + b;
			GUIResources.lastDanger.setRadius( source.getValue());
			GUIResources.dangerSizeSliderValue = source.getValue();
			GUIResources.lastDanger.setRadius((int) newValue);
			GUIResources.mapPanel.repaint();

		}

	}

}
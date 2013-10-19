package controler.mainwindow.functionalPanels.map;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import resources.GUIResources;

public class DangerSizeListener implements ChangeListener {

	/*
	 * Danger size formula: y = ax + b; x is jSlider value
	 */
	private static final double a = 0.0035;
	private static final double b = 0.02;

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO 

//		JSlider source = (JSlider) e.getSource();
//		if (!source.getValueIsAdjusting()) {
//
//			GUIResources.lastDanger.setRadius(((double) source.getValue() + 1.0) / 10.0);
//			GUIResources.dangerSizeSliderValue = source.getValue();
//			GUIResources.lastDanger.setRadius(a * GUIResources.dangerSizeSliderValue + b);
//			GUIResources.mapPanel.repaint();
//
//		}

	}

}

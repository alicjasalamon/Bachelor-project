package controler.mainwindow.functionalPanels.map;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DangerSizeListener implements ChangeListener {

	/*
	 * Danger size formula: y = ax + b; x is jSlider value
	 */
	private static final double a = 0.0035;
	private static final double b = 0.02;

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO 

		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {

			GUIResources.lastDanger.setRadius( source.getValue());
			GUIResources.dangerSizeSliderValue = source.getValue();
			GUIResources.lastDanger.setRadius(GUIResources.dangerSizeSliderValue);
			GUIResources.mapPanel.repaint();

		}

	}

}

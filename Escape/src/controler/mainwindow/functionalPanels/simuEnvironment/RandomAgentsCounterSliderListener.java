package controler.mainwindow.functionalPanels.simuEnvironment;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import resources.GUIResources;

public class RandomAgentsCounterSliderListener implements ChangeListener {
	
	@Override
	public void stateChanged(ChangeEvent e) {

		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			int val = source.getValue();
			GUIResources.randomAgentsSliderValue = val;
			GUIResources.mapPanel.repaint();
			GUIResources.setSuccesMessage("Add " + val + " agents on random position");
		}

	}

}

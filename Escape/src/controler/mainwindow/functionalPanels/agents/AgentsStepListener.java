package controler.mainwindow.functionalPanels.agents;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.backbone.agent.Agent;
import resources.GUIResources;

public class AgentsStepListener implements ChangeListener {

	private static final double a = 0.00025;
	private static final double b = 0.005;
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			GUIResources.agentStepSliderValue = source.getValue();
			Agent.step = a * GUIResources.agentStepSliderValue + b;
			GUIResources.mapPanel.repaint();
		}

	}

}

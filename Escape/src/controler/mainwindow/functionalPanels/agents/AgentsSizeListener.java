package controler.mainwindow.functionalPanels.agents;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import resources.GUIResources;

import model.backbone.agent.Agent;

public class AgentsSizeListener implements ChangeListener {

	/*
	 * Agent size formula: y = ax + b; x is jSlider value
	 */
	private static final double a = 0.0006;
	private static final double b = 0.02;
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			GUIResources.agentSizeSliderValue = source.getValue();
			Agent.size = a * GUIResources.agentSizeSliderValue + b;
		}

	}

}

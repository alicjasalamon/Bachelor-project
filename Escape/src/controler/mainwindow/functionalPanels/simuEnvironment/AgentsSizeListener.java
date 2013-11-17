package controler.mainwindow.functionalPanels.simuEnvironment;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import resources.GUIResources;

import model.backbone.agent.Agent;

public class AgentsSizeListener implements ChangeListener {

	/*
	 * Agent size formula: y = ax + b; x is jSlider value
	 */
	private static final double a = 0.4;
	private static final double b = 10.0;
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			
			double newValue = a*source.getValue() + b;
			GUIResources.agentSizeSliderValue = source.getValue();
			Agent.size = (int) newValue;
			GUIResources.mapPanel.repaint();
			System.out.println("zmiana");
		}

	}

}

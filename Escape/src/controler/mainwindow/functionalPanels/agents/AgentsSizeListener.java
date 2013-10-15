package controler.mainwindow.functionalPanels.agents;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import resources.GUIResources;

import model.backbone.agent.Agent;

public class AgentsSizeListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			Agent.size = source.getValue() + 1;
			GUIResources.mapPanel.repaint();

		}

	}

}

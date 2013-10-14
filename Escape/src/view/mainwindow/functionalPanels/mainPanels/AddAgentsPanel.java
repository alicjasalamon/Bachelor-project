package view.mainwindow.functionalPanels.mainPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

import resources.GUIResources;
import view.mainwindow.functionalPanels.FunctionalButton;
import view.mainwindow.functionalPanels.FunctionalButtonBackgroundPanel;
import view.mainwindow.functionalPanels.FunctionalPanel;
import view.mainwindow.functionalPanels.FunctionalSlider;
import view.mainwindow.functionalPanels.FunctionalSliderBackgroundPanel;

public class AddAgentsPanel extends FunctionalPanel{

	private static final long serialVersionUID = -2214054905060884710L;
	
	JPanel addAgentPanel;
	JButton addAgent;
	
	JPanel agentSizePanel;
	JSlider agentSize;

	JPanel agentStepPanel;
	JSlider agentStep;

	
	public AddAgentsPanel()
	{
		addAgent = new FunctionalButton("functionalPanelsIcons\\Add.png", "Add agent");
		addAgentPanel = new FunctionalButtonBackgroundPanel(addAgent, GUIResources.functionalAddAgentComponents);
		
		agentSize = new FunctionalSlider();
		agentSizePanel = new FunctionalSliderBackgroundPanel(agentSize, "Set agent size", "functionalPanelsIcons\\Size.png", GUIResources.functionalSetAgentSizeComponents);
		
		agentStep = new FunctionalSlider();
		agentStepPanel = new FunctionalSliderBackgroundPanel(agentStep, "Set step size  ", "functionalPanelsIcons\\Size.png", GUIResources.functionalSetAgentStepComponents);
		
		add(addAgentPanel);
		add(agentSizePanel);
		add(agentStepPanel);
		
	}

}

package view.mainwindow.functionalPanels.mainPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

import resources.ColorSet;
import resources.GUIResources;
import test.FunctionalElementsListener;

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
		agentSizePanel = new FunctionalSliderBackgroundPanel(agentSize, "Set agent size", "functionalPanelsIcons\\Size.png");
		
		agentStep = new FunctionalSlider();
		agentStepPanel = new FunctionalSliderBackgroundPanel(agentStep, "Set step size  ", "functionalPanelsIcons\\Size.png");
		
		add(addAgentPanel);
		add(agentSizePanel);
		add(agentStepPanel);
		
	}

}

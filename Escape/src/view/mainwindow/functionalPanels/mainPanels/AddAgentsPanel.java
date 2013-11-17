package view.mainwindow.functionalPanels.mainPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

import controler.mainwindow.functionalPanels.agents.AddAgentListener;
import controler.mainwindow.functionalPanels.agents.AgentsSizeListener;
import controler.mainwindow.functionalPanels.agents.AgentsStepListener;
import controler.mainwindow.functionalPanels.map.AddDangerListener;
import controler.mainwindow.functionalPanels.map.DangerSizeListener;

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
	
	JPanel addDangerPanel;
	JButton addDanger;
	
	JPanel dangerSizePanel;
	JSlider dangerSize;
	
	public AddAgentsPanel()
	{

		
		addDanger = new FunctionalButton("functionalPanelsIcons\\Danger.png", "Add danger");
		addDangerPanel = new FunctionalButtonBackgroundPanel(addDanger, GUIResources.functionalAddDangerComponents, new AddDangerListener());
		
		dangerSize = new FunctionalSlider();
		dangerSize.addChangeListener(new DangerSizeListener());
		dangerSizePanel = new FunctionalSliderBackgroundPanel(dangerSize, "Set danger size", "functionalPanelsIcons\\Size.png", GUIResources.functionalSetDangerSizeComponents);

		
		addAgent = new FunctionalButton("functionalPanelsIcons\\Add.png", "Add agent");
		addAgentPanel = new FunctionalButtonBackgroundPanel(addAgent, GUIResources.functionalAddAgentComponents, new AddAgentListener());
		
		agentSize = new FunctionalSlider();
		agentSize.addChangeListener(new AgentsSizeListener());
		agentSizePanel = new FunctionalSliderBackgroundPanel(agentSize, "Set agent size", "functionalPanelsIcons\\Size.png", GUIResources.functionalSetAgentSizeComponents);
	
		add(addDangerPanel);
		add(dangerSizePanel);
		add(addAgentPanel);
		add(agentSizePanel);
		
	}

}

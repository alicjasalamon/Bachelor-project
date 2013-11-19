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
import controler.mainwindow.functionalPanels.simuEnvironment.AddAgentListener;
import controler.mainwindow.functionalPanels.simuEnvironment.AddDangerListener;
import controler.mainwindow.functionalPanels.simuEnvironment.AgentsSizeListener;
import controler.mainwindow.functionalPanels.simuEnvironment.DangerSizeListener;

public class SetSimuEnvironment extends FunctionalPanel{

	private static final long serialVersionUID = -2214054905060884710L;
	
	JPanel addAgentPanel;
	JButton addAgent;
	
	JPanel agentSizePanel;
	JSlider agentSize;
	
	JPanel addDangerPanel;
	JButton addDanger;
	
	JPanel dangerSizePanel;
	JSlider dangerSize;
	
	public SetSimuEnvironment()
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

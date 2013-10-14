package view.mainwindow.functionalPanels.mainPanels;

import javax.swing.JButton;
import javax.swing.JPanel;

import controler.mainwindow.functionalPanels.algorithm.AddNewAlgorithmListener;
import controler.mainwindow.functionalPanels.algorithm.CreateNewAlgorithmListener;

import resources.GUIResources;

import view.mainwindow.functionalPanels.AlgorithmChoicePanel;
import view.mainwindow.functionalPanels.FunctionalButton;
import view.mainwindow.functionalPanels.FunctionalButtonBackgroundPanel;
import view.mainwindow.functionalPanels.FunctionalPanel;

public class SetAlgorithmPanel extends FunctionalPanel {

	private static final long serialVersionUID = -8671142849867956288L;

	JPanel choicePanel;

	JPanel addAlgorithmPanel;
	JButton addAlgorithmButton;
	
	JPanel createAlgorithmPanel;
	JButton createAlgorithmButton;

	
	public SetAlgorithmPanel() {
		
		choicePanel = new AlgorithmChoicePanel();
		
		addAlgorithmButton = new FunctionalButton("functionalPanelsIcons\\Add.png", "Add new algorithm");
		addAlgorithmPanel = new FunctionalButtonBackgroundPanel(addAlgorithmButton, GUIResources.functionalAddNewAlgorithmComponents, new AddNewAlgorithmListener());
		
		createAlgorithmButton = new FunctionalButton("functionalPanelsIcons\\CreateAlgo.png", "Create new algorithm");
		createAlgorithmPanel = new FunctionalButtonBackgroundPanel(createAlgorithmButton, GUIResources.functionalCreateNewAlgorithmComponents, new CreateNewAlgorithmListener());
		
		add(choicePanel);
		add(addAlgorithmPanel);
		add(createAlgorithmPanel);
	}
	
}

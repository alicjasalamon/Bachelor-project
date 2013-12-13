package view.mainwindow.functionalPanels.mainPanels;

import javax.swing.JButton;
import javax.swing.JPanel;

import resources.GUIResources;
import view.mainwindow.functionalPanels.AlgorithmChoicePanel;
import view.mainwindow.functionalPanels.FunctionalButton;
import view.mainwindow.functionalPanels.FunctionalButtonBackgroundPanel;
import view.mainwindow.functionalPanels.FunctionalPanel;
import controler.mainwindow.functionalPanels.algorithm.CreateNewAlgorithmListener;
import controler.mainwindow.functionalPanels.algorithm.EditAlgorithmListener;
import controler.mainwindow.functionalPanels.algorithm.LoadAlgorithmListener;

public class SetAlgorithmPanel extends FunctionalPanel {

	private static final long serialVersionUID = -8671142849867956288L;

	AlgorithmChoicePanel choicePanel;

	JPanel loadAlgorithmPanel;
	JButton loadAlgorithmButton;

	JPanel editAlgorithmPanel;
	JButton editAlgorithmButton;

	JPanel createAlgorithmPanel;
	JButton createAlgorithmButton;

	public SetAlgorithmPanel() {

		choicePanel = new AlgorithmChoicePanel();

		loadAlgorithmButton = new FunctionalButton("functionalPanelsIcons\\LoadAlgo.png", "Load algorithm");
		loadAlgorithmPanel = new FunctionalButtonBackgroundPanel(loadAlgorithmButton, GUIResources.functionalLoadNewAlgorithmComponents, new LoadAlgorithmListener());

		editAlgorithmButton = new FunctionalButton("functionalPanelsIcons\\EditAlgo.png", "Edit algorithm");
		editAlgorithmPanel = new FunctionalButtonBackgroundPanel(editAlgorithmButton, GUIResources.functionalEditAlgorithmComponents, new EditAlgorithmListener());

		createAlgorithmButton = new FunctionalButton("functionalPanelsIcons\\CreateAlgo.png", "Create algorithm");
		createAlgorithmPanel = new FunctionalButtonBackgroundPanel(createAlgorithmButton, GUIResources.functionalCreateNewAlgorithmComponents, new CreateNewAlgorithmListener());

		add(choicePanel);
		add(loadAlgorithmPanel);
		add(editAlgorithmPanel);
		add(createAlgorithmPanel);
	}

	AlgorithmChoicePanel getChoicePanel() {
		return choicePanel;
	}

}

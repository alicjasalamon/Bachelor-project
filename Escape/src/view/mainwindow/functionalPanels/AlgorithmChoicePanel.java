package view.mainwindow.functionalPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import resources.ColorSet;
import resources.FontSet;
import resources.GUIResources;
import resources.SimulationResources;
import test.FunctionalElementsListener;
import view.mainwindow.BasicControl;

public class AlgorithmChoicePanel extends BasicControl {

	private static final long serialVersionUID = 8960236852698490291L;
	
	ArrayList<JRadioButton> agentRadioButtons = new ArrayList<JRadioButton>();
	ButtonGroup buttonGroup;
	
	
	public AlgorithmChoicePanel() {
		
		buttonGroup = new ButtonGroup();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("functionalPanelsIcons\\AlgoChoice.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));	
		add(picLabel);

		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		labelPanel.setPreferredSize(new Dimension(300,50));
		labelPanel.setBackground(ColorSet.LIGHT_GRAY);
		labelPanel.add(picLabel);
		
		JLabel label = new JLabel("Choose algorithm");
		label.setFont(FontSet.MENU_FONT);
		labelPanel.add(label);
		add(labelPanel);
		
		for (int i = 0; i < SimulationResources.agentsNames.size(); i++) {
			JRadioButton j = new JRadioButton(SimulationResources.agentsNames.get(i));
			agentRadioButtons.add(j);
			buttonGroup.add(j);
			j.setFont(FontSet.MENU_FONT);
			j.setFocusable(false);
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
			p.add(j);
			add(p);
			GUIResources.functionalChooseAlgorithmComponents.addElement(p);
			GUIResources.functionalChooseAlgorithmComponents.addElement(j);
			
		}
		
		GUIResources.functionalChooseAlgorithmComponents.addElement(this);
		GUIResources.functionalChooseAlgorithmComponents.addElement(labelPanel);
		GUIResources.functionalChooseAlgorithmComponents.addMouseListener(new FunctionalElementsListener(GUIResources.functionalChooseAlgorithmComponents, ColorSet.DARK_GRAY, ColorSet.LIGHT_GRAY, clickAction));
	}

}

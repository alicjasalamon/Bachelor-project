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

import controler.mainwindow.FunctionalButtonListener;
import controler.mainwindow.functionalPanels.algorithm.ChooseAlgorithmListener;

import resources.ColorSet;
import resources.FontSet;
import resources.GUIResources;
import resources.SimulationResources;
import view.mainwindow.BasicControl;

public class AlgorithmChoicePanel extends BasicControl {

	private static final long serialVersionUID = 8960236852698490291L;
	
	ArrayList<JRadioButton> agentRadioButtons = new ArrayList<JRadioButton>();
	ButtonGroup buttonGroup;
	

	public AlgorithmChoicePanel() {
		
		super(new ChooseAlgorithmListener());
		
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
		
		for (int i = 0; i < SimulationResources.algorithmsNames.size(); i++) {
			addButton(SimulationResources.algorithmsNames.get(i));
		}
		
		GUIResources.functionalChooseAlgorithmComponents.addElement(this);
		GUIResources.functionalChooseAlgorithmComponents.addElement(labelPanel);
		GUIResources.functionalChooseAlgorithmComponents.addMouseListener(new FunctionalButtonListener(GUIResources.functionalChooseAlgorithmComponents, ColorSet.DARK_GRAY, ColorSet.LIGHT_GRAY, clickAction));
	
	}
	
	public void addButton(String name)
	{
		JRadioButton j = new JRadioButton(name);
		agentRadioButtons.add(j);
		buttonGroup.add(j);
		j.setFont(FontSet.MENU_FONT);
		j.setFocusable(false);
		j.setBackground(ColorSet.LIGHT_GRAY);
		JPanel p = new JPanel();
		p.setBackground(ColorSet.LIGHT_GRAY);
		p.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
		p.add(j);
		add(p);
//		if(p==null)
//			System.out.println("pnulll");
//		if(GUIResources.functionalChooseAlgorithmComponents ==null)
//			System.out.println("resources null");
		GUIResources.functionalChooseAlgorithmComponents.addElement(p);
		GUIResources.functionalChooseAlgorithmComponents.addElement(j);
	}

}

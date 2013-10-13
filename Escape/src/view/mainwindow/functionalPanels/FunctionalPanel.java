package view.mainwindow.functionalPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import resources.ColorSet;

public class FunctionalPanel extends JPanel {

	private static final long serialVersionUID = -719179654840591409L;
	
	public FunctionalPanel()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		setPreferredSize(new Dimension(300,500));
		setBackground(ColorSet.WHITE);
	
	}

}

package view.mainwindow.legend;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import resources.ColorSet;

public class LegendPanel extends JPanel{

	private static final long serialVersionUID = -908647821868500632L;
	
	public LegendPanel() {

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(ColorSet.WHITE);
		add(new LegendItemIcon("danger"));
		add(new LegendItemLabel("Danger"));

		add(new LegendItemIcon("exit"));
		add(new LegendItemLabel("Exit"));

		add(new LegendItemIcon("sign"));
		add(new LegendItemLabel("Sign"));

		add(new LegendItemIcon("agent"));
		add(new LegendItemLabel("Agent"));

		add(new LegendItemIcon("staircase"));
		add(new LegendItemLabel("Staircase"));
		
	}

}

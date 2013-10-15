package view.mainwindow.simualtionMap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import resources.ColorSet;
import resources.SimulationResources;

public class TabbedMapPanel extends JPanel{
	
	private static final long serialVersionUID = 5332304395818978112L;

	public TabbedMapPanel() {
		JTabbedPane jTabbedPane = new JTabbedPane();
		jTabbedPane.setFocusable(false);
		
		for(int i = 0; i<SimulationResources.building.getFloors().size(); i++)
		{
			jTabbedPane.add("floor " + (i+1), new MapPanel(i));
		}
		
		//jTabbedPane.setBorder(null);
		jTabbedPane.setPreferredSize(new Dimension(1020, 705));
		setBackground(Color.WHITE);
		
		JPanel empty = new JPanel();
		empty.setPreferredSize(new Dimension(1020, 5));
		empty.setBackground(ColorSet.WHITE);
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setPreferredSize(new Dimension(1020, 710));
		
		add(empty);
		add(jTabbedPane);
	}
}

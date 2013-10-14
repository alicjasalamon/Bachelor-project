package view.mainwindow.simualtionMap;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import resources.SimulationResources;

public class TabbedMapPanel extends JPanel{
	
	private static final long serialVersionUID = 5332304395818978112L;

	public TabbedMapPanel() {
		JTabbedPane jTabbedPane = new JTabbedPane();
		jTabbedPane.setFocusable(false);
		
		jTabbedPane.add("floor1", new MapPanel(SimulationResources.building));
		jTabbedPane.add("floor 2", new MapPanel(SimulationResources.building));
		
		//jTabbedPane.setBorder(null);
		jTabbedPane.setPreferredSize(new Dimension(1020, 705));
		setBackground(Color.WHITE);
		
		add(jTabbedPane);	// TODO Auto-generated constructor stub
	}
}

package view.mainwindow.simulationMap;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import resources.ColorSet;
import resources.SimulationResources;
import test.CanvasPanel;
import view.mainwindow.legend.LegendPanel;

public class TabbedMapPanel extends JPanel{
	
	private static final long serialVersionUID = 5332304395818978112L;

	public TabbedMapPanel() {
		JTabbedPane jTabbedPane = new JTabbedPane();
		jTabbedPane.setFocusable(false);
		
		for(int i = 0; i<SimulationResources.building.getFloors().size(); i++)
		{
			jTabbedPane.add("floor " + (i+1), new CanvasPanel(i));
		}
		
		//jTabbedPane.setBorder(null);
		jTabbedPane.setPreferredSize(new Dimension(1000, 680));
		setBackground(ColorSet.WHITE);
		
		JPanel empty = new JPanel();
		empty.setPreferredSize(new Dimension(950, 5));
		empty.setBackground(ColorSet.WHITE);
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setPreferredSize(new Dimension(1020, 710));
		
	//	add(empty);
		add(jTabbedPane);
		add(new LegendPanel());
	}
}
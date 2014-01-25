package view.mainwindow.simulationMap;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import resources.ColorSet;
import resources.SimulationResources;
import view.mainwindow.legend.LegendPanel;

public class TabbedMapPanel extends JPanel {

	private static final long serialVersionUID = 5332304395818978112L;

	public TabbedMapPanel() {
		
		setLayout(new BorderLayout());
		JTabbedPane jTabbedPane = new JTabbedPane();
		jTabbedPane.setFocusable(false);

		for (int i = 0; i < SimulationResources.building.getFloors().size(); i++) {
			jTabbedPane.add("floor " + (i + 1), new ScrollableMapPanel(i));
		}
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		setBackground(ColorSet.WHITE);
		jTabbedPane.setBackground(ColorSet.WHITE);
		
		setPreferredSize(new Dimension(width - 580, height - 190));
		jTabbedPane.setPreferredSize(new Dimension(width - 600, height - 200));
		
		add(new LegendPanel(), BorderLayout.SOUTH);
		add(jTabbedPane, BorderLayout.CENTER);
		

	}
}
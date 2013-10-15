package view.mainwindow.statistics;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class StatisticsPanel extends JPanel {

	private static final long serialVersionUID = -2686640147259984678L;
	
	public StatisticsPanel()
	{

		JTabbedPane jTabbedPane = new JTabbedPane();
		jTabbedPane.setFocusable(false);
		
		jTabbedPane.add("Current", new CurrentPanel());
		jTabbedPane.add("Set",new SetPanel());
		
		//jTabbedPane.setBorder(null);
		jTabbedPane.setPreferredSize(new Dimension(1020, 705));
		setBackground(Color.WHITE);
		
		add(jTabbedPane);
	}

	
}

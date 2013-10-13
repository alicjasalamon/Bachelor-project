package view.mainwindow.statistics;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class CurrentPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5975244246453455606L;

	public CurrentPanel() {
		
		setLayout(new BorderLayout());
		
		JPanel charts = new JPanel();
		charts.setLayout(new GridLayout(2, 1));
		charts.add(new CurrentTimeChart());
		charts.add(new CurrentStepsChart());	
		
		add(charts, BorderLayout.CENTER);

	}

}

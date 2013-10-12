package view.mainwindow.statistics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
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
		
		JPanel info = new JPanel();
		info.setBackground(Color.WHITE);
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS)); 
		info.add(new JLabel("some important info"));
		info.add(new JLabel("more important info"));		
		
		add(charts, BorderLayout.CENTER);
		add(info, BorderLayout.EAST);
		
	}

}

package view.mainwindow.statistics;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SetPanel extends JPanel {
	
	private static final long serialVersionUID = 9181313831803294587L;

	public SetPanel() {
		
		setLayout(new BorderLayout());
		
		JPanel charts = new JPanel();
		charts.setLayout(new GridLayout(2, 1));
		charts.add(new SetStepsChart());
		charts.add(new SetTimeChart());
		
		JPanel info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS)); 
		info.add(new JLabel("some important info"));
		info.add(new JLabel("more important info"));		
		
		add(charts, BorderLayout.CENTER);
		add(info, BorderLayout.EAST);
		
	}

}

package view.mainwindow.statistics;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.ColorSet;
import resources.FontSet;

public class StatisticsPanel extends JPanel {

	private static final long serialVersionUID = -2686640147259984678L;

	private JLabel agentLabel;
	private JLabel timeLabel;
	private JLabel stepsLabel;
	private StepsChart stepsChart;

	public StatisticsPanel() {
		stepsChart = new StepsChart();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(stepsChart);
		add(createHelpPanel(0, 0, 0, 0));
		

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		
		setPreferredSize(new Dimension(width - 570, height - 190));
	}

	public JLabel getAgentLabel() {
		return agentLabel;
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public JLabel getStepsLabel() {
		return stepsLabel;
	}

	public StepsChart getStepsChart() {
		return stepsChart;
	}

	private JPanel createHelpPanel(int maxAgents, int escapedAgent, int time, int steps) {
	
		JPanel helpPanel = new JPanel();
		helpPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
		helpPanel.setBackground(ColorSet.LIGHT_GRAY);

		agentLabel = new JLabel("Agents esaped: " + escapedAgent + "/" + maxAgents);
		timeLabel = new JLabel("Time: " + time + " s");
		stepsLabel = new JLabel("Steps: " + steps);

		agentLabel.setFont(FontSet.STATICTICS_FONT);
		timeLabel.setFont(FontSet.STATICTICS_FONT);
		stepsLabel.setFont(FontSet.STATICTICS_FONT);

		helpPanel.add(agentLabel);
		helpPanel.add(timeLabel);
		helpPanel.add(stepsLabel);

		return helpPanel;
	}

}

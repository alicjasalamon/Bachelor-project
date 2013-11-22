package view.mainwindow.statistics;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.ColorSet;
import resources.FontSet;

public class StatisticsPanel extends JPanel {

	private static final long serialVersionUID = -2686640147259984678L;
	
	JPanel createHelpPanel(int maxAgents, int escapedAgent, int time, int steps)
	{
		JPanel helpPanel = new JPanel();
		helpPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
		helpPanel.setPreferredSize(new Dimension(1000, 60));
		helpPanel.setBackground(ColorSet.LIGHT_GRAY);
		
		JLabel agentLabel = new JLabel("Agents esaped: " + escapedAgent + "/" + maxAgents);
		JLabel timeLabel = new JLabel("Time: " + time + " s");
		JLabel stepsLabel = new JLabel("Steps: " + steps);
		
		agentLabel.setFont(FontSet.STATICTICS_FONT);
		timeLabel.setFont(FontSet.STATICTICS_FONT);
		stepsLabel.setFont(FontSet.STATICTICS_FONT);
		
		helpPanel.add(agentLabel);
		helpPanel.add(timeLabel);
		helpPanel.add(stepsLabel);
		
		return helpPanel;
	}
	
	public StatisticsPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(new StepsChart());
		add(createHelpPanel(23, 22, 23235, 3423));
	}

	
}

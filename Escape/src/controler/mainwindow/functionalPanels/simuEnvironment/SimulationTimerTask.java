package controler.mainwindow.functionalPanels.simuEnvironment;

import java.util.Random;
import java.util.TimerTask;

import resources.GUIResources;
import resources.StatisticsResources;
import view.mainwindow.statistics.StatisticsPanel;

public class SimulationTimerTask extends TimerTask {


	private Random random = new Random();
	
	@Override
	public void run() {

		refreshStatisticsData();
		refreshStatisticsLabels();

	}

	private void refreshStatisticsData() {
		StatisticsResources.time++;
		StatisticsResources.agentsCurrent += random.nextInt(3);
		StatisticsResources.steps++;
	}

	private void refreshStatisticsLabels() {
		
		StatisticsPanel statisticsPanel = (StatisticsPanel) GUIResources.statisticPanel;
		
		statisticsPanel.getAgentLabel().setText("Agents esaped: " + StatisticsResources.agentsCurrent +
				"/" + StatisticsResources.agentsStart);
		
		statisticsPanel.getTimeLabel().setText("Time: " + StatisticsResources.time + " s");
		statisticsPanel.getStepsLabel().setText("Steps: " + StatisticsResources.steps);
		
		statisticsPanel.getStepsChart().addToChart(StatisticsResources.steps, StatisticsResources.agentsCurrent);

	}
}

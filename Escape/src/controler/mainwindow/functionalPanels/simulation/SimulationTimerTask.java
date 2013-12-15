package controler.mainwindow.functionalPanels.simulation;

import java.util.TimerTask;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import resources.StatisticsResources;
import view.mainwindow.statistics.StatisticsPanel;

public class SimulationTimerTask extends TimerTask {


	@Override
	public void run() {

		refreshStatisticsData();
		refreshStatisticsLabels();

	}

	private void refreshStatisticsData() {
		if (SimulationResources.simulationState == SimulationState.Running) {
			StatisticsResources.time++;
		}
	}

	private void refreshStatisticsLabels() {
		
		StatisticsPanel statisticsPanel = (StatisticsPanel) GUIResources.statisticPanel;
		
		statisticsPanel.getAgentLabel().setText("Agents esaped: " + StatisticsResources.agentsEscaped +
				"/" + StatisticsResources.agentsStart);
		
		statisticsPanel.getTimeLabel().setText("Time: " + StatisticsResources.time + " s");
		statisticsPanel.getStepsLabel().setText("Steps: " + StatisticsResources.steps);
		
		statisticsPanel.getStepsChart().addToChart(StatisticsResources.steps, StatisticsResources.agentsEscaped);

	}
}

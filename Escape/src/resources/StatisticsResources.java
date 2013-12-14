package resources;

import java.util.Timer;
import java.util.TimerTask;

import view.mainwindow.statistics.StatisticsPanel;

public class StatisticsResources {
	
	public static int agentsStart;
	public static int agentsEscaped;
	public static int time;
	public static int steps;
	
	public static TimerTask task;
	public static Timer timer;
	
	public static void resetStatisticsData()
	{
		agentsStart = 0;
		agentsEscaped = 0;
		time = 0;
		steps = 0;
		
		((StatisticsPanel)(GUIResources.statisticPanel)).getStepsChart().removeData();
	}
	

}

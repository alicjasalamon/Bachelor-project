package resources;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import model.backbone.agent.Agent;
import model.backbone.building.helpers.Point;
import view.mainwindow.statistics.StatisticsPanel;

public class StatisticsResources {
	
	public static int agentsStart;
	public static int agentsEscaped;
	public static int time;
	public static int steps;
	
	public static TimerTask task;
	public static Timer timer;
	
	public static String agentsAtBeginning;
	
	public static void resetStatisticsData()
	{
		agentsStart = 0;
		agentsEscaped = 0;
		time = 0;
		steps = 0;
		
		((StatisticsPanel)(GUIResources.statisticPanel)).getStepsChart().removeData();
	}
	
	public static void saveAgentsPosition()
	{
		StringBuilder sb = new StringBuilder();
		for(Agent a : SimulationResources.building.getAgents())
		{
			sb.append(a.getLocation().x).append(", ").append(a.getLocation().y).append(", ").append(a.getFloor()).append("\n");
		}
		
		System.out.println(sb.toString());
		agentsAtBeginning = sb.toString();
	}
	

}

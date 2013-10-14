package resources;

import java.util.ArrayList;

import view.mainwindow.simualtionMap.SimulationThread;

import model.backbone.building.Building;
import model.backbone.building.helpers.BuildingExplorer;

public class SimulationResources {
	
	public static Building building;
	public static ArrayList<String> agentsNames;
	public static Thread simulationThread = new SimulationThread();
	
	
	public static void initialize()
	{
		BuildingExplorer be = new BuildingExplorer();
		building = be.parseBuilding("building_schema/building1.xml");
		agentsNames = new ArrayList<String>();
		agentsNames.add("Pogo people");
		agentsNames.add("Not so smart");
		agentsNames.add("Super smart");
		agentsNames.add("Mensa style");
		
	}

}

package resources;

import java.util.ArrayList;

import model.backbone.algorithm.TestAlgorithm;
import model.backbone.building.Building;
import model.backbone.building.helpers.BuildingExplorer;
import model.backbone.simulation.Simulator;

public class SimulationResources {
	
	public static Building building;
	public static ArrayList<String> agentsNames;
	public static Simulator simulator;
	
	public static void initialize()
	{
		BuildingExplorer be = new BuildingExplorer();
		building = be.parseBuilding("building_schema/building1.xml");
		agentsNames = new ArrayList<String>();
		agentsNames.add("Pogo people");
		agentsNames.add("Not so smart");
		agentsNames.add("Super smart");
		agentsNames.add("Mensa style");
		
		simulator = new Simulator();
		
		
		
	}

}

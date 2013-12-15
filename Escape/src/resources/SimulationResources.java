package resources;

import java.io.File;
import java.util.ArrayList;

import model.backbone.algorithm.TestAlgorithm;
import model.backbone.building.Building;
import model.backbone.building.helpers.BuildingExplorer;
import model.backbone.simulation.Simulator;
import model.backbone.utils.NodeOfInterestUtils;

public class SimulationResources {

	public static SimulationState simulationState;
	public static Building building;
	public static ArrayList<String> algorithmsNames;
	public static Simulator simulator;
	public static NodeOfInterestUtils utils;
	public static String algorithmName = "defaultAlgo";
	public static String mapName ="building1";

	public static void initialize() {
		simulationState = SimulationState.Stopped;
		BuildingExplorer be = new BuildingExplorer();
		building = be.parseBuilding("building_schema/building1.xml");
		algorithmsNames = new ArrayList<String>(findAlgosNames());
		utils = new NodeOfInterestUtils();
		simulator = new Simulator();
		simulator.setAlgorithm(new TestAlgorithm());

	}

	private static ArrayList<String> findAlgosNames() {
		ArrayList<String> algosNames = new ArrayList<String>();
		File folder = new File("algorithms");
		File[] listOfFiles = folder.listFiles();
		
		String name;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				name = listOfFiles[i].getName();
				if(!name.equals("ExampleAlgorithm.java"))
					algosNames.add(name.substring(0, name.length()-5));
			}
		}
		return algosNames;
	}

}

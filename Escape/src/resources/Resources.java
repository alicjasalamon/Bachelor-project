package resources;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.backbone.building.Building;
import model.backbone.building.helpers.BuildingExplorer;

public class Resources {
	
	public static Building building;
	
	public static JFrame mainFrame;
	public static JPanel mainMenuPanel;
	public static JPanel functionalMenuPanel;
	public static JPanel mapPanel;
	public static ArrayList<String> agentsNames;
	
	
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

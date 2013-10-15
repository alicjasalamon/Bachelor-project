package resources;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.mainwindow.ElementColection;

public class GUIResources {

	//////////////////////////////////////////////////////////////////////////////////
	//							main window panels									//
	//////////////////////////////////////////////////////////////////////////////////
	public static JFrame mainFrame;
	public static JPanel mainMenuPanel;
	public static JPanel functionalMenuPanel;
	public static JPanel mapPanel;
	

	public static boolean isMapOnMainPanel = true;
	public static boolean isStatisticOnMainPanel = false;

	//////////////////////////////////////////////////////////////////////////////////
	//							menu buttons										//
	//////////////////////////////////////////////////////////////////////////////////
	public static ElementColection menuEditMapComponents = new ElementColection();
	public static ElementColection menuManageAgentsComponents = new ElementColection();
	public static ElementColection menuSetAlgorithmComponents = new ElementColection(); 
	public static ElementColection menuSimulateComponents = new ElementColection();
	public static ElementColection menuShowStaticticsComponents = new ElementColection();
	
	//////////////////////////////////////////////////////////////////////////////////
	//							edit map components 								//
	//////////////////////////////////////////////////////////////////////////////////
	public static ElementColection functionalAddDangerComponents = new ElementColection();
	public static ElementColection functionalSetDangerSizeComponents = new ElementColection();
	public static ElementColection functionalLoadMapComponents = new ElementColection(); 
	public static ElementColection functionalEditMapComponents = new ElementColection();
	public static ElementColection functionalCreateNewMapComponents = new ElementColection();
	
	//////////////////////////////////////////////////////////////////////////////////
	//							manage agents components 							//
	//////////////////////////////////////////////////////////////////////////////////
	public static ElementColection functionalAddAgentComponents = new ElementColection();
	public static ElementColection functionalSetAgentSizeComponents = new ElementColection();
	public static ElementColection functionalSetAgentStepComponents = new ElementColection();
	
	//////////////////////////////////////////////////////////////////////////////////
	//							set algorithm components 							//
	//////////////////////////////////////////////////////////////////////////////////
	public static ElementColection functionalChooseAlgorithmComponents = new ElementColection();
	public static ElementColection functionalAddNewAlgorithmComponents = new ElementColection();
	public static ElementColection functionalCreateNewAlgorithmComponents = new ElementColection(); 
	
	//////////////////////////////////////////////////////////////////////////////////
	//							simulate components 								//
	//////////////////////////////////////////////////////////////////////////////////
	public static ElementColection functionalRunSimulationComponents = new ElementColection();
	public static ElementColection functionalPauseSimulationComponents = new ElementColection();
	public static ElementColection functionalStopSimulationComponents = new ElementColection(); 
	
	//////////////////////////////////////////////////////////////////////////////////
	//							show statistics components 							//
	//////////////////////////////////////////////////////////////////////////////////
	public static ElementColection functionalShowStatisticsComponents = new ElementColection();
	public static ElementColection functionalSaveStatisticsComponents = new ElementColection();
	
	//////////////////////////////////////////////////////////////////////////////////
	//							Logo info files			 							//
	//////////////////////////////////////////////////////////////////////////////////
	
	public static String aboutPath = "textFiles\\About.txt";
	public static String helpPath = "textFiles\\Help.txt";
	public static String documentationURL = "http://www.example.com";
	
}

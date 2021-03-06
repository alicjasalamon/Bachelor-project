package resources;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.backbone.building.elements.Danger;
import view.mainwindow.ElementColection;
import view.mainwindow.ErrorPanel;

public class GUIResources {

	//////////////////////////////////////////////////////////////////////////////////
	//							main window panels									//
	//////////////////////////////////////////////////////////////////////////////////
	public static JFrame mainFrame;
	public static JPanel mainMenuPanel;
	public static JPanel functionalMenuPanel;
	public static JPanel mainPanel;
	public static JPanel mapPanel;
	public static JPanel statisticPanel;
	public static ErrorPanel messagePanel;
	

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
	public static ElementColection functionalLoadMapComponents = new ElementColection(); 
	public static ElementColection functionalEditMapComponents = new ElementColection();
	public static ElementColection functionalCreateNewMapComponents = new ElementColection();
	
	//////////////////////////////////////////////////////////////////////////////////
	//							manage agents components 							//
	//////////////////////////////////////////////////////////////////////////////////
	public static ElementColection functionalSetDangerSizeComponents = new ElementColection();
	public static ElementColection functionalAddDangerComponents = new ElementColection();
	public static ElementColection functionalAddAgentComponents = new ElementColection();
	public static ElementColection functionalSetAgentSizeComponents = new ElementColection();
	public static ElementColection functionalAddRandomAgentsComponents = new ElementColection();
	public static ElementColection functionalSetRandomAgentsCountComponents = new ElementColection();
	
	//////////////////////////////////////////////////////////////////////////////////
	//							set algorithm components 							//
	//////////////////////////////////////////////////////////////////////////////////
	public static ElementColection functionalChooseAlgorithmComponents = new ElementColection();
	public static ElementColection functionalLoadNewAlgorithmComponents = new ElementColection();
	public static ElementColection functionalEditAlgorithmComponents = new ElementColection();
	public static ElementColection functionalCreateNewAlgorithmComponents = new ElementColection(); 
	
	//////////////////////////////////////////////////////////////////////////////////
	//							simulate components 								//
	//////////////////////////////////////////////////////////////////////////////////
	public static ElementColection functionalRunSimulationComponents = new ElementColection();
	public static ElementColection functionalPauseSimulationComponents = new ElementColection();
	public static ElementColection functionalStopSimulationComponents = new ElementColection(); 
	public static ElementColection functionalSpeedSimulationComponents = new ElementColection();
	
	//////////////////////////////////////////////////////////////////////////////////
	//							show statistics components 							//
	//////////////////////////////////////////////////////////////////////////////////
	public static ElementColection functionalShowStatisticsComponents = new ElementColection();
	public static ElementColection functionalSaveStatisticsComponents = new ElementColection();
	
	//////////////////////////////////////////////////////////////////////////////////
	//							info paths				 							//
	//////////////////////////////////////////////////////////////////////////////////
	
	public static String aboutPath = "textFiles\\About.txt";
	public static String helpPath = "textFiles\\Help.txt";
	public static String documentationURL = "http://www.example.com";
	
	//////////////////////////////////////////////////////////////////////////////////
	//							buttons for drawing 	 							//
	//////////////////////////////////////////////////////////////////////////////////
	
	public static boolean drawAgent = false;
	public static boolean drawDanger = false;
	public static Danger lastDanger;
	
	//////////////////////////////////////////////////////////////////////////////////
	//							initial sizes			 							//
	//////////////////////////////////////////////////////////////////////////////////
	
	public static int dangerSizeSliderValue = 50;
	public static int agentSizeSliderValue = 50;
	public static int agentStepSliderValue = 50;
	public static int randomAgentsSliderValue = 50;
	
	public static void setSuccesMessage(String message)
	{
		messagePanel.label.setForeground(ColorSet.BLACK);
		messagePanel.label.setText(message);
		messagePanel.repaint();
	}
	
	public static void setErrorMessage(String message)
	{
		messagePanel.label.setForeground(ColorSet.RED);
		messagePanel.label.setText(message);
		messagePanel.repaint();
	}
	
}
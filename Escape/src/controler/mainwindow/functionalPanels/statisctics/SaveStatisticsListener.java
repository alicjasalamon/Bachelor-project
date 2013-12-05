package controler.mainwindow.functionalPanels.statisctics;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import controler.mainwindow.functionalPanels.ClickAction;

public class SaveStatisticsListener implements ClickAction {

	StringBuilder sb;

	@Override
	public void act() {
		
		
		if(SimulationResources.simulationState == SimulationState.Stopped)
		{
			//TODO tu nazwa pliku - sklada sie z daty, nazwy algo i nazwy mapy
			sb = new StringBuilder(); 
			sb.append("statistics/");
		//	sb.append(new SimpleDateFormat("yyyy-MM-dd\tHH:mm:ss").format(Calendar.getInstance().getTime()));
			sb.append("AlgoName");
			sb.append("MapName");
			sb.append(".txt");
			
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(sb.toString(), "UTF-8");
				writer.println("The first line");
				writer.println("The second line");
				
				//TODO cos tez bedzie w statystykach, ale co?
				
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	
			GUIResources.setSuccesMessage("Statistics saved in file " + sb.toString());
			//JOptionPane.showMessageDialog(null, "Statistics saved in file /statistics/ziom.txt");
		}
		
		
		
	}


}

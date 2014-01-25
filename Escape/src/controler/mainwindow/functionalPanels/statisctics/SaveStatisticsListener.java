package controler.mainwindow.functionalPanels.statisctics;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jfree.data.xy.XYDataItem;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;
import resources.StatisticsResources;
import view.mainwindow.statistics.StatisticsPanel;
import controler.mainwindow.functionalPanels.ClickAction;

public class SaveStatisticsListener implements ClickAction {

	StringBuilder sb;

	@Override
	public void act() {

		if (SimulationResources.simulationState == SimulationState.Stopped) {
			//TODO tu nazwa pliku - sklada sie z daty, nazwy algo i nazwy mapy
			sb = new StringBuilder();
			sb.append("statistics\\");
			sb.append(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss-").format(Calendar.getInstance().getTime()));
			sb.append(SimulationResources.algorithmName + "-");
			sb.append(SimulationResources.mapName);
			sb.append(".txt");

			PrintWriter writer = null;
			try {
				writer = new PrintWriter(sb.toString(), "UTF-8");

				writer.println("Date:\t\t\t" + new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime()));
				writer.println("Map:\t\t\t" + SimulationResources.mapName);
				writer.println("Algorithm:\t\t" + SimulationResources.algorithmName);

				writer.println("Agents at start:\t" + StatisticsResources.agentsStart);
				writer.println("Agents escaped:\t\t" + StatisticsResources.agentsEscaped);

				writer.println("Simulation time:\t" + StatisticsResources.time);
				writer.println("Simulation steps:\t" + StatisticsResources.steps);

				//agents start positions
				writer.println();
				writer.println("Simulation beginning:\n");
				String[] test = StatisticsResources.agentsAtBeginning.split("\n");
				for(String s : test)
				{
					writer.println(s);
				}
				writer.println();

				//simulation 
				writer.println();
				writer.println("Simulation process:\n");

				for (XYDataItem xy : ((StatisticsPanel) (GUIResources.statisticPanel)).getStepsChart().getData()) {
					writer.print((int) xy.getXValue());
					writer.print(", ");
					writer.print((int) xy.getYValue());
					writer.println();
				}

				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			GUIResources.setSuccesMessage("Statistics saved in file " + sb.toString());
		}

	}

//	private String simulation() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("Simulation process:\n");
//
//		for (XYDataItem xy : ((StatisticsPanel) (GUIResources.statisticPanel)).getStepsChart().getData()) {
//			sb.append("(");
//			sb.append(xy.getXValue());
//			sb.append(", ");
//			sb.append(xy.getYValue());
//			sb.append(")\n");
//		}
//
//		System.out.println(sb.toString());
//		return sb.toString();
//	}

}

package view.mainwindow.statistics;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


public class SetStepsChart extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1955596289090307554L;

	public SetStepsChart() {
	
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(6, "steps", "pogo");
		dataset.setValue(7, "steps", "smart");
		dataset.setValue(8, "steps", "super");
		dataset.setValue(5, "steps", "mensa");

		JFreeChart chart = ChartFactory.createBarChart(
				"Average escape time in simulation steps",
				"agent types", 
				"numer of steps", 
				dataset, 
				PlotOrientation.HORIZONTAL,
				false, true, false);
		
		
		setLayout(new java.awt.BorderLayout());
		
		FontHelper.changeStyleForChart(chart);
		
		final CategoryPlot plot = chart.getCategoryPlot();
		((BarRenderer) plot.getRenderer()).setSeriesPaint(0, Color.DARK_GRAY);

		ChartPanel CP = new ChartPanel(chart);
		
		add(CP,BorderLayout.CENTER);
	//	jPanel1.validate();
	}

}

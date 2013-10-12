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


public class SetTimeChart extends JPanel {
	
	private static final long serialVersionUID = -6516940101040161740L;

	public SetTimeChart() {
	
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(60, "time", "pogo");
		dataset.setValue(50, "time", "smart");
		dataset.setValue(18, "time", "super");
		dataset.setValue(60, "time", "mensa");

		JFreeChart chart = ChartFactory.createBarChart(
				"Average escape time",
				"agent types", 
				"time [ms]", 
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

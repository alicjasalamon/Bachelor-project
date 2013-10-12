package view.mainwindow.statistics;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class CurrentTimeChart extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2981557290221003831L;

	public CurrentTimeChart() {
	
		XYSeries series = new XYSeries("XYGraph");
		series.add(1, 10);
		series.add(2, 58);
		series.add(3, 400);
		series.add(4, 550);
		series.add(5, 900);
		series.add(6, 910);
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		JFreeChart chart = ChartFactory.createXYLineChart(
			"Current simulation - time",
			"time [ms]",
			"number of people escaped", 
			dataset, 
			PlotOrientation.VERTICAL, 
			false, 
			false, 
			false
		);
		
		setLayout(new java.awt.BorderLayout());
		
		FontHelper.changeStyleForChart(chart);
		
		XYPlot plot = (XYPlot) chart.getPlot();
		XYItemRenderer renderer = plot.getRenderer();
		renderer.setSeriesPaint(0, Color.BLACK);
		
		ChartPanel CP = new ChartPanel(chart);
		
		add(CP,BorderLayout.CENTER);
	//	jPanel1.validate();
	}

}

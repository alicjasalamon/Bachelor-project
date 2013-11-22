package view.mainwindow.statistics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import resources.ColorSet;
import resources.FontSet;


public class StepsChart extends JPanel {
	
	private static final long serialVersionUID = -6157011253254478227L;

	public StepsChart() {
	
		XYSeries series = new XYSeries("XYGraph");
		series.add(1, 1);
		series.add(2, 4);
		series.add(3, 4);
		series.add(4, 8);
		series.add(5, 9);
		series.add(6, 10);
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		JFreeChart chart = ChartFactory.createXYLineChart(
			"Current simulation - steps",
			"number of steps",
			"number of Agents escaped", 
			dataset, 
			PlotOrientation.VERTICAL, 
			false, 
			false, 
			false
		);
		
		applyTheme(chart);
		ChartPanel CP = new ChartPanel(chart);
		CP.setPreferredSize(new Dimension(1000, 650));
		CP.setBackground(ColorSet.WHITE);
		add(CP,BorderLayout.CENTER);
		setBackground(ColorSet.WHITE);
		
	}
	
	void applyTheme(JFreeChart chart)
	{
		final StandardChartTheme chartTheme = (StandardChartTheme) org.jfree.chart.StandardChartTheme
				.createJFreeTheme();

		chartTheme.setExtraLargeFont(FontSet.CHART_BIG_FONT);
		chartTheme.setLargeFont(FontSet.CHART_BIG_FONT);
		chartTheme.setRegularFont(FontSet.CHART_FONT);
		chartTheme.setSmallFont(FontSet.CHART_FONT);

		chartTheme.setAxisLabelPaint(ColorSet.BLACK);
		chartTheme.setLegendItemPaint(ColorSet.BLACK);
		chartTheme.setItemLabelPaint(ColorSet.BLACK);
				
		XYPlot plot = (XYPlot) chart.getPlot();
		XYItemRenderer renderer = plot.getRenderer();
		renderer.setSeriesPaint(0, Color.BLACK);


		chartTheme.apply(chart);
	}

}

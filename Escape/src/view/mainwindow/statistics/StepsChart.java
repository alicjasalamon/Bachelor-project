package view.mainwindow.statistics;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import resources.ColorSet;
import resources.FontSet;

public class StepsChart extends JPanel {

	private static final long serialVersionUID = -6157011253254478227L;
	
	private XYSeries series;

	public StepsChart() {

		series = new XYSeries("XYGraph");
//		series.add(1, 1);
//		series.add(2, 4);
//		series.add(3, 4);
//		series.add(4, 8);
//		series.add(5, 9);
//		series.add(6, 10);
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		JFreeChart chart = ChartFactory.createXYLineChart("Current simulation - steps", "number of steps", "number of Agents escaped", dataset, PlotOrientation.VERTICAL, false, false, false);

		ChartPanel CP = new ChartPanel(chart);
		CP.setPreferredSize(new Dimension(1000, 650));
		CP.setBackground(ColorSet.WHITE);
		applyTheme(chart);
		add(CP, BorderLayout.CENTER);
		setBackground(ColorSet.WHITE);

	}

	public void addToChart(int x, int y) {
		series.add(x,y);
	}

	void applyTheme(JFreeChart chart) {
		final StandardChartTheme chartTheme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createJFreeTheme();

		chartTheme.setExtraLargeFont(FontSet.CHART_BIG_FONT);
		chartTheme.setLargeFont(FontSet.CHART_BIG_FONT);
		chartTheme.setRegularFont(FontSet.CHART_FONT);
		chartTheme.setSmallFont(FontSet.CHART_FONT);

		chartTheme.setAxisLabelPaint(ColorSet.BLACK);
		chartTheme.setLegendItemPaint(ColorSet.BLACK);
		chartTheme.setItemLabelPaint(ColorSet.BLACK);

		XYPlot plot = chart.getXYPlot();

		NumberAxis range = (NumberAxis) plot.getRangeAxis();
		range.setTickUnit(new NumberTickUnit(1));

		range = (NumberAxis) plot.getDomainAxis();
		range.setTickUnit(new NumberTickUnit(1));

		XYItemRenderer renderer = plot.getRenderer();
		renderer.setSeriesPaint(0, ColorSet.BLACK);
		chartTheme.apply(chart);
	}

}

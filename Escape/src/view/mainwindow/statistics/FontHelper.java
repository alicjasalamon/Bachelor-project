package view.mainwindow.statistics;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;

public class FontHelper {

	public static void changeStyleForChart(JFreeChart chart) {

		final StandardChartTheme chartTheme = (StandardChartTheme) org.jfree.chart.StandardChartTheme
				.createJFreeTheme();

		final Font font = new Font("Tahoma", Font.PLAIN, 11);
		final Font font2 = new Font("Tahoma", Font.PLAIN, 16);
		final Color color = Color.BLACK;

		chartTheme.setExtraLargeFont(font2);
		chartTheme.setLargeFont(font);
		chartTheme.setRegularFont(font);
		chartTheme.setSmallFont(font);

		chartTheme.setAxisLabelPaint(color);
		chartTheme.setLegendItemPaint(color);
		chartTheme.setItemLabelPaint(color);

		chartTheme.apply(chart);
	}

	public static void setBoldForLabel(JLabel label) {
		Font newLabelFont = new Font(label.getFont().getName(), Font.BOLD,
				label.getFont().getSize());
		label.setFont(newLabelFont);
	}
	
	public static void setGreyForLabel(JLabel label) {
		Font newLabelFont = new Font(label.getFont().getName(), Font.PLAIN,
				label.getFont().getSize());
		label.setFont(newLabelFont);
	}
}

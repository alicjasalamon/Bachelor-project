package view.mainwindow.functionalPanels;

import java.awt.Dimension;

import javax.swing.JSlider;

import resources.ColorSet;

public class FunctionalSlider extends JSlider {

	private static final long serialVersionUID = -3297054794479320285L;
	
	public FunctionalSlider()
	{
		super(0,10,1);
		setAutoscrolls(true);
		setForeground(ColorSet.BLACK);
		setOpaque(true);
		setFocusable(false);
		setPreferredSize(new Dimension(0,30));
	}

}

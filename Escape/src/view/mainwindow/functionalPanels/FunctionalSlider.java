package view.mainwindow.functionalPanels;

import javax.swing.JSlider;

import resources.ColorSet;

public class FunctionalSlider extends JSlider {

	private static final long serialVersionUID = -3297054794479320285L;
	
	public FunctionalSlider()
	{
		super(0,100,50);
		setAutoscrolls(true);
		setForeground(ColorSet.BLACK);
		setOpaque(true);
		setFocusable(false);
//		setBounds(0, 0, 100, 100);
	}

}

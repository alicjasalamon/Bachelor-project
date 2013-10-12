package view.mainwindow.legend;

import java.awt.Dimension;

import javax.swing.JLabel;

import resources.ColorSet;
import resources.FontSet;

public class LegendItemLabel extends JLabel{
	
	private static final long serialVersionUID = -1790641160551211602L;
	
	public LegendItemLabel(String name) {
		super(name);
		setFont(FontSet.MENU_FONT);
		setPreferredSize(new Dimension(80, 50));
		setBackground(ColorSet.WHITE);
	}


}

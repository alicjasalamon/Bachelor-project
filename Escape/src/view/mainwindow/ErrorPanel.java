package view.mainwindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.ColorSet;
import resources.FontSet;

public class ErrorPanel extends JPanel{

	private static final long serialVersionUID = 280516588074061006L;
	
	String message;
	Color fontColor;
	public JLabel label = new JLabel();
	
	public ErrorPanel()
	{
		setBackground(Color.PINK);
		setPreferredSize(new Dimension(20, 30));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		label.setText(message);
		label.setFont(FontSet.ERROR_FONT);
		add(label);
	}
	
}
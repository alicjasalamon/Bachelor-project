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
	
	public ErrorPanel() {
		
		message = "hello :) ";
		fontColor = Color.DARK_GRAY;
		JLabel label = new JLabel(message);
		label.setFont(FontSet.ERROR_FONT);
		label.setForeground(fontColor);
		setBackground(ColorSet.WHITE);
		add(label);
		setPreferredSize(new Dimension(20, 30));
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
	public void updateMessage(String message, boolean success)
	{
		this.message = message;
		fontColor = (success) ? ColorSet.DARK_GRAY : ColorSet.RED;
		this.repaint();
	}
	
}
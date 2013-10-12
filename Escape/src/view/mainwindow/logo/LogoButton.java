package view.mainwindow.logo;

import javax.swing.JButton;

import resources.FontSet;
import controler.mainwindow.logo.LogoButtonListener;

public class LogoButton extends JButton {

	private static final long serialVersionUID = -8398127209650741450L;
	
	public LogoButton(String name) {

		super(name);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setFont(FontSet.MENU_FONT);
		addMouseListener(new LogoButtonListener(this));
	}

}

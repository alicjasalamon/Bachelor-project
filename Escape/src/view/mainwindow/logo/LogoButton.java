package view.mainwindow.logo;

import java.awt.Insets;

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
		this.setMargin(new Insets(0, 5, 0, 5));
		addMouseListener(new LogoButtonListener(this));
	}

}

package view.mainwindow.menubuttons;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import resources.FontSet;

public class MenuButton extends JButton{

	private static final long serialVersionUID = 3582446790326282532L;
	
	public MenuButton(String path, String name) {

		super(name);
		this.setMargin(new Insets(0, 0, 0, 0));
		setHorizontalAlignment(SwingConstants.LEFT);
		setMinimumSize(new Dimension(250,50));
		setIcon(new ImageIcon(path));
		setContentAreaFilled(false);
		setFocusPainted(false);
		setFont(FontSet.MENU_FONT);
	}
}

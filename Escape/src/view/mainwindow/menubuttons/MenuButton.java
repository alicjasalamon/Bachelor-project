package view.mainwindow.menubuttons;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import resources.FontSet;

public class MenuButton extends JButton{

	private static final long serialVersionUID = 3582446790326282532L;
	
	public MenuButton(String path, String name) {

		super(name);
		setHorizontalAlignment(SwingConstants.LEFT);
		setPreferredSize(new Dimension(240, 50));
		setIcon(new ImageIcon(path));
		setContentAreaFilled(false);
		setFocusPainted(false);
		setFont(FontSet.MENU_FONT);
	}
}

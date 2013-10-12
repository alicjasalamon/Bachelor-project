package view.mainwindow.functionalPanels;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import resources.FontSet;

public class FunctionalButton extends JButton {

	private static final long serialVersionUID = -7883121381098204742L;

	public FunctionalButton(String path, String name) {

		super(name);
		setPreferredSize(new Dimension(300, 50));
		setIcon(new ImageIcon(path));
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		setFont(FontSet.MENU_FONT);
		
		setHorizontalAlignment(SwingConstants.LEFT);
	}
}

package view.codeEditors;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import resources.FontSet;

public class SaveButton extends JButton {

	private static final long serialVersionUID = -9134659385480938690L;
	
	
	public SaveButton() {

		super("Save");
		setPreferredSize(new Dimension(300, 50));
		setIcon(new ImageIcon("functionalPanelsIcons\\Save.png"));
		setContentAreaFilled(false);
//		setFocusPainted(false);
		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		setFont(FontSet.MENU_FONT);
		
		setHorizontalAlignment(SwingConstants.LEFT);
	}

}

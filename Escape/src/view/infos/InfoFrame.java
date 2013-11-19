package view.infos;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class InfoFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static JLabel createLabel(String text, Font font) {
		
		JLabel label = new JLabel(text);
		label.setFont(font);
		return label;

	}

}

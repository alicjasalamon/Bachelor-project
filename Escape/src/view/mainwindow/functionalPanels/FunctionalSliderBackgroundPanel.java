package view.mainwindow.functionalPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import resources.FontSet;

public class FunctionalSliderBackgroundPanel extends JPanel {

	private static final long serialVersionUID = -3290278017196725600L;
	
	JSlider slider;

	public FunctionalSliderBackgroundPanel(JSlider jSlider, String name, String path) {
		
		slider = jSlider;
		setPreferredSize(new Dimension(300, 80));
		setBackground(new Color(173, 216, 230));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));		
		JLabel label = new JLabel(" " + name);
		label.setFont(FontSet.MENU_FONT);
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		labelPanel.add(picLabel);
		
		labelPanel.add(label);
		add(labelPanel);
		add(slider);
		
	}

}

package view.mainwindow.functionalPanels;

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

import resources.ColorSet;
import resources.FontSet;
import view.mainwindow.BasicControl;
import view.mainwindow.ElementColection;
import controler.mainwindow.FunctionalButtonListener;

public class FunctionalSliderBackgroundPanel extends BasicControl {

	private static final long serialVersionUID = -3290278017196725600L;
	
	JSlider slider;

	public FunctionalSliderBackgroundPanel(JSlider jSlider, String name, String path, ElementColection elementColection) {
		
		super(null);
		
		slider = jSlider;
		setPreferredSize(new Dimension(300, 80));
		setBackground(ColorSet.LIGHT_GRAY);
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
		
		elementColection.addElement(this);
		elementColection.addElement(jSlider);
		elementColection.addElement(labelPanel);
		elementColection.addMouseListener(new FunctionalButtonListener(elementColection, ColorSet.DARK_GRAY, ColorSet.LIGHT_GRAY, clickAction));
		
	}

}

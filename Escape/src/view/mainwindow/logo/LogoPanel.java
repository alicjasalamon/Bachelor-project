package view.mainwindow.logo;

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

import resources.ColorSet;
import resources.FontSet;

public class LogoPanel extends JPanel{

	private static final long serialVersionUID = -7841166661256560588L;
	
	public LogoPanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//////////////////////////////////////////////////////////
		//					logo & label panel					//
		//////////////////////////////////////////////////////////
		
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		colorPanel.setPreferredSize(new Dimension(50, 60));
		colorPanel.setBackground(ColorSet.LIGHT_GRAY);
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("logo\\escape.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	
		JLabel escapeLabel = new JLabel("ESCape");
		escapeLabel.setFont(FontSet.LOGO_FONT);
		colorPanel.add(picLabel);
		colorPanel.add(escapeLabel);
		
		//////////////////////////////////////////////////////////
		//					logo buttons						//
		//////////////////////////////////////////////////////////
		
		JPanel logoButtons = new JPanel();
		logoButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		logoButtons.setPreferredSize(new Dimension(1400,40));
		logoButtons.setBackground(ColorSet.LIGHT_GRAY);

		logoButtons.add(new LogoButton("About"));
		logoButtons.add(new LogoButton("Help"));
		logoButtons.add(new LogoButton("Documentation"));
		colorPanel.add(logoButtons);

		//////////////////////////////////////////////////////////
		//					empty panel							//
		//////////////////////////////////////////////////////////
		JPanel emptyPanel = new JPanel();
		emptyPanel.setPreferredSize(new Dimension(50,50));
		emptyPanel.setBackground(ColorSet.WHITE);
		
		add(colorPanel);
		add(emptyPanel);

	}



}

package view.mainwindow.legend;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import resources.ColorSet;

public class LegendItemIcon extends JPanel {

	private static final long serialVersionUID = -319067243081001323L;

	private final String name;
	
	public LegendItemIcon(String name) {

		this.name = name;
		setPreferredSize(new Dimension(50, 50));
		setBackground(ColorSet.WHITE);	

	}
		
		@Override
		public void paintComponent(Graphics g) {
			
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		
		if(name.equals("exit")){
			g.setColor(ColorSet.LIGHT_GREEN);
			g2.drawLine(0,25,50,25);
		}	
		else if(name.equals("danger")){
			g.setColor(ColorSet.RED);
			g.drawOval(5,5,40,40);

		}	
		else if(name.equals("sign")){
			g.setColor(ColorSet.SEE_GREEN);
			g2.drawLine(0,25,50,25);
		}	
		else if(name.equals("staircase")){
			g.setColor(ColorSet.LIGHT_BLUE);
			g.drawRoundRect(5,5,40,40,10,10);

		}	
		else if(name.equals("agent")){
			g.setColor(ColorSet.LIGHT_PURPLE);
			g.fillOval(15, 15, 20, 20);

		}	
			
	}

}

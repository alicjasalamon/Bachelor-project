package view.mainwindow.menubuttons;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import resources.ColorSet;

import controler.mainwindow.functionalPanels.TargetedMouseHandler;

public class MenuButtonBackgroundPanel extends JPanel {

	private static final long serialVersionUID = 7416615924647206051L;

	JButton button;

	public MenuButtonBackgroundPanel(JButton jButton) {
		
		button = jButton;
		setPreferredSize(new Dimension(240, 50));
		setBackground(Color.WHITE);
		add(button);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		Toolkit.getDefaultToolkit().addAWTEventListener(new TargetedMouseHandler(this, this.button, ColorSet.LIGHT_GRAY, ColorSet.WHITE), AWTEvent.MOUSE_EVENT_MASK);

	}

}

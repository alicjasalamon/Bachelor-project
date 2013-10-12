package view.mainwindow.functionalPanels;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import resources.ColorSet;
import controler.mainwindow.functionalPanels.TargetedMouseHandler;

public class FunctionalButtonBackgroundPanel extends JPanel {

	private static final long serialVersionUID = -3290278017196725600L;

	JButton button;

	public FunctionalButtonBackgroundPanel(JButton jButton) {

		button = jButton;
		setBackground(ColorSet.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 50));
		add(button);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		Toolkit.getDefaultToolkit().addAWTEventListener(new TargetedMouseHandler(this, this.button, ColorSet.DARK_GRAY, ColorSet.LIGHT_GRAY), AWTEvent.MOUSE_EVENT_MASK);
	}
}

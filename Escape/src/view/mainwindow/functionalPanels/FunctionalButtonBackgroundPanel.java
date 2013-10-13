package view.mainwindow.functionalPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import resources.ColorSet;
import test.ElementColection;
import test.FunctionalElementsListener;
import controler.mainwindow.functionalPanels.ClickAction;

public class FunctionalButtonBackgroundPanel extends JPanel {

	private static final long serialVersionUID = -3290278017196725600L;

	JComponent innerComponent;

	public FunctionalButtonBackgroundPanel(JComponent jButton, ElementColection elementColection){//, ElementColection elementColection) {

		innerComponent = jButton;
		setBackground(ColorSet.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 50));
		add(innerComponent);
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
		
		elementColection.addElement(this);
		elementColection.addElement(innerComponent);
		elementColection.addMouseListener(new FunctionalElementsListener(elementColection, ColorSet.DARK_GRAY, ColorSet.LIGHT_GRAY, new ClickAction()));
		
	//	Toolkit.getDefaultToolkit().addAWTEventListener(new TargetedMouseHandler(this, this.innerComponent, ColorSet.DARK_GRAY, ColorSet.LIGHT_GRAY), AWTEvent.MOUSE_EVENT_MASK);
	}
}

package view.mainwindow.functionalPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComponent;

import controler.mainwindow.functionalPanels.ClickAction;

import resources.ColorSet;
import test.ElementColection;
import test.FunctionalElementsListener;
import view.mainwindow.BasicControl;

public class FunctionalButtonBackgroundPanel extends BasicControl {

	private static final long serialVersionUID = -3290278017196725600L;

	JComponent innerComponent;

	public FunctionalButtonBackgroundPanel(JComponent jButton, ElementColection elementColection, ClickAction clickAction){//, ElementColection elementColection) {

		super(clickAction);
		
		innerComponent = jButton;
		setBackground(ColorSet.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 50));
		add(innerComponent);
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
		
		elementColection.addElement(this);
		elementColection.addElement(innerComponent);
		elementColection.addMouseListener(new FunctionalElementsListener(elementColection, ColorSet.DARK_GRAY, ColorSet.LIGHT_GRAY, clickAction));
		
	//	Toolkit.getDefaultToolkit().addAWTEventListener(new TargetedMouseHandler(this, this.innerComponent, ColorSet.DARK_GRAY, ColorSet.LIGHT_GRAY), AWTEvent.MOUSE_EVENT_MASK);
	}
}

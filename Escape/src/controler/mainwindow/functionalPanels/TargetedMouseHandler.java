package controler.mainwindow.functionalPanels;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public class TargetedMouseHandler implements AWTEventListener {

	private Component parent;
	private Component innerBound;
	private boolean hasExited = true;
	private Color in;
	private Color out;

	public TargetedMouseHandler(Component p, Component p2, Color in, Color out) {
		parent = p;
		innerBound = p2;
		this.in = in;
		this.out = out;
	}

	@Override
	public void eventDispatched(AWTEvent e) {
		if (e instanceof MouseEvent) {
			if (SwingUtilities.isDescendingFrom((Component) e.getSource(), parent)) {
				MouseEvent m = (MouseEvent) e;
				if (m.getID() == MouseEvent.MOUSE_ENTERED) {
					if (hasExited) {
						parent.setBackground(in);
						hasExited = false;
					}
				} else if (m.getID() == MouseEvent.MOUSE_EXITED) {
					Point p = SwingUtilities.convertPoint((Component) e.getSource(), m.getPoint(), innerBound);
					if (!innerBound.getBounds().contains(p)) {
						parent.setBackground(out);
						hasExited = true;
					}
				}
			}
		}
	}
}
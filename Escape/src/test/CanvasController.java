package test;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import model.backbone.agent.Agent;
import model.backbone.building.elements.Danger;
import model.backbone.building.helpers.Point;
import resources.GUIResources;
import resources.SimulationResources;

public class CanvasController implements MouseListener, MouseMotionListener, MouseWheelListener {

	@SuppressWarnings("unused")
	private Transform normToScreen;
	@SuppressWarnings("unused")
	private Transform screenToNorm;
	@SuppressWarnings("unused")
	private Transform planeToNorm;
	Transform transformTotal;
	int floor;

	public CanvasController(Transform normToScreen, Transform screenToNorm, Transform planeToNorm, Transform transformTotal, int floor) {
		super();
		this.normToScreen = normToScreen;
		this.screenToNorm = screenToNorm;
		this.planeToNorm = planeToNorm;
		this.transformTotal = transformTotal;
		this.floor = floor;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

	}

//	private Vec2d getScreenPos(MouseEvent e) {
//		java.awt.Point p = e.getPoint();
//		return new Vec2d(p.x, p.y);
//	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
	
//		Vec2d screenPos = getScreenPos(e);
//      //   update(screenPos);
//         
//         Transform planeToScreen = view.planeToScreen();
//         if (drag.hasObject()) {
//             drag.update(screenPos, planeToScreen);
//         } else {
//             Vec2d prevPlanePos = planeToScreen.invert(prevPos);
//             Vec2d planePos = getPlanePos(e);
//             Vec2d d = diff(planePos, prevPlanePos);
//             view.prepend(Transforms.t(d));
//         }
//         prevPos = screenPos;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		CanvasPanel source = (CanvasPanel) e.getSource();

		Vec2d click = new Vec2d(e.getX(), e.getY());
		click = transformTotal.invert(click);
		if (GUIResources.drawAgent) {

			SimulationResources.building.getAgents().add(new Agent(new Point((int) click.x, (int) click.y), floor));
			GUIResources.mapPanel.repaint();
			SimulationResources.building.printBuilding();
		}

		if (GUIResources.drawDanger) {
			System.out.println(source.getFloor());
			Danger newDanger = new Danger((new Point((int) (click.x), (int) (click.y))), Danger.initialRadius);
			GUIResources.lastDanger = newDanger;
			SimulationResources.building.getFloors().get(source.getFloor()).addDanger(newDanger);

			GUIResources.mapPanel.repaint();
			SimulationResources.building.printBuilding();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
/*
	public void mouseDragged(MouseEvent e) {
		Point screenPos = getScreenPos(e);
		update(screenPos);

		Transform planeToScreen = view.planeToScreen();
		if (drag.hasObject()) {
			drag.update(screenPos, planeToScreen);
		} else {
			Point prevPlanePos = planeToScreen.invert(prevPos);
			Point planePos = getPlanePos(e);
			Point d = diff(planePos, prevPlanePos);
			view.prepend(Transforms.t(d));
		}
		prevPos = screenPos;
	}

	private Point getScreenPos(MouseEvent e) {
		java.awt.Point p = e.getPoint();
		return new Point(p.x, p.y);
	}

	private Point getPlanePos(MouseEvent e) {
		Point screenPos = getScreenPos(e);
		return view.planeToScreen().invert(screenPos);
	}

	private void update(Point pos) {
		properties.put("cursor", pos);
	}*/

}
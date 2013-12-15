package controler.mainwindow.map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import model.backbone.agent.Agent;
import model.backbone.building.elements.Danger;
import model.backbone.building.helpers.Point;
import model.backbone.utils.CollisionUtils;
import resources.GUIResources;
import resources.SimulationResources;
import resources.StatisticsResources;
import view.mainwindow.simulationMap.ScrollableMapPanel;
import view.mainwindow.simulationMap.utils.Transform;
import view.mainwindow.simulationMap.utils.Transforms;
import view.mainwindow.simulationMap.utils.Vec2d;

public class ScrollableMapPanelController implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

	ScrollableMapPanel canvasPanel;
	int floor;
	Drag drag = new Drag();

	Vec2d ziom;

	public ScrollableMapPanelController(ScrollableMapPanel cp, int floor) {
		super();
		canvasPanel = cp;
		this.floor = floor;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		Vec2d planePos = getPlanePos(e);

		double f = e.getPreciseWheelRotation();
		double scale = Math.pow(0.95, f);

		Vec2d reverted = new Vec2d(-planePos.x, -planePos.y);
		Transform scaling = new Transform.Builder().t(reverted).s(scale).t(planePos).create();
		canvasPanel.setPlaneToNorm(Transforms.compose(scaling, canvasPanel.getPlaneToNorm()));
		canvasPanel.repaint();

	}

	private Vec2d getScreenPos(MouseEvent e) {
		java.awt.Point p = e.getPoint();
		return new Vec2d(p.x, p.y);
	}

	private Vec2d getPlanePos(MouseEvent e) {
		Vec2d screenPos = getScreenPos(e);
		return canvasPanel.getTransformTotal().invert(screenPos);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		Vec2d planePos = getPlanePos(e);
		drag.update(planePos);
		canvasPanel.refresh();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		ziom = getPlanePos(e);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ScrollableMapPanel source = (ScrollableMapPanel) e.getSource();

		Vec2d click = new Vec2d(e.getX(), e.getY());
		click = canvasPanel.getTransformTotal().invert(click);
		if (GUIResources.drawAgent) {
			if (CollisionUtils.canCreateAgentAtPoint(new Point((int)click.x,(int) click.y), floor)) {
				StatisticsResources.agentsStart++;
				SimulationResources.building.getAgents().add(new Agent(new Point((int) click.x, (int) click.y), floor));	
				GUIResources.setSuccesMessage("Agent added at (" + (int) click.x + ", " + (int) click.y + ")");
			} else {
				GUIResources.setErrorMessage("You cannot add agent there!");
			}
			GUIResources.mapPanel.repaint();
		}

		if (GUIResources.drawDanger) {
			if (CollisionUtils.canCreateDangerAtPoint(new Point((int) (click.x), (int) (click.y)), floor)) {
				Danger newDanger = new Danger((new Point((int) (click.x), (int) (click.y))), Danger.initialRadius);
				GUIResources.lastDanger = newDanger;
				SimulationResources.building.getFloors().get(source.getFloor()).addDanger(newDanger);	
				GUIResources.setSuccesMessage("Danger added at (" + (int) click.x + ", " + (int) click.y + ")");
			} else {
				GUIResources.setErrorMessage("You cannot add danger there!");
			}
			GUIResources.mapPanel.repaint();

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
		drag.begin(getPlanePos(arg0));

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		drag.end();
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Vec2d planePos = ziom;
		double f = e.getKeyCode() == KeyEvent.VK_LEFT ? 1 : -1;
		double scale = Math.pow(0.95, f);

		Vec2d dlaMarcina = new Vec2d(-planePos.x, -planePos.y);
		Transform scaling = new Transform.Builder().t(dlaMarcina).s(scale).t(planePos).create();
		canvasPanel.setPlaneToNorm(Transforms.compose(scaling, canvasPanel.getPlaneToNorm()));
		canvasPanel.refresh();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
    private class Drag {
        
        private Vec2d prevPos;
        private boolean draggingInProcess = false;
        
        public void begin(Vec2d startPos) {
            this.prevPos = startPos;
            draggingInProcess = false;
        }
        
        public void update(Vec2d planePos) {
            if (!draggingInProcess) {
                draggingInProcess = true;
            }
            Vec2d d = new Vec2d(planePos.x - prevPos.x, planePos.y - prevPos.y);
            canvasPanel.setPlaneToNorm(Transforms.compose(Transforms.t(d), canvasPanel.getPlaneToNorm()));
            prevPos = planePos;
        }
        
        public void end() {
                draggingInProcess = false;
        }
        
    }

}
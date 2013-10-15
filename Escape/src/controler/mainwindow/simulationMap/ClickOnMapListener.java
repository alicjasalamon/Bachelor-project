package controler.mainwindow.simulationMap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.backbone.agent.Agent;
import model.backbone.building.helpers.Point;
import resources.GUIResources;
import resources.SimulationResources;

public class ClickOnMapListener implements MouseListener {

	private int floor;
	
	public ClickOnMapListener(int floor) {
		super();
		this.floor = floor;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if(GUIResources.drawAgent)
		{
			SimulationResources.building.getAgents().add(new Agent(new Point((((double) e.getX()) / 600.0), (((double) e.getY()) / 600.0)), floor));		
			GUIResources.mapPanel.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

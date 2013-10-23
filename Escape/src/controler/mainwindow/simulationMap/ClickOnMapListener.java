package controler.mainwindow.simulationMap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.backbone.agent.Agent;
import model.backbone.building.elements.Danger;
import model.backbone.building.helpers.Point;
import resources.GUIResources;
import resources.SimulationResources;
import test.CanvasPanel;

public class ClickOnMapListener implements MouseListener {

	private int floor;
	
	public ClickOnMapListener(int floor) {
		super();
		this.floor = floor;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		CanvasPanel source = (CanvasPanel) e.getSource();
		
		if(GUIResources.drawAgent)
		{
			SimulationResources.building.getAgents().add(new Agent(new Point( e.getX() , e.getY()), floor));		
			GUIResources.mapPanel.repaint();
			SimulationResources.building.printBuilding();
		}
		
		if(GUIResources.drawDanger)
		{		
			System.out.println(source.getFloor());
			Danger newDanger = new Danger((new Point( e.getX() , e.getY())), Danger.initialRadius);
			GUIResources.lastDanger = newDanger;
			SimulationResources.building.getFloors().get(source.getFloor()).addDanger(newDanger);

			GUIResources.mapPanel.repaint();
			SimulationResources.building.printBuilding();
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

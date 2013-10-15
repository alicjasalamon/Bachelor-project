package controler.mainwindow.simulationMap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.backbone.agent.Agent;
import model.backbone.building.elements.Danger;
import model.backbone.building.helpers.Point;
import resources.GUIResources;
import resources.SimulationResources;
import view.mainwindow.simulationMap.MapPanel;

public class ClickOnMapListener implements MouseListener {

	private int floor;
	
	public ClickOnMapListener(int floor) {
		super();
		this.floor = floor;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		MapPanel source = (MapPanel) e.getSource();
		
		if(GUIResources.drawAgent)
		{
			SimulationResources.building.getAgents().add(new Agent(new Point((((double) e.getX()) / 600.0), (((double) e.getY()) / 600.0)), floor));		
			GUIResources.mapPanel.repaint();
		}
		
		if(GUIResources.drawDanger)
		{		
			System.out.println(source.getFloor());
			Danger newDanger = new Danger(new Point((((double) e.getX()) / 600.0), (((double) e.getY()) / 600.0)), 0.5);
			GUIResources.lastDanger = newDanger;
			SimulationResources.building.getFloors().get(source.getFloor()).addDanger(newDanger);
				//	new Agent(, floor));	
			System.out.println("dodaje");
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

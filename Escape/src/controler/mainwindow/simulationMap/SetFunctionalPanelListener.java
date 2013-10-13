package controler.mainwindow.simulationMap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import view.mainwindow.simualtionMap.SimulationThread;

import model.backbone.building.Building;

public class SetFunctionalPanelListener implements MouseListener {

	long clicks = 0;
	Building building;
	JPanel jPanel;
	Thread simu;
	
	public SetFunctionalPanelListener(Building b, JPanel jp) {
		building = b;
		jPanel = jp;
		simu = new SimulationThread(building, jPanel);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		clicks++;
		if(clicks==1)
			simu.start();
		else if(clicks%2==0)
		{
			simu.suspend();
		}
		else
		{
			simu.resume();
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

}
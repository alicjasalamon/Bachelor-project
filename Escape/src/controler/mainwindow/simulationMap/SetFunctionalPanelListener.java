package controler.mainwindow.simulationMap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import resources.SimulationResources;

public class SetFunctionalPanelListener implements MouseListener {

	long clicks = 0;

	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		clicks++;
		if(clicks==1)
			SimulationResources.simulationThread.start();
		else if(clicks%2==0)
		{
			SimulationResources.simulationThread.suspend();
		}
		else
		{
			SimulationResources.simulationThread.resume();
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
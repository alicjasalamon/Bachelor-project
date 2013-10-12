package view.mainwindow.simualtionMap;

import java.util.Random;

import javax.swing.JPanel;

import model.backbone.agent.Agent;
import model.backbone.building.Building;

public class SimulationThread extends Thread{
	
	Building building;
	Random rand = new Random();
	JPanel jPanel;
	
	public SimulationThread(Building b, JPanel jp)
	{
		building = b;
		jPanel = jp;
	}
	
    public void run() {

        for (;;) {
			for(Agent a : building.getAgents())
			{
				double change = rand.nextDouble()/10 - 0.05;
				a.getLocation().setX(a.getLocation().getX()+change);
				change = rand.nextDouble()/10 - 0.05;
				a.getLocation().setY(a.getLocation().getY()+change);
				jPanel.repaint();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
}

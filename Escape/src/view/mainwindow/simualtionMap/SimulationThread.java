package view.mainwindow.simualtionMap;

import java.util.Random;

import model.backbone.agent.Agent;
import resources.GUIResources;
import resources.SimulationResources;

public class SimulationThread extends Thread{
	
	Random rand = new Random();
	
	
    public void run() {

        for (;;) {
			for(Agent a : SimulationResources.building.getAgents())
			{
				double change = rand.nextDouble()/10 - 0.05;
				a.getLocation().setX(a.getLocation().getX()+change);
				change = rand.nextDouble()/10 - 0.05;
				a.getLocation().setY(a.getLocation().getY()+change);
				GUIResources.mapPanel.repaint();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
}

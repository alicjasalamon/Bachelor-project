package view.mainwindow.simulationMap;

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
//				double change = rand.nextDouble()/10 - 0.05;
				double change = (rand.nextDouble()/100)*Agent.step - 0.005*Agent.step;
				a.getLocation().setX(a.getLocation().getX()+change);
				change = (rand.nextDouble()/100)*Agent.step - 0.005*Agent.step;
				a.getLocation().setY(a.getLocation().getY()+change);
				GUIResources.mapPanel.repaint();
			}
			try {
				Thread.sleep((10 - SimulationResources.simulationSpeed)*50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
}

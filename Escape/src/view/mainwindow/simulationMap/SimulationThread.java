package view.mainwindow.simulationMap;

import java.util.Random;

import model.backbone.agent.Agent;
import resources.GUIResources;
import resources.SimulationResources;

public class SimulationThread extends Thread{
	
	Random rand = new Random(System.currentTimeMillis());
	
	
    public void run() {

        for (;;) {
			for(Agent a : SimulationResources.building.getAgents())
			{
				double x, y, angle;
				angle = rand.nextDouble() * 6.28;
				
				x = Math.sin(angle) * Agent.step;
				y = Math.cos(angle) * Agent.step;
				
				a.getLocation().setX(a.getLocation().getX() + x);
				a.getLocation().setY(a.getLocation().getY() + y);
				
				GUIResources.mapPanel.repaint();
			}
			try {
				Thread.sleep((100 - SimulationResources.simulationSpeed)*4 + 10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
}

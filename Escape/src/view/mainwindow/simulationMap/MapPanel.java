package view.mainwindow.simulationMap;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.backbone.agent.Agent;
import model.backbone.building.elements.Danger;
import model.backbone.building.elements.Exit;
import model.backbone.building.elements.Sign;
import model.backbone.building.elements.Staircase;
import model.backbone.building.elements.Wall;
import resources.ColorSet;
import resources.SimulationResources;
import view.mainwindow.legend.LegendPanel;
import controler.mainwindow.simulationMap.ClickOnMapListener;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = -2686640147259984678L;
	private double resize;
	private int floor;
	
	public MapPanel(int floor)
	{

		resize = 600;
		this.floor = floor;
		setBackground(Color.white);
		setPreferredSize(new Dimension(1020, 520));
		
		setLayout(new BorderLayout());
		add(new LegendPanel(), BorderLayout.SOUTH);
		
		addMouseListener(new ClickOnMapListener(floor));
	}


	public int getFloor() {
		return floor;
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		//////////////////////////////////////////////////////////////////////////////
		//								WALLS										//
		//////////////////////////////////////////////////////////////////////////////
		g2.setColor(ColorSet.DARK_GRAY);
		g2.setStroke(new BasicStroke(3));
		
		for(Wall w : SimulationResources.building.getFloors().get(floor).getWalls())
		{
			g2.drawLine(
					(int)(w.getBegin().getX() * resize), 
					(int)(w.getBegin().getY() * resize), 
					(int)(w.getEnd().getX() * resize),
					(int)(w.getEnd().getY() * resize));
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								EXITS										//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(ColorSet.LIGHT_GREEN);
		for(Exit e : SimulationResources.building.getFloors().get(floor).getExits())
		{
			g.drawLine(
					(int)(e.getBegin().getX() * resize), 
					(int)(e.getBegin().getY() * resize), 
					(int)(e.getEnd().getX() * resize),
					(int)(e.getEnd().getY() * resize));
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								DANGERS										//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(ColorSet.RED);
		for(Danger d : SimulationResources.building.getFloors().get(floor).getDangers())
		{
			g.drawOval(
					(int)((d.getCenter().getX() - 0.5 * d.getRadius()) * resize), 
					(int)((d.getCenter().getY() - 0.5 * d.getRadius()) * resize), 
					(int)(d.getRadius() * resize),
					(int)(d.getRadius() * resize));
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								SIGNS										//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(ColorSet.SEE_GREEN);
		for(Sign s : SimulationResources.building.getFloors().get(floor).getSings())
		{
			g.drawLine(
					(int)(s.getBegin().getX() * resize), 
					(int)(s.getBegin().getY() * resize), 
					(int)(s.getEnd().getX() * resize),
					(int)(s.getEnd().getY() * resize));
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								STAIRCASES									//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(ColorSet.LIGHT_BLUE);
		for(Staircase s : SimulationResources.building.getStairCases())
		{
			g.drawRoundRect(
					(int)(s.getPoint1().getX() * resize), 
					(int)(s.getPoint1().getY() * resize), 
					(int)(s.getPoint2().getX() * resize),
					(int)(s.getPoint2().getY() * resize),
					20,20);
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								AGENTS										//
		//////////////////////////////////////////////////////////////////////////////
		
		
		g.setColor(ColorSet.LIGHT_PURPLE);
		for(Agent a : SimulationResources.building.getAgents())
		{
			if(a.getFloor()==floor)
			{
				g.fillOval(
						(int)((a.getLocation().getX() - 0.5 * Agent.getSize()) * resize), 
						(int)((a.getLocation().getY() - 0.5 * Agent.getSize()) * resize), 
						(int)(Agent.size * resize),
						(int)(Agent.size * resize));
				
			}
		}
		
	}
}

package view.mainwindow.simualtionMap;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.backbone.agent.Agent;
import model.backbone.building.Building;
import model.backbone.building.elements.Danger;
import model.backbone.building.elements.Exit;
import model.backbone.building.elements.Sign;
import model.backbone.building.elements.Staircase;
import model.backbone.building.elements.Wall;
import resources.ColorSet;
import view.mainwindow.legend.LegendPanel;
import controler.mainwindow.simulationMap.SetFunctionalPanelListener;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = -2686640147259984678L;
	Building building;
	double resize;
	double shift = 10;
	
	public MapPanel(Building building)
	{

		resize = 600;
		this.building = building;
		setBackground(Color.white);
		addMouseListener(new SetFunctionalPanelListener(building, this));
		setPreferredSize(new Dimension(1020, 520));
		
		setLayout(new BorderLayout());
		add(new LegendPanel(), BorderLayout.SOUTH);
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
		
		for(Wall w : building.getFloors().get(0).getWalls())
		{
			g2.drawLine(
					(int)(w.getBegin().getX() * resize + shift), 
					(int)(w.getBegin().getY() * resize + shift), 
					(int)(w.getEnd().getX() * resize + shift),
					(int)(w.getEnd().getY() * resize + shift));
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								EXITS										//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(ColorSet.LIGHT_GREEN);
		for(Exit e : building.getFloors().get(0).getExits())
		{
			g.drawLine(
					(int)(e.getBegin().getX() * resize + shift), 
					(int)(e.getBegin().getY() * resize + shift), 
					(int)(e.getEnd().getX() * resize + shift),
					(int)(e.getEnd().getY() * resize + shift));
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								DANGERS										//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(new Color(225, 60, 64));
		for(Danger d : building.getFloors().get(0).getDangers())
		{
			g.drawOval(
					(int)(d.getCenter().getX() * resize + shift), 
					(int)(d.getCenter().getY() * resize + shift), 
					(int)(d.getRadius() * resize),
					(int)(d.getRadius() * resize));
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								SIGNS										//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(new Color(23,178,170));
		for(Sign s : building.getFloors().get(0).getSings())
		{
			g.drawLine(
					(int)(s.getBegin().getX() * resize + shift), 
					(int)(s.getBegin().getY() * resize + shift), 
					(int)(s.getEnd().getX() * resize + shift),
					(int)(s.getEnd().getY() * resize + shift));
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								STAIRCASES									//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(new Color(173, 216, 230));
		for(Staircase s : building.getStairCases())
		{
			g.drawRoundRect(
					(int)(s.getPoint1().getX() * resize + shift), 
					(int)(s.getPoint1().getY() * resize + shift), 
					(int)(s.getPoint2().getX() * resize + shift),
					(int)(s.getPoint2().getY() * resize + shift),
					20,20);
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								AGENTS										//
		//////////////////////////////////////////////////////////////////////////////
		
		
		g.setColor(new Color(221, 160, 221));
		for(Agent a : building.getAgents())
		{
			g.fillOval(
					(int)(a.getLocation().getX() * resize + shift), 
					(int)(a.getLocation().getY() * resize + shift), 
					(int)(Agent.getSize() + shift),
					(int)(Agent.getSize() + shift));
		}
		
	}
}

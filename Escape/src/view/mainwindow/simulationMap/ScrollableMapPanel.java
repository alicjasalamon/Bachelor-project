package view.mainwindow.simulationMap;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

import controler.mainwindow.map.ScrollableMapPanelController;

import model.backbone.agent.Agent;
import model.backbone.building.elements.Danger;
import model.backbone.building.elements.Exit;
import model.backbone.building.elements.Sign;
import model.backbone.building.elements.Staircase;
import model.backbone.building.elements.Wall;
import model.backbone.building.helpers.Point;
import resources.ColorSet;
import resources.GUIResources;
import resources.SimulationResources;
import view.mainwindow.simulationMap.utils.Transform;
import view.mainwindow.simulationMap.utils.Transforms;
import view.mainwindow.simulationMap.utils.Vec2d;

public class ScrollableMapPanel extends JPanel {

	private static final long serialVersionUID = 7376278600133280828L;

	private Transform normToScreen;
    private Transform screenToNorm;
	private Transform planeToNorm;
	private Transform transformTotal;
	private int floor;

	//i'm sorry
	int panelWidth = 993; 
    int panelHeight = 670 ;
    double aspectRatio = (double) panelWidth / panelHeight;
	
	
	public Transform getPlaneToNorm() {
		return planeToNorm;
	}

	public void setPlaneToNorm(Transform planeToNorm) {
		this.planeToNorm = planeToNorm;
	}

	public Transform getNormToScreen() {
		return normToScreen;
	}

	public void setNormToScreen(Transform normToScreen) {
		this.normToScreen = normToScreen;
	}

	public Transform getScreenToNorm() {
		return screenToNorm;
	}

	public void setScreenToNorm(Transform screenToNorm) {
		this.screenToNorm = screenToNorm;
	}

	public Transform getTransformTotal() {
		return transformTotal;
	}

	public void setTransformTotal(Transform transformTotal) {
		this.transformTotal = transformTotal;
	}

	/**
     * Creates new canvas panel.
     */
    public ScrollableMapPanel(int floor) {
		 
        setBackground(ColorSet.WHITE);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.floor=floor;
        
        int x, y;
        x = SimulationResources.building.getResolutionX();
   	    y = SimulationResources.building.getResolutionY();
       
        double max = Math.max(x / aspectRatio, y);
        double s = 1.0 / (max / 2);
        double sx = s/aspectRatio;
        double sy = s;
        
        planeToNorm = new Transform.Builder().s(sx, sy).t(-1.0, -1.0).create();
        
        addComponentListener(new ComponentAdapter() {
            
            @Override
            public void componentShown(ComponentEvent e) {
                
                System.out.println(getHeight() + getWidth());
                requestFocusInWindow();
                recomputeTransform();
            }
            
            @Override
            public void componentResized(ComponentEvent e) {
                recomputeTransform();
            }

        });
        ScrollableMapPanelController cc = new ScrollableMapPanelController(this, floor);
		addMouseListener(cc);
		addKeyListener(cc);
		addMouseMotionListener(cc);
		addMouseWheelListener(cc);
    }


    public int getFloor() {
		return floor;
	}

    /**
     * Causes canvas repaint.
     */
    public void refresh() {
        repaint();
    }

    private void recomputeTransform() {
        
        Transform.Builder builder = new Transform.Builder()
                .flipY()
                .t(1, 1)
                .s(panelWidth / 2.0, panelHeight / 2.0);

        normToScreen = builder.create();
        screenToNorm = builder.invert().create();
    	transformTotal = Transforms.compose(planeToNorm, normToScreen);
    }

    public Transform normToScreen() {
        return normToScreen;
    }
    
    public Transform screenToNorm() {
        return screenToNorm;
    }
    
    
    /**
     * Transforms the coordinates in the normalized space to the screen
     * coordinates.
     * 
     * @param p
     *            ScreenVec2d in virtual coordinates
     * @return Vec2d in screen coordinates
     */
    public Vec2d toScreen(Vec2d p) {
        return normToScreen.apply(p);
    }

    /**
     * Transforms screen coordinates to the coordinates in the normalized space.
     * 
     * @param p
     *            ScreenVec2d in screen coordinates
     * @return ScreenVec2d in virtual coordinates
     */
    public Vec2d toNorm(Vec2d p) {
        return screenToNorm.apply(p);
    }

    private Vec2d transformModelPoint(Point p){
		return transformTotal.apply(new Vec2d(p.x, p.y));
    }
    
    @Override
    protected final void paintComponent(Graphics g) {
    	
    	try{
        super.paintComponent(g);
        recomputeTransform();

        setBackground(ColorSet.WHITE);
        
        super.paintComponent(g);
    	
    	Graphics2D g2 = (Graphics2D) g;
    	
				
		//////////////////////////////////////////////////////////////////////////////
		//								WALLS										//
		//////////////////////////////////////////////////////////////////////////////
		g2.setColor(ColorSet.DARK_GRAY);
		g2.setStroke(new BasicStroke(3));
		
		for(Wall w : SimulationResources.building.getFloors().get(floor).getWalls())
		{
			Vec2d a, b;
			a = transformModelPoint(w.getBegin());
			b = transformModelPoint(w.getEnd());
			g2.drawLine(
					(int)(a.x), 
					(int)(a.y), 
					(int)(b.x),
					(int)(b.y));
		}
		
		
		//////////////////////////////////////////////////////////////////////////////
		//								EXITS										//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(ColorSet.LIGHT_GREEN);
		for(Exit e : SimulationResources.building.getFloors().get(floor).getExits())
		{
			Vec2d a, b;
			a = transformModelPoint(e.getBegin());
			b = transformModelPoint(e.getEnd());
			g2.drawLine(
					(int)(a.x), 
					(int)(a.y), 
					(int)(b.x),
					(int)(b.y));
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								DANGERS										//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(ColorSet.RED);
		for(Danger d : SimulationResources.building.getFloors().get(floor).getDangers())
		{
			Vec2d a;
			a = transformModelPoint(d.getCenter());
			int r = d.getRadius();
			Vec2d rd = transformTotal.applyToDirection(new Vec2d(r, 0));
			double rlol = rd.x;
			
			g.drawOval(
					(int)(a.x - rlol/2), 
					(int)(a.y - rlol/2), 
					(int)(rlol),
					(int)(rlol));
					
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								SIGNS										//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(ColorSet.SEE_GREEN);
		for(Sign s : SimulationResources.building.getFloors().get(floor).getSigns())
		{
			Vec2d a, b;
			a = transformModelPoint(s.getBegin());
			b = transformModelPoint(s.getEnd());
			g2.drawLine(
					(int)(a.x), 
					(int)(a.y), 
					(int)(b.x),
					(int)(b.y));
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								STAIRCASES									//
		//////////////////////////////////////////////////////////////////////////////
		g.setColor(ColorSet.LIGHT_BLUE);
		for(Staircase s : SimulationResources.building.getStairCases())
		{
			Vec2d a;
			a = transformModelPoint(s.getPoint1());
			int h = s.getHeight();
			int l = s.getLenght();
			
			Vec2d rh = transformTotal.applyToDirection(new Vec2d(h, 0));
			Vec2d rd = transformTotal.applyToDirection(new Vec2d(l, 0));
		

			g.drawRoundRect(
					(int)(a.x - rh.x/2), 
					(int)(a.y - rd.x/2), 
					(int)rh.x,
					(int)rd.x,
					20,20);
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//								AGENTS										//
		//////////////////////////////////////////////////////////////////////////////
		
		
		g.setColor(ColorSet.LIGHT_PURPLE);
		for(Agent a : SimulationResources.building.getAgents())
		{
			if(a.getFloor()==floor && !a.isEscaped())
			{
				Vec2d a1;
				a1 = transformModelPoint(a.getLocation());
				Vec2d rd = transformTotal.applyToDirection(new Vec2d(Agent.size, 0));
				
				g.fillOval(
						(int)(a1.x - rd.x/2), 
						(int)(a1.y - rd.x/2), 
						(int)rd.x,
						(int)rd.x);
				
			}
		}
    		
    	}catch(Exception e){
    		GUIResources.setErrorMessage("Map cannot be processed");
    	}
    }
    
    }
    
    

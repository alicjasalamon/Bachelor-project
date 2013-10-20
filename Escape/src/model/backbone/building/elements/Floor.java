package model.backbone.building.elements;

import java.util.ArrayList;
import java.util.List;

public class Floor {

	private List<Wall> walls = new ArrayList<Wall>();
	private List<Danger> dangers = new ArrayList<Danger>();
	private List<Exit> exits = new ArrayList<Exit>();
	private List<Sign> signs = new ArrayList<Sign>();

	private int sizeX;
	private int sizeY;
	
	public void printFloor() {
		System.out.println("WALLS:");

		for (Wall w : walls) {
			w.printWall();
		}

		for (Danger d : dangers) {
			d.printDanger();
		}
		
		for (Exit e : exits) {
			e.printExit();
		}
		
		for(Sign s : signs) {
			s.printSign();
		}

	}
	
	public void addWall(Wall wall){
		walls.add(wall);
	}
	
	public void addDanger(Danger danger)
	{
		dangers.add(danger);
	}
	
	public void addExit(Exit exit)
	{
		exits.add(exit);
	}
	
	public void addSign(Sign sign)
	{
		signs.add(sign);
	}

	public List<Wall> getWalls() {
		return walls;
	}

	public List<Danger> getDangers() {
		return dangers;
	}

	public List<Exit> getExits() {
		return exits;
	}

	public List<Sign> getSigns() {
		return signs;
	}
	
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}


}

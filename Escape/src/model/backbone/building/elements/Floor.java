package model.backbone.building.elements;

import java.util.ArrayList;
import java.util.List;

public class Floor {

	private List<Wall> walls = new ArrayList<Wall>();
	private List<Danger> dangers = new ArrayList<Danger>();
	private List<Exit> exits = new ArrayList<Exit>();
	private List<Sign> sings = new ArrayList<Sign>();

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
		
		for(Sign s : sings) {
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
		sings.add(sign);
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

	public List<Sign> getSings() {
		return sings;
	}

}

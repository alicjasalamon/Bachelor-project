package model.backbone.building;

import java.util.ArrayList;
import java.util.List;

import model.backbone.agent.Agent;
import model.backbone.building.elements.Floor;
import model.backbone.building.elements.Staircase;

public class Building {

	private List<Floor> floors = new ArrayList<Floor>();
	private List<Staircase> stairCases = new ArrayList<Staircase>();
	private List<Agent> agents = new ArrayList<Agent>();
	private int resolutionX;
	private int resolutionY;

	public void printBuilding() {

		System.out.println("----------BUILDING:");

		System.out.println("-----FLOORS:");
		for (Floor f : floors) {
			System.out.println("===================================FLOOR");
			f.printFloor();
		}

		System.out.println("-----STAIRCASES:");
		for (Staircase s : stairCases) {
			s.printStaircase();
		}

		System.out.println("-----AGENTS:");
		for (Agent a : agents) {
			a.printAgent();
		}

	}
	

	public List<Floor> getFloors() {
		return floors;
	}

	public List<Staircase> getStairCases() {
		return stairCases;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	
	public void addFloor(Floor floor) {
		floors.add(floor);
	}

	public void addStaircase(Staircase staircase) {
		stairCases.add(staircase);
	}


	public int getResolutionX() {
		return resolutionX;
	}


	public void setResolutionX(int resolutionX) {
		this.resolutionX = resolutionX;
	}


	public int getResolutionY() {
		return resolutionY;
	}


	public void setResolutionY(int resolutionY) {
		this.resolutionY = resolutionY;
	}
	
	public void resetBuilding() {
		this.agents.clear();
		for (Floor f : floors) {
			f.getDangers().clear();
		}
	}

	
}

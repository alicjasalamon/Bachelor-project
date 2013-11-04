package model.backbone.building.helpers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.backbone.building.Building;
import model.backbone.building.elements.Danger;
import model.backbone.building.elements.Exit;
import model.backbone.building.elements.Floor;
import model.backbone.building.elements.Sign;
import model.backbone.building.elements.Staircase;
import model.backbone.building.elements.Wall;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BuildingExplorer {

	private File fXmlFile;
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document doc;

	public BuildingExplorer() {

		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	public Building parseBuilding(String fileName) {
		
		Building building = new Building();
		
		try {
			fXmlFile = new File(fileName);
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			//////////////////////////////////////////////////////////////////////////////
			//								FLOORS										//
			//////////////////////////////////////////////////////////////////////////////
			NodeList floorsList = doc.getElementsByTagName("floor");

			for (int f = 0; f < floorsList.getLength(); f++) {

				Floor floor = new Floor();
				Node floorNode = floorsList.item(f);

				if (floorNode.getNodeType() == Node.ELEMENT_NODE) {

					NodeList floorElementsList = floorNode.getChildNodes();
					for (int fe = 0; fe < floorElementsList.getLength(); fe++) {

						Node floorElementNode = floorElementsList.item(fe);

						if (floorElementNode.getNodeType() == Node.ELEMENT_NODE) {

							//////////////////////////////////////////////////////////////////////////////
							//								WALLS										//
							//////////////////////////////////////////////////////////////////////////////
							if (floorElementNode.getNodeName().equals("walls")) {
							
								NodeList wallsList = floorElementNode.getChildNodes();
								
								for (int w = 0; w < wallsList.getLength(); w++) { 
								
									Node wallNode = wallsList.item(w);
									if (wallNode.getNodeType() == Node.ELEMENT_NODE) {
									
										NamedNodeMap nodeMap = wallNode.getAttributes();
										Wall wall = new Wall(
										Integer.parseInt(nodeMap.getNamedItem("x1").getNodeValue()),
										Integer.parseInt(nodeMap.getNamedItem("y1").getNodeValue()),
										Integer.parseInt(nodeMap.getNamedItem("x2").getNodeValue()),
										Integer.parseInt(nodeMap.getNamedItem("y2").getNodeValue()));
										
										floor.addWall(wall);
									}
								
								}
							
							}

							//////////////////////////////////////////////////////////////////////////////
							//								RESOLUTION									//
							//////////////////////////////////////////////////////////////////////////////
							if (floorElementNode.getNodeName().equals("resolution")) {

								if (floorElementNode.getNodeType() == Node.ELEMENT_NODE) {
									
									NamedNodeMap nodeMap = floorElementNode.getAttributes();
									floor.setSizeX(Integer.parseInt(nodeMap.getNamedItem("x").getNodeValue()));
									floor.setSizeY(Integer.parseInt(nodeMap.getNamedItem("y").getNodeValue()));
								}
									
								

							}
							
							//////////////////////////////////////////////////////////////////////////////
							//								SIGNS										//
							//////////////////////////////////////////////////////////////////////////////
							if (floorElementNode.getNodeName().equals("signs")) {
								

								NodeList signsList = floorElementNode.getChildNodes();
								for (int w = 0; w < signsList.getLength(); w++) {

									Node signNode = signsList.item(w);

									if (signNode.getNodeType() == Node.ELEMENT_NODE) {

										NamedNodeMap nodeMap = signNode.getAttributes();
										Sign sign = new Sign(
												Integer.parseInt(nodeMap.getNamedItem("x1").getNodeValue()),
												Integer.parseInt(nodeMap.getNamedItem("y1").getNodeValue()),
												Integer.parseInt(nodeMap.getNamedItem("x2").getNodeValue()),
												Integer.parseInt(nodeMap.getNamedItem("y2").getNodeValue()),
												Integer.parseInt(nodeMap.getNamedItem("targetx").getNodeValue()),
												Integer.parseInt(nodeMap.getNamedItem("targety").getNodeValue()));

										floor.addSign(sign);
										}
									
								}

							}
							
							//////////////////////////////////////////////////////////////////////////////
							//								DANGERS										//
							//////////////////////////////////////////////////////////////////////////////
							if (floorElementNode.getNodeName().equals("dangers")) {
								
								NodeList dangersList = floorElementNode.getChildNodes();

								for (int w = 0; w < dangersList.getLength(); w++) {

									Node dangerNode = dangersList.item(w);
									
									if (dangerNode.getNodeType() == Node.ELEMENT_NODE) {
										
										NamedNodeMap nodeMap = dangerNode.getAttributes();
										Danger danger = new Danger(
												Integer.parseInt(nodeMap.getNamedItem("x").getNodeValue()),
												Integer.parseInt(nodeMap.getNamedItem("y").getNodeValue()),
												Integer.parseInt(nodeMap.getNamedItem("r").getNodeValue()));

										floor.addDanger(danger);
									}
									
								}

							}
							
							//////////////////////////////////////////////////////////////////////////////
							//								EXITS										//
							//////////////////////////////////////////////////////////////////////////////
							if (floorElementNode.getNodeName().equals("exits")) {

								NodeList exitsList = floorElementNode.getChildNodes();

								for (int w = 0; w < exitsList.getLength(); w++) {

									Node exitNode = exitsList.item(w);
									if (exitNode.getNodeType() == Node.ELEMENT_NODE) {
										
										NamedNodeMap nodeMap = exitNode.getAttributes();
										Exit exit = new Exit(
												Integer.parseInt(nodeMap.getNamedItem("x1").getNodeValue()),
												Integer.parseInt(nodeMap.getNamedItem("y1").getNodeValue()),
												Integer.parseInt(nodeMap.getNamedItem("x2").getNodeValue()),
												Integer.parseInt(nodeMap.getNamedItem("y2").getNodeValue()));

										floor.addExit(exit);

									}
								}

							}
							
						}
						
					}
				}
				building.addFloor(floor);
			}

			//////////////////////////////////////////////////////////////////////////////
			//								STAIRCASES									//
			//////////////////////////////////////////////////////////////////////////////

			NodeList staircasesList = doc.getElementsByTagName("staircase");
			for (int s = 0; s < staircasesList.getLength(); s++) {

				
				Node staircaseNode = staircasesList.item(s);
				if (staircaseNode.getNodeType() == Node.ELEMENT_NODE) {
					
					NamedNodeMap nodeMap = staircaseNode.getAttributes();
					Staircase staircase = new Staircase(
							Integer.parseInt(nodeMap.getNamedItem("x1").getNodeValue()),
							Integer.parseInt(nodeMap.getNamedItem("y1").getNodeValue()),
							Integer.parseInt(nodeMap.getNamedItem("lenght").getNodeValue()),
							Integer.parseInt(nodeMap.getNamedItem("height").getNodeValue()));

					building.addStaircase(staircase);
				}
			}

		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return building;
	}

	public void saveBuilding(Building building, String fileName) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<bulding>\n");
		//////////////////////////////////////////////////////////////////////////////
		//								FLOORS										//
		//////////////////////////////////////////////////////////////////////////////
		
		sb.append("\t<floors>\n");
		for(Floor floor : building.getFloors())
		{
			sb.append("\t\t<floor>\n");
				
			//////////////////////////////////////////////////////////////////////////////
			//								WALLS										//
			//////////////////////////////////////////////////////////////////////////////

			sb.append("\t\t\t<walls>\n");
			for(Wall wall : floor.getWalls())
			{
				sb.append("\t\t\t\t<wall "+ wall.forXMLRepresentation() + "/>\n");			
			}
			sb.append("\t\t\t</walls>\n");
	
			//////////////////////////////////////////////////////////////////////////////
			//								SIGNS										//
			//////////////////////////////////////////////////////////////////////////////
		
			sb.append("\t\t\t<signs>\n");
			for(Sign sign : floor.getSigns())
			{
				sb.append("\t\t\t\t<sign "+ sign.forXMLRepresentation() + "/>\n");				
			}
			sb.append("\t\t\t</signs>\n");
									
			//////////////////////////////////////////////////////////////////////////////
			//								DANGERS										//
			//////////////////////////////////////////////////////////////////////////////
		
			sb.append("\t\t\t<dangers>\n");
			for(Danger danger : floor.getDangers())
			{
				sb.append("\t\t\t\t<danger "+ danger.forXMLRepresentation() + "/>\n");			
			}
			sb.append("\t\t\t</dangers>\n");				
			//////////////////////////////////////////////////////////////////////////////
			//								EXITS										//
			//////////////////////////////////////////////////////////////////////////////
			sb.append("\t\t\t<exits>\n");
			for(Exit exit : floor.getExits())
			{
				sb.append("\t\t\t\t<exit "+ exit.forXMLRepresentation() + "/>\n");			
			}
			sb.append("\t\t\t</exits>\n");	
		
			
			sb.append("\t\t</floor>\n");
		}
		sb.append("\t</floors>");
		
			//////////////////////////////////////////////////////////////////////////////
			//								STAIRCASES									//
			//////////////////////////////////////////////////////////////////////////////


			sb.append("</bulding>");
			String result =  sb.toString();
			System.out.println(result);
		}

}

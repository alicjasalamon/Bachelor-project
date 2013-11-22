package model.backbone.building.helpers;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.backbone.building.Building;
import model.backbone.building.elements.Exit;
import model.backbone.building.elements.Floor;
import model.backbone.building.elements.Sign;
import model.backbone.building.elements.Staircase;
import model.backbone.building.elements.Wall;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import resources.GUIResources;

public class BuildingExplorer {

	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document doc;

	public BuildingExplorer() {

		try {
			
			dbFactory = DocumentBuilderFactory.newInstance();
			dbFactory.setValidating(false);
			dbFactory.setNamespaceAware(true);
			dBuilder = dbFactory.newDocumentBuilder();
			
			dBuilder.setErrorHandler(new ErrorHandler() {
				
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					GUIResources.setErrorMessage("Error while loading this file");
				}
				
				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					GUIResources.setErrorMessage("Error while loading this file");
					
				}
				
				@Override
				public void error(SAXParseException exception) throws SAXException {
					GUIResources.setErrorMessage("Error while loading this file");
					
				}
			});

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	public Building parseBuilding(String fileName) {
		
		Building building = new Building();
		
		try {
			doc = dBuilder.parse(new InputSource(fileName));
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
							if (floorElementNode.getNodeName().equals("wall")) {
							
								NamedNodeMap nodeMap = floorElementNode.getAttributes();
								Wall wall = new Wall(
									Integer.parseInt(nodeMap.getNamedItem("x1").getNodeValue()),
									Integer.parseInt(nodeMap.getNamedItem("y1").getNodeValue()),
									Integer.parseInt(nodeMap.getNamedItem("x2").getNodeValue()),
									Integer.parseInt(nodeMap.getNamedItem("y2").getNodeValue()));
								
								floor.addWall(wall);		
							}

							//////////////////////////////////////////////////////////////////////////////
							//								SIGNS										//
							//////////////////////////////////////////////////////////////////////////////
							if (floorElementNode.getNodeName().equals("signs")) {

								NamedNodeMap nodeMap = floorElementNode.getAttributes();
								Sign sign = new Sign(
										Integer.parseInt(nodeMap.getNamedItem("x1").getNodeValue()),
										Integer.parseInt(nodeMap.getNamedItem("y1").getNodeValue()),
										Integer.parseInt(nodeMap.getNamedItem("x2").getNodeValue()),
										Integer.parseInt(nodeMap.getNamedItem("y2").getNodeValue()),
										Integer.parseInt(nodeMap.getNamedItem("targetx").getNodeValue()),
										Integer.parseInt(nodeMap.getNamedItem("targety").getNodeValue()));

								floor.addSign(sign);
							
							}
							
							//////////////////////////////////////////////////////////////////////////////
							//								EXITS										//
							//////////////////////////////////////////////////////////////////////////////
				
							if (floorElementNode.getNodeName().equals("exit")) {
								
								NamedNodeMap nodeMap = floorElementNode.getAttributes();
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
							Integer.parseInt(nodeMap.getNamedItem("x").getNodeValue()),
							Integer.parseInt(nodeMap.getNamedItem("y").getNodeValue()),
							Integer.parseInt(nodeMap.getNamedItem("width").getNodeValue()),
							Integer.parseInt(nodeMap.getNamedItem("height").getNodeValue()));

					building.addStaircase(staircase);
				}
			}
			
			//////////////////////////////////////////////////////////////////////////////
			//								RESOLUTION									//
			//////////////////////////////////////////////////////////////////////////////
			
			Node resolutionNode = doc.getElementsByTagName("resolution").item(0);
			building.setResolutionX(Integer.parseInt(resolutionNode.getAttributes().getNamedItem("x").getNodeValue()));
			building.setResolutionY(Integer.parseInt(resolutionNode.getAttributes().getNamedItem("y").getNodeValue()));
			
		} catch (SAXException e) {
			GUIResources.setErrorMessage("Error while processing map file");
		//	e.printStackTrace();
		} catch (IOException e) {
			GUIResources.setErrorMessage("Error while loading this file");
		//	e.printStackTrace();
		} catch (Exception e) {
			GUIResources.setErrorMessage("Error while loading this file");
		//	e.printStackTrace();
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

			for(Wall wall : floor.getWalls())
			{
				sb.append("\t\t\t\t<wall "+ wall.forXMLRepresentation() + "/>\n");			
			}
	
			//////////////////////////////////////////////////////////////////////////////
			//								SIGNS										//
			//////////////////////////////////////////////////////////////////////////////

			for(Sign sign : floor.getSigns())
			{
				sb.append("\t\t\t\t<sign "+ sign.forXMLRepresentation() + "/>\n");				
			}
												
			//////////////////////////////////////////////////////////////////////////////
			//								EXITS										//
			//////////////////////////////////////////////////////////////////////////////
			for(Exit exit : floor.getExits())
			{
				sb.append("\t\t\t\t<exit "+ exit.forXMLRepresentation() + "/>\n");			
			}
			
			sb.append("\t\t</floor>\n");
		}
		sb.append("\t</floors>");
		
			//////////////////////////////////////////////////////////////////////////////
			//								STAIRCASES									//
			//////////////////////////////////////////////////////////////////////////////
			for(Staircase staircase : building.getStairCases())
			{
				sb.append("\t\t\t\t<exit "+ staircase.forXMLRepresentation() + "/>\n");			
			}

			sb.append("</bulding>");
			String result =  sb.toString();
			System.out.println(result);
		}

}
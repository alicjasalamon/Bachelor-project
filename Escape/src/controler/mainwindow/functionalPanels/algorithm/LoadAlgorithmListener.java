package controler.mainwindow.functionalPanels.algorithm;

import java.awt.FileDialog;

import resources.GUIResources;
import controler.mainwindow.functionalPanels.ClickAction;

public class LoadAlgorithmListener implements ClickAction {

	@Override
	public void act() {
		// TODO Auto-generated method stub
		FileDialog fd = new FileDialog(GUIResources.mainFrame, "Save your algorithm", FileDialog.SAVE);
		fd.setDirectory("algorithms");
		fd.setVisible(true);

		//	String filename = fd.getFile();
		
		/*
		 * TODO: tutaj dodac algorytm do CheckBoxów
		 */
	}


}

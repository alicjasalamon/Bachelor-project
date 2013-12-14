package view.mainwindow.functionalPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JRadioButton;

import resources.SimulationResources;

public class RadioButtonAlgorithmListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton source = (JRadioButton) e.getSource();
		System.out.println(source.getText());
		//XXX co tu podac?
		SimulationResources.simulator.setAlgorithm(new File("algorithms\\" + source.getText() + ".java"));
		
	}

}

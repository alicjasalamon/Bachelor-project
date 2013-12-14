package controler.mainwindow.functionalPanels.algorithm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JRadioButton;

import resources.GUIResources;
import resources.SimulationResources;
import resources.SimulationState;

public class RadioButtonAlgorithmListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if (SimulationResources.simulationState == SimulationState.Stopped) {

			JRadioButton source = (JRadioButton) e.getSource();
			System.out.println(source.getText());
			//XXX co tu podac?
			SimulationResources.simulator.setAlgorithm(new File("algorithms\\" + source.getText() + ".java"));
			GUIResources.setSuccesMessage("Algorithm " + source.getText() + " selected");
		} else {
			GUIResources.setErrorMessage("You cannot change algorithm while simulation is running");
		}

	}

}

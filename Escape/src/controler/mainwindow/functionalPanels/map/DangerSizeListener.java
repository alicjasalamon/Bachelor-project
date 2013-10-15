package controler.mainwindow.functionalPanels.map;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import resources.GUIResources;

public class DangerSizeListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			GUIResources.lastDanger.setRadius(((double)source.getValue()+1.0)/10.0);
			System.out.println("new size " + ((double)source.getValue()+1.0)/10.0 );
			GUIResources.mapPanel.repaint();

		}

	}

}

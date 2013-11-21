package view.infos;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import resources.FontSet;

public class AboutFrame extends InfoFrame {

	private static final long serialVersionUID = -338909528663988811L;
	
	public AboutFrame() {
		
		setTitle("About");
		JPanel pnl = new JPanel(new GridLayout(14, 1));
		pnl.add(createLabel("Project:\n", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("System for modeling and simulation of building evacuation process\n\n", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));
		
		pnl.add(createLabel("Authors:\n", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("Alicja Salamon, Dawid Aksamit\n\n", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));
		
		pnl.add(createLabel("Supervisor:\n", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("Rafa³ Dre¿ewski PhD\n\n", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));
		
		pnl.add(createLabel("AGH University of Science and Technology\n", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("Department: Computer Science, Electronics and Telecommunications\n", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("Faculty: Computer Science\n\n", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("Academic year: 2013/2014\n", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));
		
		JOptionPane.showMessageDialog(null, pnl);

	}

}

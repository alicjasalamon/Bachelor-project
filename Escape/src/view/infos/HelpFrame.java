package view.infos;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import resources.FontSet;

public class HelpFrame extends InfoFrame {

	private static final long serialVersionUID = -338909528663988811L;

	private URI uri;

	public HelpFrame() {

		setTitle("Help");
		try {
			uri = new URI("http://java.sun.com");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel pnl = new JPanel(new GridLayout(30, 1));
		
		pnl.add(createLabel("To run simple example", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));
		
		pnl.add(createLabel("1. Select a map", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("Click on \"Manage maps\" and then \"Load map\". Choose map you like", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));

		pnl.add(createLabel("2. Add dangers", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("Press \"Set environment\" button, then click on \"Add danger\"", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("Now you can click on the map to add danger", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("You can change danger size using slider below.", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));

		pnl.add(createLabel("3. Add agents", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("You've already clicked \"Set environment\" button.", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("Next press \"Add agents\". Now you can click on the map to add agent." , FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("You can change agent size using slider below", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));
		
		pnl.add(createLabel("4. Select evacuation algorithm:", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("Choose one of the algorihm from the list", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));

		pnl.add(createLabel("5. Run simulation", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("Fun part! Click on \"Simulate\" and then \"Run simulation\"", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("Watch your agents escaping :)", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));

		pnl.add(createLabel("6. Analyze statistics", FontSet.INFO_FRAME_BOLD_FONT));
		pnl.add(createLabel("Click on \"Analyze statistics\" and then \"Show statistics\"", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("On the first tab you can see data about current simulation.", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("On the second tab you can see data about map you've chosen", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("\n", FontSet.INFO_FRAME_FONT));

		pnl.add(createLabel("=========================================", FontSet.INFO_FRAME_FONT));
		pnl.add(createLabel("For more details and advanced options description visit:", FontSet.INFO_FRAME_FONT));
		
		JLabel label = new JLabel("<html><font size=4><a href=#>" + "http://www.example.com/" + "</a></font></html>");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {

		            try {
						Desktop.getDesktop().browse(new URI("http://www.example.com/"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    }
		});
		
		pnl.add(label);
		JOptionPane.showMessageDialog(null, pnl);
	}

	class OpenUrlAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			open(uri);
		}
	}

	private static void open(URI uri) {

		if (Desktop.isDesktopSupported()) {

			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

package view.fileChooser;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

class FileDialogExample extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6957090966612704552L;
	JFrame thisFrame;
	JComboBox<String> jb;
	JButton b;

	public FileDialogExample() {
		// Store current object in thisFrame
		thisFrame = this;
		createAndShowGUI();
	}

	private void createAndShowGUI() {

		// Set frame properties
		setTitle("File Dialog Example");
		setSize(500, 500);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Create JComboBox
		jb = new JComboBox<String>();

		// Add items to the frame
		jb.addItem("LOAD"); // 0 index
		jb.addItem("SAVE"); // 1 index

		b = new JButton("Fire!");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// Create a FileDialog whose parent is this frame and with title selected in JComboBox
				FileDialog fd = new FileDialog(thisFrame, (String) jb.getSelectedItem());

				// Set a dir
				fd.setDirectory("building_schema");

				// Set FileDialog.LOAD=0 or FileDialog.SAVE=1
				fd.setMode(jb.getSelectedIndex());

				// Make it visible
				fd.setVisible(true);
			}
		});

		// Add JComboBox
		add(jb);

		// Add button
		add(b);
	}

	public static void main(String args[]) {
		new FileDialogExample();
	}
}
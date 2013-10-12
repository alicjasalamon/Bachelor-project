package main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import resources.Resources;

import view.mainwindow.MainWindow;

//import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				try {

					Resources.initialize();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Resources.mainFrame = new MainWindow();

				}

				catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

}

package view.infos;

import java.awt.Dimension;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import resources.ColorSet;
import resources.FontSet;
import resources.GUIResources;

public class HelpFrame extends JFrame {

	private static final long serialVersionUID = -338909528663988811L;
	
	public HelpFrame() {
		
		super("HELP");
		String everything = null;
		
		BufferedReader br = null;
	    try {
	    	 br = new BufferedReader(new FileReader(GUIResources.helpPath));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append('\n');
	            line = br.readLine();
	        }
	        everything = sb.toString();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    finally {
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 200);
		setPreferredSize(new Dimension(800,500));
		setBackground(ColorSet.WHITE);
		
		JPanel mainPanel = new JPanel(); 
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		JTextArea info = new JTextArea(everything);
		
		info.setFont(FontSet.MENU_FONT);
		info.setEditable(false);
		
		info.setLineWrap(true);
		info.setWrapStyleWord(true);

		mainPanel.add(info);
		//mainPanel.setPreferredSize(new Dimension(20, 200));
		pack();
	    setVisible(true);
	    setState(Frame.ICONIFIED);
	    setState(Frame.NORMAL);
		add(mainPanel);
		setVisible(true);

	}

}

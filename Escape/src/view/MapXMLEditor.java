package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import view.mainwindow.functionalPanels.FunctionalButton;

public class MapXMLEditor extends JFrame {

	private static final long serialVersionUID = 1L;

	public MapXMLEditor(final FileDialog fd){

		setPreferredSize(new Dimension(1000, 800));
		JPanel cp = new JPanel(new BorderLayout());

		RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
		//	      textArea.setCodeFoldingEnabled(true);
		//	      textArea.setAntiAliasingEnabled(true);
		try {
			textArea.setText(readFile("building_schema\\example.xml", Charset.defaultCharset()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RTextScrollPane sp = new RTextScrollPane(textArea);
		//sp.setFoldIndicatorEnabled(true);
		cp.add(sp, BorderLayout.CENTER);
		setContentPane(cp);
		
		FunctionalButton fb = new FunctionalButton("functionalPanelsIcons\\Save.png", "Save map");
		fb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					fd.setVisible(true);
			}
		});
		
		cp.add(fb, BorderLayout.SOUTH);
		setTitle("Map editor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}

}

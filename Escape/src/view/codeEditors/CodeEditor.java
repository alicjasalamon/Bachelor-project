package view.codeEditors;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import resources.GUIResources;

/**
 * 
 * @author Alicja Salamon
 *
 */
public class CodeEditor {

	FileDialog fileDialog;
	CodeFrame codeFrame;

	String language;
	String mode;

	/**
	 * 
	 * @param language editor language - "Java" or "XML"
	 * @param mode editor mode - "edit" for editing existing file or "new" for creating new one
	 */
	public CodeEditor(String language, String mode) {

		codeFrame = new CodeFrame();

		if (language.equals("Java") && mode.equals("new"))
			JavaNew();
		else if (language.equals("Java") && mode.equals("edit"))
			JavaEdit();
		else if (language.equals("XML") && mode.equals("new"))
			XMLNew();
		else if (language.equals("XML") && mode.equals("edit"))
			XMLEdit();

	}

	private void XMLEdit() {

		FileDialog fd = new FileDialog(GUIResources.mainFrame, "Save your building", FileDialog.LOAD);
		fd.setDirectory("building_schema");
		fd.setVisible(true);

		final String fileName = fd.getFile();
		if (fileName != null) {

			codeFrame.setTitle(fileName);
			codeFrame.setLanguage(SyntaxConstants.SYNTAX_STYLE_XML);
			codeFrame.setInitText("building_schema\\" + fileName);
			codeFrame.setActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					PrintWriter out = null;
					try {
						out = new PrintWriter("building_schema\\" + fileName);
						out.write(codeFrame.textArea.getText());
						GUIResources.setSuccesMessage("Map successfully saved");
					} catch (FileNotFoundException e1) {
						GUIResources.setErrorMessage("Error while saving the map");
						e1.printStackTrace();
					}finally{
						out.close();
					}
				}
			});
			codeFrame.setVisible(true);
		}

	}

	private void XMLNew() {

		codeFrame.setActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileDialog fd = new FileDialog(GUIResources.mainFrame, "Save your building", FileDialog.SAVE);
				fd.setDirectory("building_schema");
				fd.setVisible(true);

				String fileName = fd.getFile();
				if (fileName != null) {

					PrintWriter out = null;
					try {
						out = new PrintWriter("building_schema\\" + fileName);
						out.write(codeFrame.textArea.getText());
						GUIResources.setSuccesMessage("Map successfully saved");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
						GUIResources.setErrorMessage("Error while saving the map");
					}finally{
						out.close();
					}
				}
			}
		});
		codeFrame.setLanguage(SyntaxConstants.SYNTAX_STYLE_XML);
		codeFrame.setTitle("Add new building");
		codeFrame.setInitText("building_schema\\example.xml");
		codeFrame.setVisible(true);

	}

	private void JavaEdit() {

		FileDialog fd = new FileDialog(GUIResources.mainFrame, "Save your algorithm", FileDialog.LOAD);
		fd.setDirectory("algorithms");
		fd.setVisible(true);

		final String fileName = fd.getFile();
		if (fileName != null) {

			codeFrame.setTitle(fileName);
			codeFrame.setInitText("algorithms\\" + fileName);
			codeFrame.setActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("zapisuje algosa");

				}
			});
			codeFrame.setVisible(true);
		}
	}

	private void JavaNew() {

		codeFrame.setActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileDialog fd = new FileDialog(GUIResources.mainFrame, "Save your algorithm", FileDialog.SAVE);
				fd.setDirectory("algorithms");
				fd.setVisible(true);

				String fileName = fd.getFile();
				if (fileName != null) {
					System.out.println("zapisujemy algorytm");
				}
			}
		});
		codeFrame.setLanguage(SyntaxConstants.SYNTAX_STYLE_JAVA);
		codeFrame.setTitle("Add new building");
		codeFrame.setInitText("algorithms\\ExampleAlgorithm.java");
		codeFrame.setVisible(true);
	}
}

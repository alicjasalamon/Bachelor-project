package view.codeEditors;

import java.awt.BorderLayout;
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
import org.fife.ui.rtextarea.RTextScrollPane;

public class CodeFrame extends JFrame {

	private static final long serialVersionUID = 5931190065262214270L;

	RSyntaxTextArea textArea;
	JButton saveButton;

	public CodeFrame() {

		setLayout(new BorderLayout());
		setLocation(100, 200);
		JPanel cp = new JPanel(new BorderLayout());
		textArea = new RSyntaxTextArea(20, 60);
		RTextScrollPane sp = new RTextScrollPane(textArea);
		cp.add(sp, BorderLayout.CENTER);
		setContentPane(cp);
		saveButton = new SaveButton();
		cp.add(saveButton, BorderLayout.SOUTH);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		pack();

	}

	public void setActionListener(ActionListener actionListener) {
		saveButton.addActionListener(actionListener);
	}

	public void setLanguage(String syntaxStyle) {
		textArea.setSyntaxEditingStyle(syntaxStyle);

	}

	public void setInitText(String fileName) {

		String content = readFile(fileName, Charset.defaultCharset());
		textArea.setText(content);
	}

	private String readFile(String path, Charset encoding){
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}

}

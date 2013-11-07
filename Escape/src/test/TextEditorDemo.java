package test;
import java.awt.BorderLayout;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * A simple example showing how to use RSyntaxTextArea to add Java syntax
 * highlighting to a Swing application.<p>
 * 
 * This example uses RSyntaxTextArea 2.0.1.<p>
 * 
 * Project Home: http://fifesoft.com/rsyntaxtextarea<br>
 * Downloads: https://sourceforge.net/projects/rsyntaxtextarea
 */
public class TextEditorDemo extends JFrame {

   private static final long serialVersionUID = 1L;

   public TextEditorDemo() throws IOException {

      JPanel cp = new JPanel(new BorderLayout());

      RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
      textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
//      textArea.setCodeFoldingEnabled(true);
//      textArea.setAntiAliasingEnabled(true);
      textArea.setText(readFile("building_schema\\example.xml", Charset.defaultCharset()));
      RTextScrollPane sp = new RTextScrollPane(textArea);
      //sp.setFoldIndicatorEnabled(true);
      cp.add(sp);

      setContentPane(cp);
      setTitle("Text Editor Demo");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);

   }

   public static void main(String[] args) {
      // Start all Swing applications on the EDT.
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            try {
				new TextEditorDemo().setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
      });
   }
   
   static String readFile(String path, Charset encoding) 
		   throws IOException 
		 {
		   byte[] encoded = Files.readAllBytes(Paths.get(path));
		   return encoding.decode(ByteBuffer.wrap(encoded)).toString();
		 }

}
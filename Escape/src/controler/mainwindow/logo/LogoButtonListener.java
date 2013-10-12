package controler.mainwindow.logo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class LogoButtonListener implements MouseListener{
	
	JButton button;
	
	public LogoButtonListener(JButton button) {
		this.button = button;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		button.setForeground(Color.WHITE);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		button.setForeground(Color.BLACK);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

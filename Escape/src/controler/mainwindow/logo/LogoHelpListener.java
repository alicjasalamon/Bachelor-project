package controler.mainwindow.logo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.infos.HelpFrame;

public class LogoHelpListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		new HelpFrame();
		
	}

}

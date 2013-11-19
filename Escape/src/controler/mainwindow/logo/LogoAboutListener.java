package controler.mainwindow.logo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.infos.AboutFrame;

public class LogoAboutListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		new AboutFrame();

	}
}

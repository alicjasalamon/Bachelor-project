package view.mainwindow;

import javax.swing.JPanel;

import controler.mainwindow.functionalPanels.ClickAction;

abstract public class BasicControl extends JPanel {
	
	private static final long serialVersionUID = -6653377217783303240L;
	protected ClickAction clickAction;
	
	public BasicControl(ClickAction clickAction) {
		super();
		this.clickAction = clickAction;
	}
	
	
	

}

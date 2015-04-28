package View;

import javax.swing.*;

import Control.BackgroundWork;


public class GuiPanel extends JPanel{

	private static final long serialVersionUID = 6345793767655993977L;
	GuiFrame gf;
	JButton einkaufBTN;
	JButton verkaufBTN;
	JButton manuellBTN;
	public GuiPanel(GuiFrame guiF) {
		gf=guiF;
		initializeComponents();
	}
	
	private void initializeComponents() {
		
		einkaufBTN = new JButton("Einkauf");
		verkaufBTN = new JButton("Verkauf");
		manuellBTN = new JButton("Manuell");
		
		add(einkaufBTN);
		add(verkaufBTN);
		add(manuellBTN);
		
		einkaufBTN.addActionListener(gf.getController().getAl());
		verkaufBTN.addActionListener(gf.getController().getAl());
		manuellBTN.addActionListener(gf.getController().getAl());
	}
}

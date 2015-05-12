package View;

import javax.swing.*;

import Control.BackgroundWork;


public class GuiPanel extends JPanel{

	private static final long serialVersionUID = 6345793767655993977L;
	GuiFrame gf;
	JButton buchenBTN;
	JButton kaufBTN;
	JButton verkaufBTN;
	JButton manuellBTN;
	public GuiPanel(GuiFrame guiF) {
		gf=guiF;
		initializeComponents();
	}
	
	private void initializeComponents() {
		
		buchenBTN = new JButton("Buchung");
		kaufBTN = new JButton("Kauf");
		verkaufBTN = new JButton("Verkauf");
		manuellBTN = new JButton("Kontoplan");
		
		add(buchenBTN);
		add(kaufBTN);
		add(verkaufBTN);
		add(manuellBTN);
		
		buchenBTN.addActionListener(gf.getController().getAl());
		kaufBTN.addActionListener(gf.getController().getAl());
		verkaufBTN.addActionListener(gf.getController().getAl());
		manuellBTN.addActionListener(gf.getController().getAl());
	}
}

package View;

import javax.swing.*;


public class GuiPanel extends JPanel{

	private static final long serialVersionUID = 6345793767655993977L;
	JButton einkaufBTN;
	JButton verkaufBTN;
	JButton manuellBTN;
	public GuiPanel() {
		initializeComponents();
	}
	
	private void initializeComponents() {
		
		einkaufBTN = new JButton("Einkauf");
		verkaufBTN = new JButton("Verkauf");
		manuellBTN = new JButton("Manuell");
		
		add(einkaufBTN);
		add(verkaufBTN);
		add(manuellBTN);
	}
}

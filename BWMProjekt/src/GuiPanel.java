import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;


public class GuiPanel extends JPanel{

	private static final long serialVersionUID = 6345793767655993977L;
	JButton button1;
	JButton button2;
	
	public GuiPanel() {
		initializeComponents();
	}
	
	private void initializeComponents() {
		
		button1 = new JButton("Einkauf");
		button2 = new JButton("Verkauf");
		
		add(button1);
		add(button2);
	}
}

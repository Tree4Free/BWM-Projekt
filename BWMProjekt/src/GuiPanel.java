import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;


public class GuiPanel extends JPanel{

	private static final long serialVersionUID = 6345793767655993977L;
	
	JLabel label1;
	JMenuBar menubar1;
	JMenu menu1;
	JMenuItem menuitem1;
	JMenuItem menuitem2;
	JMenuItem menuitem3;
	
	public GuiPanel() {
		initializeComponents();
	}
	
	private void initializeComponents() {
		label1 = new JLabel("1. Kontoklasse");
		label1.setVisible(true);
		
		add(label1);
	}
}

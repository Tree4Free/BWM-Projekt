package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Control.BackgroundWork;


public class GuiFrame extends JFrame{

	private static final long serialVersionUID = -5127355639317818573L;
	JMenuBar menubar1;
	JMenu menu1;
	JMenuItem menuitem1;
	JMenuItem menuitem2;
	JMenuItem menuitem3;
	BackgroundWork controller;
	public GuiFrame(String titel, BackgroundWork c) {
		super(titel);
		controller=c;
		initComponents();
		this.setLocationRelativeTo(null);
	}
		
		private void initComponents()
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			GuiPanel panel1 = new GuiPanel(this);
			this.add(panel1);  
			
			menubar1 = new JMenuBar();
			menu1 = new JMenu("Datei");
			menuitem1 = new JMenuItem("Laden");
			menuitem2 = new JMenuItem("Speichern");
			
			menuitem1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			});
			
			menuitem2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			//menuitem3 = new JMenuItem("Öffnen");
			menu1.add(menuitem1);
			menu1.add(menuitem2);
			//menu1.add(menuitem3);
			menubar1.add(menu1);
			
			this.setJMenuBar(menubar1);
			this.setSize(350,300);
			this.setLocation(30,20); 
			this.setVisible(true);
		}
		public BackgroundWork getController(){
			return controller;
		}
}

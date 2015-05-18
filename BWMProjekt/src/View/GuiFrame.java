package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import Control.BackgroundWork;
import Model.KKlasse;


public class GuiFrame extends JFrame{

	private static final long serialVersionUID = -5127355639317818573L;
	JMenuBar menubar1;
	JMenu menu1;
	JMenuItem menuitem1;
	JMenuItem menuitem2;
	JMenuItem menuitem3;
	BackgroundWork controller;
	JFileChooser jfc=new JFileChooser(new String());
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
			
			jfc.addChoosableFileFilter(new FileFilter() {
				
				@Override
				public String getDescription() {
					// TODO Auto-generated method stub
					return "*.sav";
				}
				
				@Override
				public boolean accept(File f) {
					// TODO Auto-generated method stub
					if(getExtension(f.getName()).equals(".sav")||f.isDirectory()){
						return true;
					}
					return false;
				}
			});
			jfc.setAcceptAllFileFilterUsed(false);
			
			menubar1 = new JMenuBar();
			menu1 = new JMenu("Datei");
			menuitem1 = new JMenuItem("Laden");
			menuitem2 = new JMenuItem("Speichern");
			
			menuitem1.addActionListener(new ActionListener() {
				
				@SuppressWarnings("unchecked")
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						jfc.showOpenDialog(null);
						FileInputStream FIS =new FileInputStream(jfc.getSelectedFile());
						ObjectInputStream OIS =new ObjectInputStream(FIS);
						controller.setAr((ArrayList<KKlasse>)OIS.readObject());
						JOptionPane.showMessageDialog(null, "Load complete");
						OIS.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			});
			
			menuitem2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						jfc.showSaveDialog(null);
						FileOutputStream FOS;
						if (!getExtension(jfc.getSelectedFile().getName()).equals(".sav")) {
							FOS=new FileOutputStream(jfc.getSelectedFile().getAbsolutePath()+".sav");
						}else {
							FOS =new FileOutputStream(jfc.getSelectedFile());
						}
						ObjectOutputStream OOS =new ObjectOutputStream(FOS);
						OOS.writeObject(controller.getAr());
						JOptionPane.showMessageDialog(null, "Save complete");
						OOS.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
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
		
		private String getExtension(String s){
			try {
				return s.substring(s.lastIndexOf("."));
			} catch (Exception e2) {
				// TODO: handle exception
				return "";
			}
		}
}

package View;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class GuiFrame extends JFrame{

	private static final long serialVersionUID = -5127355639317818573L;
	JMenuBar menubar1;
	JMenu menu1;
	JMenuItem menuitem1;
	JMenuItem menuitem2;
	JMenuItem menuitem3;
	public GuiFrame(String titel) {
		super(titel);
		initComponents();		
	}
		
		private void initComponents()
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			GuiPanel panel1 = new GuiPanel();
			this.add(panel1);  
			
			menubar1 = new JMenuBar();
			menu1 = new JMenu("Datei");
			menuitem1 = new JMenuItem("Laden");
			menuitem2 = new JMenuItem("Speichern");
			menuitem3 = new JMenuItem("�ffnen");
			menu1.add(menuitem1);
			menu1.add(menuitem2);
			menu1.add(menuitem3);
			menubar1.add(menu1);
			this.setJMenuBar(menubar1);
			this.setSize(350,300);
			this.setLocation(30,20); 
			this.setVisible(true);
		}

}

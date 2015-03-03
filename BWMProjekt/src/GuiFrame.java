import javax.swing.JFrame;


public class GuiFrame extends JFrame{

	public GuiFrame(String titel) {
		super(titel);
		initComponents();		
	}
		
		private void initComponents()
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			GuiPanel panel1 = new GuiPanel();
			this.add(panel1);  
			this.setSize(350,300);
			this.setLocation(30,20); 
			this.setVisible(true);		
		}

}

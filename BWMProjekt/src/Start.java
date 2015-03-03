import javax.swing.SwingUtilities;


public class Start {
	
	public static void main(String[] args) {
		BackgroundWork bw=new BackgroundWork();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				GuiFrame frame=new GuiFrame("BWM-Application");
			}
		});
	}
}

package Control;
import javax.swing.SwingUtilities;

import View.GuiFrame;


public class Start {
	
	public static void main(String[] args) {
		BackgroundWork bw=new BackgroundWork();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				GuiFrame frame=new GuiFrame("BWM-Projekt");
			}
		});
	}
}

package View;
import javax.swing.JFrame;

import Control.BackgroundWork;


public class KontoNRFrame extends JFrame{
	public KontoNRPanel kp;
	public KontoNRFrame(BackgroundWork bg) {
		kp=new KontoNRPanel(bg);
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		
		this.add(kp);
		this.setVisible(true);
	}
}

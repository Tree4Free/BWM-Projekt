package View;
import javax.swing.JFrame;

import Control.BackgroundWork;


public class KontoNRFrame extends JFrame{
	public KontoNRPanel kp;
	public KontoNRFrame(BackgroundWork bg) {
		kp=new KontoNRPanel(bg);
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 500);
		
		this.add(kp);
		this.setVisible(true);
	}
}

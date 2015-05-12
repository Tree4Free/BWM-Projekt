package View;

import java.awt.Dimension;

import javax.swing.JFrame;

import Control.BackgroundWork;

public class KaufFrame extends JFrame{
	public KaufFrame(BackgroundWork bg) {
		// TODO Auto-generated constructor stub
		KaufPanel kp=new KaufPanel(bg);
		this.add(kp);
		this.setSize(new Dimension(700,400));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
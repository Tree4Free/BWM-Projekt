package View;

import java.awt.Dimension;

import javax.swing.JFrame;

import Control.BackgroundWork;

public class VerkaufFrame extends JFrame{
	public VerkaufFrame(BackgroundWork bg) {
		// TODO Auto-generated constructor stub
		VerkaufPanel kp=new VerkaufPanel(bg);
		this.add(kp);
		this.setSize(new Dimension(800,400));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
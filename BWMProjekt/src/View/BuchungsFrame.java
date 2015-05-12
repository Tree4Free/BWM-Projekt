package View;

import java.awt.Dimension;

import javax.swing.JFrame;

import Control.BackgroundWork;

public class BuchungsFrame extends JFrame{
	public BuchungsFrame(BackgroundWork bg) {
		// TODO Auto-generated constructor stub
		BuchungsPanel bp=new BuchungsPanel(bg);
		this.add(bp);
		this.setSize(new Dimension(700,400));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}

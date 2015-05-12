package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import View.BuchungsFrame;
import View.KaufFrame;
import View.KontoNRFrame;

public class BWMActionListener implements ActionListener{
	BackgroundWork bw;
	public BWMActionListener(BackgroundWork bw) {
		// TODO Auto-generated constructor stub
		this.bw=bw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "Buchung":
			System.out.println("Buchung");
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					BuchungsFrame f= new BuchungsFrame(bw);
				}
			});
			break;
		case "Kauf":
			System.out.println("Kauf");
			KaufFrame k = new KaufFrame(bw);
			break;
		case "Verkauf":
			System.out.println("Verkauf");
			break;
		case "Kontoplan":
			System.out.println("Kontoplan");
			KontoNRFrame kf=new KontoNRFrame(bw);
			kf.kp.fillTable(bw.klassen);
			break;
		default:
			break;
		}
	}

}

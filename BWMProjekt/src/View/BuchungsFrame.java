package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.BackgroundWork;
import Model.AwKlasse;
import Model.ErKlasse;
import Model.KKlasse;
import Model.KKlasseAktiv;
import Model.KKlassePassiv;

public class BuchungsFrame extends JFrame{
	public boolean expanded=false;
	public JTextField v5;
	public JTextField v6;
	public JLabel l1;
	public BuchungsFrame(BackgroundWork bg) {
		// TODO Auto-generated constructor stub
		BuchungsPanel bp=new BuchungsPanel(bg, this);
		this.setLayout(new BorderLayout());
		JPanel gridLt=new JPanel();
		gridLt.setLayout(new GridLayout(2,1));
		gridLt.add(bp);
		JPanel row2 = new JPanel();
		row2.setLayout(new GridLayout(1,7));
		
		
		l1=new JLabel();
		
		v5=new JTextField();
		v5.setPreferredSize(new Dimension(100,30));
		row2.add(v5);
		v5.setVisible(false);
		
		
		v5.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (v5.getText().length()==4||v5.getText().length()==5) {
					if(bp.isNumb(v5.getText().toCharArray())){
						KKlasse kkl;
						switch (v5.getText().charAt(0)) {
						case '0':
							kkl=new KKlasseAktiv(v5.getText(), 0, "");
							break;
						case '1':
							kkl=new KKlasseAktiv(v5.getText(), 0, "");
							break;
						case '2':
							kkl=new KKlasseAktiv(v5.getText(), 0, "");
							break;
						case '3':
							kkl=new KKlassePassiv(v5.getText(), 0, "");
							break;
						case '4':
							kkl=new ErKlasse(v5.getText(), "");
							break;
						case '5':
							kkl=new AwKlasse(v5.getText(), "");
							break;
						case '6':
							kkl=new AwKlasse(v5.getText(), "");
							break;
						case '7':
							kkl=new AwKlasse(v5.getText(), "");
							break;
						case '8':
							kkl=new ErKlasse(v5.getText(), "");
							break;
						case '9':
							kkl=new KKlassePassiv(v5.getText(), 0, "");
							break;
						default:
							kkl=null;
							break;
						}
						if (bg.getAr().contains(kkl)) {
							if (bg.getAr().get(bg.getAr().indexOf(kkl)).getName().length()>20) {
								l1.setText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName().substring(0, 20)+"...");
								l1.setToolTipText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName());
							}else {
								l1.setText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName());
								l1.setToolTipText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName());
							}
						}else {
							l1.setText("");
							l1.setToolTipText("");
						}
					}else {
						l1.setText("");
						l1.setToolTipText("");
					}
					
				}else {
					l1.setText("");
					l1.setToolTipText("");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		row2.add(l1);
		
		v6=new JTextField();
		v6.setPreferredSize(new Dimension(100,30));
		row2.add(v6);
		v6.setVisible(false);
		row2.add(new Panel());
		row2.add(new Panel());
		row2.add(new Panel());
		row2.add(new Panel());
		row2.add(new Panel());
		gridLt.add(row2);
		this.add(gridLt, BorderLayout.CENTER);
		JButton expandBTN =new JButton("Expand");
		expandBTN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (expandBTN.getText().equals("Expand")) {
					expandBTN.setText("Minimize");
					bp.v2.setVisible(true);
					v5.setVisible(true);
					v6.setVisible(true);
					expanded=true;
				}else {
					expandBTN.setText("Expand");
					bp.v2.setVisible(false);
					v5.setVisible(false);
					v6.setVisible(false);
					expanded=false;
				}
			}
		});
		this.add(expandBTN, BorderLayout.SOUTH);
		this.setSize(new Dimension(700,130));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
}

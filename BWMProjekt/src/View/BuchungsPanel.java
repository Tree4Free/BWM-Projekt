package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.BackgroundWork;
import Model.KKlasseAktiv;
import Model.KKlassePassiv;

public class BuchungsPanel extends JPanel{
	BackgroundWork bg;
	public BuchungsPanel(BackgroundWork bg) {
		// TODO Auto-generated constructor stub
		this.bg=bg;
		JTextField v1=new JTextField();
		v1.setPreferredSize(new Dimension(100,30));
		this.add(v1);
		v1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (v1.getText().length()==4||v1.getText().length()==5) {
					//bg.getAr().get(bg.getAr().indexOf());
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel k1=new JLabel();
		this.add(k1);
		
		JTextField v2=new JTextField();
		v2.setPreferredSize(new Dimension(100,30));
		this.add(v2);
		v2.setVisible(false);
		
		JLabel k2=new JLabel("/");
		this.add(k2);
		
		JTextField v3=new JTextField();
		v3.setPreferredSize(new Dimension(100,30));
		this.add(v3);
		
		JLabel k3=new JLabel();
		this.add(k3);
		
		JTextField v4=new JTextField();
		v4.setPreferredSize(new Dimension(100,30));
		this.add(v4);
		
		JButton b1=new JButton("Buchen");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!v1.getText().equals("")&&(v1.getText().startsWith("0")||v1.getText().startsWith("1")||v1.getText().startsWith("2"))) {
					bg.getAr().get(bg.getAr().indexOf(new KKlasseAktiv(v1.getText(), 0, k1.getText()))).getSoll().add(Float.parseFloat(v4.getText()));
					bg.getAr().get(bg.getAr().indexOf(new KKlassePassiv(v3.getText(), 0, k3.getText()))).getHaben().add(Float.parseFloat(v4.getText()));
					
				}
			}
		});
		this.add(b1);
	}
	
	
}

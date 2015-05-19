package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.BackgroundWork;
import Model.AwKlasse;
import Model.ErKlasse;
import Model.KKlasse;
import Model.KKlasseAktiv;
import Model.KKlassePassiv;

public class BuchungsPanel extends JPanel{
	BackgroundWork bg;
	BuchungsFrame bf;
	public BuchungsPanel(BackgroundWork bg, BuchungsFrame b) {
		// TODO Auto-generated constructor stub
		this.bg=bg;
		bf=b;
		JTextField v1=new JTextField();
		v1.setPreferredSize(new Dimension(100,30));
		this.add(v1);
		JLabel k1=new JLabel();
		v1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (v1.getText().length()==4||v1.getText().length()==5) {
					if(isNumb(v1.getText().toCharArray())){
						KKlasse kkl;
						switch (v1.getText().charAt(0)) {
						case '0':
							kkl=new KKlasseAktiv(v1.getText(), 0, "");
							break;
						case '1':
							kkl=new KKlasseAktiv(v1.getText(), 0, "");
							break;
						case '2':
							kkl=new KKlasseAktiv(v1.getText(), 0, "");
							break;
						case '3':
							kkl=new KKlassePassiv(v1.getText(), 0, "");
							break;
						case '4':
							kkl=new ErKlasse(v1.getText(), "");
							break;
						case '5':
							kkl=new AwKlasse(v1.getText(), "");
							break;
						case '6':
							kkl=new AwKlasse(v1.getText(), "");
							break;
						case '7':
							kkl=new AwKlasse(v1.getText(), "");
							break;
						case '8':
							kkl=new ErKlasse(v1.getText(), "");
							break;
						case '9':
							kkl=new KKlassePassiv(v1.getText(), 0, "");
							break;
						default:
							kkl=null;
							break;
						}
						if (bg.getAr().contains(kkl)) {
							if (bg.getAr().get(bg.getAr().indexOf(kkl)).getName().length()>20) {
								k1.setText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName().substring(0, 20)+"...");
								k1.setToolTipText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName());
							}else {
								k1.setText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName());
								k1.setToolTipText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName());
							}
						}else {
							k1.setText("");
							k1.setToolTipText("");
						}
					}else {
						k1.setText("");
						k1.setToolTipText("");
					}
					
				}else {
					k1.setText("");
					k1.setToolTipText("");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
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
		
		v3.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (v3.getText().length()==4||v3.getText().length()==5) {
					if(isNumb(v3.getText().toCharArray())){
						KKlasse kkl;
						switch (v3.getText().charAt(0)) {
						case '0':
							kkl=new KKlasseAktiv(v3.getText(), 0, "");
							break;
						case '1':
							kkl=new KKlasseAktiv(v3.getText(), 0, "");
							break;
						case '2':
							kkl=new KKlasseAktiv(v3.getText(), 0, "");
							break;
						case '3':
							kkl=new KKlassePassiv(v3.getText(), 0, "");
							break;
						case '4':
							kkl=new ErKlasse(v3.getText(), "");
							break;
						case '5':
							kkl=new AwKlasse(v3.getText(), "");
							break;
						case '6':
							kkl=new AwKlasse(v3.getText(), "");
							break;
						case '7':
							kkl=new AwKlasse(v3.getText(), "");
							break;
						case '8':
							kkl=new ErKlasse(v3.getText(), "");
							break;
						case '9':
							kkl=new KKlassePassiv(v3.getText(), 0, "");
							break;
						default:
							kkl=null;
							break;
						}
						if (bg.getAr().contains(kkl)) {
							if (bg.getAr().get(bg.getAr().indexOf(kkl)).getName().length()>20) {
								k3.setText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName().substring(0, 20)+"...");
								k3.setToolTipText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName());
							}else {
								k3.setText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName());
								k3.setToolTipText(bg.getAr().get(bg.getAr().indexOf(kkl)).getName());
							}
						}else {
							k3.setText("");
							k3.setToolTipText("");
						}
						
					}else {
						k3.setText("");
						k3.setToolTipText("");
					}
					
				}else {
					k3.setText("");
					k3.setToolTipText("");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
					
				}else if(!v1.getText().equals("")&&(v1.getText().startsWith("3")||v1.getText().startsWith("9"))){
					bg.getAr().get(bg.getAr().indexOf(new KKlassePassiv(v1.getText(), 0, k1.getText()))).getHaben().add(Float.parseFloat(v4.getText()));
					bg.getAr().get(bg.getAr().indexOf(new KKlasseAktiv(v3.getText(), 0, k3.getText()))).getSoll().add(Float.parseFloat(v4.getText()));
				}else if(!v1.getText().equals("")&&(v1.getText().startsWith("4")||v1.getText().startsWith("8"))){
					bg.getAr().get(bg.getAr().indexOf(new ErKlasse(v1.getText(), k1.getText()))).getHaben().add(Float.parseFloat(v4.getText()));
					bg.getAr().get(bg.getAr().indexOf(new AwKlasse(v3.getText(), k3.getText()))).getSoll().add(Float.parseFloat(v4.getText()));
				}else if(!v1.getText().equals("")&&(v1.getText().startsWith("5")||v1.getText().startsWith("6")||v1.getText().startsWith("7"))){
					bg.getAr().get(bg.getAr().indexOf(new AwKlasse(v1.getText(), k1.getText()))).getSoll().add(Float.parseFloat(v4.getText()));
					bg.getAr().get(bg.getAr().indexOf(new ErKlasse(v3.getText(), k3.getText()))).getHaben().add(Float.parseFloat(v4.getText()));
				}else{
					JOptionPane.showMessageDialog(null, "Buchung fehlgeschlagen", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(JOptionPane.showConfirmDialog(null, "Buchung erfolgreich. Weiter buchen?","Buchung erfolgreich",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION){
					b.dispose();
				}else {
					v1.setText("");
					v3.setText("");
					v4.setText("");
				}
			}
		});
		this.add(b1);
	}
	
	public boolean isNumb(char[] a){
		for(char b:a){
			if(!Character.isDigit(b)){
				return false;
			}
		}
		return true;
	}
	
}

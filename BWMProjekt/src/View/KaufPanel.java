package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class KaufPanel extends JPanel implements ActionListener{
	BackgroundWork bg;
	KaufFrame kf;
	public KaufPanel(BackgroundWork bg, KaufFrame k) {
		// TODO Auto-generated constructor stub
		this.bg=bg;
		kf=k;
		JTextField v1=new JTextField();
		v1.setPreferredSize(new Dimension(100,30));
		this.add(v1);
		JLabel k1=new JLabel();
		JLabel steuer = new JLabel();
		JLabel v4=new JLabel();
		JLabel l1 = new JLabel();
		l1.setText("2500 Vorsteuer");
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
		
		JTextField netto = new JTextField();
		netto.setPreferredSize(new Dimension(80,30));
		netto.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try{
				steuer.setText(""+(Float.parseFloat(netto.getText())/5)+" €");
				v4.setText(""+(Float.parseFloat(netto.getText())+Float.parseFloat(netto.getText())/5)+" €");
				}catch(NumberFormatException ex){
					steuer.setText("");
				}
				
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				//// TODO Auto-generated method stub
				
			}
			
		});
		this.add(netto);
		
		
		JLabel k2=new JLabel("/");
		this.add(k2);
		
		String[] patternExamples = {
		         "2700 Kassa",
		         "2800 Bank",
		         "3185 Verbindlichkeiten Kreditkarte",
		         "3186 Verbindlichkeiten Bankomatkarte",
		         "3300 Verbindlichkeiten aus Liferungen und Leistungen Inland (Sammelkonto)",
		         "5010 Handelswaren-Einsatz"
		};
		JComboBox<String> patternList = new JComboBox<String>(patternExamples);
		patternList.setEditable(true);
		patternList.addActionListener(this);
		
		
		this.add(patternList);
		

		this.add(v4);
		
		
		JButton b1=new JButton("Buchen");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!v1.getText().equals("")&&(patternList.getSelectedItem().toString().startsWith("2")||patternList.getSelectedItem().toString().startsWith("3"))&&(v1.getText().startsWith("0")||v1.getText().startsWith("1")||v1.getText().startsWith("2"))) {
					bg.getAr().get(bg.getAr().indexOf(new KKlasseAktiv(v1.getText(), 0, k1.getText()))).getSoll().add(Float.parseFloat(netto.getText()));
					bg.getAr().get(bg.getAr().indexOf(new KKlasseAktiv(patternList.getSelectedItem().toString().substring(0, 4), 0, patternList.getSelectedItem().toString().substring(5)))).getHaben().add(Float.parseFloat(v4.getText().substring(0, v4.getText().lastIndexOf(" "))));
					bg.getAr().get(bg.getAr().indexOf(new KKlasseAktiv("2500",0,l1.getText()))).getSoll().add(Float.parseFloat(steuer.getText().substring(0, steuer.getText().lastIndexOf(" "))));
					
					
					if(JOptionPane.showConfirmDialog(null, "Buchung erfolgreich. Weiter buchen?","Buchung erfolgreich",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION){
						kf.dispose();
					}else {
						v1.setText("");
						netto.setText("");
						v4.setText("");
					}
				}else if(!v1.getText().equals("")&&patternList.getSelectedItem().toString().startsWith("3")&&(v1.getText().startsWith("0")||v1.getText().startsWith("1")||v1.getText().startsWith("2"))){
					bg.getAr().get(bg.getAr().indexOf(new KKlasseAktiv(v1.getText(), 0, k1.getText()))).getSoll().add(Float.parseFloat(netto.getText()));
					bg.getAr().get(bg.getAr().indexOf(new KKlassePassiv(patternList.getSelectedItem().toString().substring(0, 4), 0, patternList.getSelectedItem().toString().substring(5)))).getHaben().add(Float.parseFloat(v4.getText().substring(0, v4.getText().lastIndexOf(" "))));
					bg.getAr().get(bg.getAr().indexOf(new KKlasseAktiv("2500",0,l1.getText()))).getSoll().add(Float.parseFloat(steuer.getText().substring(0, steuer.getText().lastIndexOf(" "))));
					
					
					if(JOptionPane.showConfirmDialog(null, "Buchung erfolgreich. Weiter buchen?","Buchung erfolgreich",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION){
						kf.dispose();
					}else {
						v1.setText("");
						netto.setText("");
						v4.setText("");
				}
			}
			}
		});
		
		this.add(b1);
		
		
		
		this.add(l1);
		this.add(steuer);
		
		
		
	}
	
	public boolean isNumb(char[] a){
		for(char b:a){
			if(!Character.isDigit(b)){
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

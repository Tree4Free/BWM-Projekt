package View;

import java.awt.Dimension;
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

public class VerkaufPanel extends JPanel implements ActionListener{
	BackgroundWork bg;
	public VerkaufPanel(BackgroundWork bg) {
		// TODO Auto-generated constructor stub
		this.bg=bg;
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
		
		String[] patternExamples = {
				"4000 Umsatzerlöse Inland (20 % USt)",
				"4010 Umsatzerlöse Inland (10 % USt)",
				"4600 Erlöse Anlagenverkauf",
				"4820 Eigenverbrauch (Sachbezug) 20 %",
				"4830 Mieterlöse",
				"4900 Erträge aus der Auflösung"
		};
		JComboBox<String> patternList = new JComboBox<String>(patternExamples);
		patternList.setEditable(true);
		patternList.addActionListener(this);
		
		
		this.add(patternList);
		
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
					bg.getAr().get(bg.getAr().indexOf(new KKlassePassiv(patternList.getSelectedItem().toString().substring(0, 4), 0, patternList.getSelectedItem().toString().substring(5)))).getHaben().add(Float.parseFloat(v4.getText()));
					JOptionPane.showMessageDialog(null, "Erfolgreich gebucht", "Erfolgreich", JOptionPane.PLAIN_MESSAGE);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Control.BackgroundWork;
import Model.AwKlasse;
import Model.ErKlasse;
import Model.KKlasse;
import Model.KKlasseAktiv;
import Model.KKlassePassiv;


public class KontoNRPanel extends JPanel{
	BackgroundWork bg;
	JTextField kontoNR;
	JTable kontoNRList;
	JButton button;
	JPanel jp;
	JScrollPane jsp=new JScrollPane();
	DefaultTableModel DTM;
	
	public KontoNRPanel(BackgroundWork bg) {
		// TODO Auto-generated constructor stub
		this.bg=bg;
		this.setLayout(new BorderLayout());
		initializeComponents();
		kontoNRList.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Konto Nr.", "Soll", "Haben", "Saldo"
	            }
	        ) {
	            /**
				 * 
				 */
				private static final long serialVersionUID = 1786458240700384704L;
				@SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
	                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
	            };
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false
	            };

	            @SuppressWarnings({ "rawtypes", "unchecked" })
				public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
	    jsp.setViewportView(kontoNRList);
	    DTM=(DefaultTableModel)kontoNRList.getModel();
	    DTM.setRowCount(0);
	    kontoNRList.getTableHeader().setResizingAllowed(false);
	    kontoNRList.getTableHeader().setReorderingAllowed(false);
	    kontoNRList.getColumnModel().getColumn(0).setPreferredWidth(400);
		jp.add(kontoNR);
		jp.add(button);
		this.add(jp, BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
	}
	private void initializeComponents(){
		kontoNR = new JTextField();
		button = new JButton("Search");
		kontoNRList = new JTable();
		kontoNR.setPreferredSize(new Dimension(100,30));
		kontoNR.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				ArrayList<KKlasse> kkl=new ArrayList<>();
				
				if(kontoNR.getText().length()==0){
					fillTable(bg.getAr());
					return;
				}
				if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
					System.out.println("backspace");
					for (KKlasse k:bg.getAr()) {
						if((k.getKontoklasse()+" "+k.getName()).contains(kontoNR.getText())){
							switch (k.getKontoklasse().charAt(0)) {
							case '0':
								kkl.add(new KKlasseAktiv(k.getKontoklasse(), 0, k.getName()));
								break;
							case '1':
								kkl.add(new KKlasseAktiv(k.getKontoklasse(), 0, k.getName()));
								break;
							case '2':
								kkl.add(new KKlasseAktiv(k.getKontoklasse(), 0, k.getName()));
								break;
							case '3':
								kkl.add(new KKlassePassiv(k.getKontoklasse(), 0, k.getName()));
								break;
							case '4':
								kkl.add(new ErKlasse(k.getKontoklasse(), k.getName()));
								break;
							case '5':
								kkl.add(new AwKlasse(k.getKontoklasse(), k.getName()));
								break;
							case '6':
								kkl.add(new AwKlasse(k.getKontoklasse(), k.getName()));
								break;
							case '7':
								kkl.add(new AwKlasse(k.getKontoklasse(), k.getName()));
								break;
							case '8':
								kkl.add(new ErKlasse(k.getKontoklasse(), k.getName()));
								break;
							case '9':
								kkl.add(new KKlassePassiv(k.getKontoklasse(), 0, k.getName()));
								break;
							default:
								break;
							}
						}
					}
					fillTable(kkl);
					return;
				}
				for (int i = 0; i < DTM.getRowCount(); i++) {
					if(DTM.getValueAt(i, 0).toString().contains(kontoNR.getText())){
						switch (DTM.getValueAt(i, 0).toString().charAt(0)) {
						case '0':
							kkl.add(new KKlasseAktiv(DTM.getValueAt(i, 0).toString().substring(0, 4), 0, DTM.getValueAt(i, 0).toString().substring(5)));
							break;
						case '1':
							kkl.add(new KKlasseAktiv(DTM.getValueAt(i, 0).toString().substring(0, 4), 0, DTM.getValueAt(i, 0).toString().substring(5)));
							break;
						case '2':
							kkl.add(new KKlasseAktiv(DTM.getValueAt(i, 0).toString().substring(0, 4), 0, DTM.getValueAt(i, 0).toString().substring(5)));
							break;
						case '3':
							kkl.add(new KKlassePassiv(DTM.getValueAt(i, 0).toString().substring(0, 4), 0, DTM.getValueAt(i, 0).toString().substring(5)));
							break;
						case '4':
							kkl.add(new ErKlasse(DTM.getValueAt(i, 0).toString().substring(0, 4), DTM.getValueAt(i, 0).toString().substring(5)));
							break;
						case '5':
							kkl.add(new AwKlasse(DTM.getValueAt(i, 0).toString().substring(0, 4), DTM.getValueAt(i, 0).toString().substring(5)));
							break;
						case '6':
							kkl.add(new AwKlasse(DTM.getValueAt(i, 0).toString().substring(0, 4), DTM.getValueAt(i, 0).toString().substring(5)));
							break;
						case '7':
							kkl.add(new AwKlasse(DTM.getValueAt(i, 0).toString().substring(0, 4), DTM.getValueAt(i, 0).toString().substring(5)));
							break;
						case '8':
							kkl.add(new ErKlasse(DTM.getValueAt(i, 0).toString().substring(0, 4), DTM.getValueAt(i, 0).toString().substring(5)));
							break;
						case '9':
							kkl.add(new KKlassePassiv(DTM.getValueAt(i, 0).toString().substring(0, 4), 0, DTM.getValueAt(i, 0).toString().substring(5)));
							break;
						default:
							break;
						}
					}
				}
				fillTable(kkl);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
		
			}
		});
		jp=new JPanel();
	}
	
	public void fillTable(ArrayList<KKlasse> ar){
		DTM.setRowCount(0);
		Collections.sort(ar);
		for (KKlasse k:ar) {
			double soll=0;
			for (double d:k.getSoll()) {
				soll+=d;
			}
			double haben=0;
			for (double d:k.getHaben()) {
				haben+=d;
			}
			DTM.addRow(new Object[]{k.getKontoklasse()+" "+k.getName(),soll,haben,Math.abs(soll-haben)});;
		}
	}
}

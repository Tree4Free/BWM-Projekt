package View;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class KontoNRPanel extends JPanel{
	
	JTextField kontoNR;
	JTable kontoNRList;
	JButton button;
	JPanel jp;
	
	public KontoNRPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		initializeComponents();
		DefaultTableModel DTM=(DefaultTableModel) kontoNRList.getModel();
        DTM.setRowCount(0);
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DTM.addColumn("Hallo");
			}
		});
		jp.add(kontoNR);
		jp.add(button);
		this.add(jp, BorderLayout.NORTH);
		this.add(kontoNRList, BorderLayout.SOUTH);
	}
	private void initializeComponents(){
		kontoNR = new JTextField();
		button = new JButton();
		kontoNRList = new JTable();
		jp=new JPanel();
	}
}

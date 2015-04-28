package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BWMActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "Einkauf":
			System.out.println("Einkauf");
			break;
		case "Verkauf":
			System.out.println("Verkauf");
			break;
		case "Manuell":
			System.out.println("Manuell");
			break;
		default:
			break;
		}
	}

}

package View;
import javax.swing.JFrame;


public class KontoNRFrame extends JFrame{
	public KontoNRFrame() {
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 500);
		this.add(new KontoNRPanel());
		this.setVisible(true);
	}
}

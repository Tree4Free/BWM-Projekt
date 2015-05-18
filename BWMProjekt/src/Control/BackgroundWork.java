package Control;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

import Model.AwKlasse;
import Model.ErKlasse;
import Model.KKlasse;
import Model.KKlasseAktiv;
import Model.KKlassePassiv;
import View.GuiFrame;

public class BackgroundWork {
	Properties kKlassenPlan;
	ArrayList<KKlasse> klassen;
	BWMActionListener al;
	GuiFrame frame;
	public BackgroundWork() {
		// TODO Auto-generated constructor stub
		BackgroundWork tempBG = this;
		al=new BWMActionListener(this);
		kKlassenPlan = new Properties();
		load();
		klassen = new ArrayList<>();
		fill();
		SwingUtilities.invokeLater(new Runnable() {	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				frame=new GuiFrame("BWM-Projekt", tempBG);
			}
		});
		TimerTask uploadCheckerTimerTask = new TimerTask(){

			public void run() {
				try {
					File f=new File("save.sav");
					FileOutputStream FOS =new FileOutputStream(f);
					ObjectOutputStream OOS =new ObjectOutputStream(FOS);
					OOS.writeObject(getAr());
					System.out.println("Autosave complete: "+f.getAbsolutePath());
					OOS.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		};

		Timer uploadCheckerTimer = new Timer(true);
		uploadCheckerTimer.scheduleAtFixedRate(uploadCheckerTimerTask, 0, 300000);
	}
	
	public void load(){
		try {
			FileInputStream fis = new FileInputStream("Klassen.conf");
			kKlassenPlan.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	public void fill(){
		for(Object s:kKlassenPlan.keySet()){
			if(((String)s).startsWith("0")||((String)s).startsWith("1")||((String)s).startsWith("2")){
				klassen.add(new KKlasseAktiv((String)s, 0, kKlassenPlan.getProperty((String)s)));
			}else if(((String)s).startsWith("3")||((String)s).startsWith("9")){
				klassen.add(new KKlassePassiv((String)s, 0, kKlassenPlan.getProperty((String)s)));
			}else if(((String)s).startsWith("5")||((String)s).startsWith("6")||((String)s).startsWith("7")||((String)s).startsWith("8")){
				klassen.add(new AwKlasse((String)s, kKlassenPlan.getProperty((String)s)));
			}else if(((String)s).startsWith("4")/*||((String)s).startsWith("8")*/){
				klassen.add(new ErKlasse((String)s, kKlassenPlan.getProperty((String)s)));
			}else{
				System.out.println("Klasse exestiert nicht.");
			}
		}
	}
	
	public ArrayList<KKlasse> getAr(){
		return klassen;
	}
	
	public void setAr(ArrayList<KKlasse> kk){
		this.klassen=kk;
	}
	
	public BWMActionListener getAl() {
		return al;
	}	
}

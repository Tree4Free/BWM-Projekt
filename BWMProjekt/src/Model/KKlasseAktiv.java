package Model;
import java.util.ArrayList;


public class KKlasseAktiv extends KKlasse{
	public KKlasseAktiv(String kk, float anfangsbestand, String name) {
		// TODO Auto-generated constructor stub
		kontoklasse = kk;
		this.name=name;
		soll = new ArrayList<Float>();
		haben = new ArrayList<Float>();
		setAnfangsbestand(anfangsbestand);
	}
	public void setAnfangsbestand(float ab){
		this.anfangsbestand=ab;
		haben.add(this.anfangsbestand);
	}
	public void plusRechnen(float plus){
		haben.add(plus);
	}
	public void minusRechnen(float minus){
		soll.add(minus);
	}
	public float getEndbestand(){
		float Endbestand=0f;
		for(float p:haben){
			Endbestand+=p;
		}
		for(float m:soll){
			Endbestand-=m;
		}
		return Endbestand;
	}
}

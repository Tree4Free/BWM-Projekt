package Model;
import java.util.ArrayList;


public class KKlassePassiv extends KKlasse{
	
	public KKlassePassiv(String kk, float anfangsbestand, String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
		kontoklasse = kk;
		soll = new ArrayList<Float>();
		haben = new ArrayList<Float>();
		setAnfangsbestand(anfangsbestand);
	}
	public void setAnfangsbestand(float ab){
		this.anfangsbestand=ab;
		soll.add(this.anfangsbestand);
	}
	public void minusRechnen(float minus){
		soll.add(minus);
	}
	public void plusRechnen(float plus){
		haben.add(plus);
	}
	public float getEndbestand(){
		float Endbestand=0f;
		for(float p:soll){
			Endbestand+=p;
		}
		for(float m:haben){
			Endbestand-=m;
		}
		return Endbestand;
	}
}

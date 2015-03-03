import java.util.ArrayList;


public class KKlassePassiv extends KKlasse{
	
	public KKlassePassiv(String kk, float anfangsbestand) {
		// TODO Auto-generated constructor stub
		kontoklasse = kk;
		soll = new ArrayList<Float>();
		haben = new ArrayList<Float>();
		setAnfangsbestand(anfangsbestand);
	}
	public void setAnfangsbestand(float ab){
		this.anfangsbestand=ab;
		soll.add(this.anfangsbestand);
	}
	public void plusRechnen(float plus){
		soll.add(plus);
	}
	public void minusRechnen(float minus){
		haben.add(minus);
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

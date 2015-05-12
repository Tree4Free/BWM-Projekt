package Model;
import java.io.Serializable;
import java.util.ArrayList;


public abstract class KKlasse implements Comparable<KKlasse>, Serializable{
	String kontoklasse;
	String name;
	float anfangsbestand;
	ArrayList<Float> soll;
	ArrayList<Float> haben;
	public String getKontoklasse() {
		return kontoklasse;
	}
	public void setKontoklasse(String kontoklasse) {
		this.kontoklasse = kontoklasse;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAnfangsbestand() {
		return anfangsbestand;
	}
	public void setAnfangsbestand(float anfangsbestand) {
		this.anfangsbestand = anfangsbestand;
	}
	public ArrayList<Float> getSoll() {
		return soll;
	}
	public void setSoll(ArrayList<Float> soll) {
		this.soll = soll;
	}
	public ArrayList<Float> getHaben() {
		return haben;
	}
	public void setHaben(ArrayList<Float> haben) {
		this.haben = haben;
	}
	@Override
	public int compareTo(KKlasse o) {
		// TODO Auto-generated method stub
		return Integer.parseInt(kontoklasse)-Integer.parseInt(o.getKontoklasse());
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.kontoklasse.equals(((KKlasse)obj).getKontoklasse());
	}
	
}

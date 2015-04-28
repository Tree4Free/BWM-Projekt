package Model;


public class AwKlasse extends KKlassePassiv{

	public AwKlasse(String kk,String name) {
		super(kk, 0, name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void plusRechnen(float plus) {
		// TODO Auto-generated method stub
		super.minusRechnen(plus);
	}

	@Override
	public void minusRechnen(float minus) {
		// TODO Auto-generated method stub
		super.plusRechnen(minus);
	}
}

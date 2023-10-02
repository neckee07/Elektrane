package energetskisistem;

public class Baterija {
	
	private int trenutnaEn;
	private int max;
	
	public Baterija(int max) {
		this.trenutnaEn=max;
		this.max = max;
	}
	
	public void dodajEn(int br) {
		if((trenutnaEn+br) > max) {
			trenutnaEn = max;
		}else {
			trenutnaEn += br;
		}
	}
	
	public void isprazni() {
		trenutnaEn = 0;
	}
	
	public boolean puna() {
		if(trenutnaEn == max) {
			return true;
		}else {
			return false;
		}
	}
}

package energetskisistem;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac {
	
	private int brvodenih = 0;

	public Hidroelektrana(Baterija b, Plac o) {
		super("H", Color.BLUE, 1500, b, o);
		this.setForeground(Color.white);
	}
	
	@Override
	public void postavi(int broj) {
		brvodenih = broj;
		br = brvodenih;
		if(brvodenih>0) {
			uspeh = true;
		}
		
	}
	
	
	
	
}

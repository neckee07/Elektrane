package energetskisistem;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;

public class Plac extends Panel{

	int br = 0;
	private Parcela stara;
	private ArrayList<Parcela> parcele = new ArrayList<>();
	private Parcela p;
	private int red, kolona;
	private int izabrani;
	
	
	
	public Plac(int red, int kolona) {
		super(new GridLayout(red,kolona,3,3));
		this.red = red;
		this.kolona = kolona;
		for(int i = 0; i<red*kolona;i++) {
			
				br = (int) (Math.random()*9 + 1);
				if(br>3) {
					add(p = new TravnataPovrs(this));
					parcele.add(p);
				}else {
					add(p = new VodenaPovrs(this));
					parcele.add(p);
				}
			
		}
	}
	
	public void promeni(int i) {
		parcele.get(izabrani).setFont(new Font("Serif", Font.BOLD, 14));
		parcele.get(i).setFont(new Font("Serif", Font.BOLD, 20));
		izabrani = i;
	}
	
	public void dodaj(Proizvodjac p) {
		
		if(p instanceof Hidroelektrana) {
			
			int brojac = 0;
			if(izabrani-1 >= 0)
				if((parcele.get(izabrani-1)) instanceof VodenaPovrs) {
					brojac++;
				}
			if(izabrani+1 < red*kolona)
				if(parcele.get(izabrani+1) instanceof VodenaPovrs) {
					brojac++;
				}
			if(izabrani-red >= 0)
				if(parcele.get(izabrani-red) instanceof VodenaPovrs) {
					brojac++;
				}
			if(izabrani+red < red*kolona)
				if(parcele.get(izabrani+red) instanceof VodenaPovrs) {
					brojac++;
				}
			p.postavi(brojac);
		}
		
		remove(izabrani);
		parcele.remove(izabrani);
		parcele.add(izabrani, p);
		parcele.get(izabrani).zameniIndex(izabrani);
		add(p, izabrani);
		
		
	}
	
	
	
	
}

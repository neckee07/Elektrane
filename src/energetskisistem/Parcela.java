package energetskisistem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Parcela extends Label {

	
	protected Plac owner;
	
	protected char oznaka;
	protected Color pozadina;
	
	private static int stindex;
	private int index = stindex++;
	
	public Parcela(String c, Color pozadina, Plac o) {
		super(c);
		this.owner = o;
		this.pozadina = pozadina;
		this.setBackground(pozadina);
		this.setFont(new Font("Serif", Font.BOLD, 14));
		this.setAlignment(Label.CENTER);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public synchronized void mouseClicked(MouseEvent e) {
				owner.promeni(index);
				
			}
		});
	}
	
	public void zameniIndex(int i ) {
		index = i;
	}
	
	
	
	public void promeniPozadinu(Color c) {
		this.setBackground(c);
	}
	
}

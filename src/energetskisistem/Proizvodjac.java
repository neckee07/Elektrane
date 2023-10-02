package energetskisistem;

import java.awt.Color;

public class Proizvodjac extends Parcela implements Runnable {
	
	protected int vreme;
	protected Baterija baterija;
	protected int br;
	protected boolean uspeh = false;
	protected Thread thread;
	
	public Proizvodjac(String c, Color pozadina,int vreme, Baterija b, Plac o) {
		super(c, pozadina, o);
		this.vreme = vreme;
		this.baterija = b;
		
	}
	
	public void pokreni() {
		//finish();
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void finish() {
		if(thread != null) {
			thread.interrupt();
		}
		while(thread != null) {
			try {
				wait();
			} catch (InterruptedException e) { 
			}
		}
	}
	
	public void stop() {
		if(thread != null)
			thread.interrupt();
	}
	
	public void postavi(int br) {
		
	}

	@Override
	public void run() {
		
		try {
			while(!thread.isInterrupted()) {
				this.setForeground(Color.WHITE);
				Thread.sleep(vreme+(int)(Math.random()*300));
				synchronized(baterija) {
					if(uspeh && !baterija.puna()) {
						baterija.dodajEn(br);
						this.setForeground(Color.RED);
						
					}
				}
				Thread.sleep(300);
			}
		} catch (InterruptedException e) {
		}
	}

}

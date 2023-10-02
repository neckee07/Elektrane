package energetskisistem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;



public class EnergetskiSistem extends Frame {
	private Baterija b;
	private Plac plac;
	private Button dodaj = new Button("Dodaj");
	private ArrayList<Proizvodjac> proizvodjaci = new ArrayList<>();
	
	
	//private Panel panel = new Panel(new GridLayout(2, 2, 3, 3));
	
	private void populateWindow() {
		
//			Menu bgColorMenu = new Menu("Bg color");
//			MenuItem bgWhite = new MenuItem("white");
//			MenuItem bgGray = new MenuItem("gray");
//			
//			bgColorMenu.add(bgWhite);
//			bgColorMenu.add(bgGray);
//			
//			bgWhite.addActionListener((ae) ->{
//				scene.setBgColor(Color.white);
//				
//			});
//			
//			bgGray.addActionListener((ae)->{
//				scene.setBgColor(Color.gray);
//				
//			});
//			
//			Menu factorMenu = new Menu ("Size");
//			MenuItem small =new MenuItem("3");
//			MenuItem big = new MenuItem("5");
//			
//			factorMenu.add(small);
//			factorMenu.add(big);
//			
//			small.addActionListener((ae)->{
//				scene.setFactor(Integer.parseInt(((MenuItem)ae.getSource()).getLabel()));
//			});
//			
//			big.addActionListener((ae)->{
//				scene.setFactor(Integer.parseInt(((MenuItem)ae.getSource()).getLabel()));
//			});
//			
//			MenuItem quitMenu = new MenuItem("Quit", new MenuShortcut(KeyEvent.VK_Q));
//			
//			quitMenu.addActionListener((ae)->{
//				dispose();
//			});
//			
//			Menu file = new Menu("File");
//			file.add(bgColorMenu);
//			file.add(factorMenu);
//			file.addSeparator();
//			file.add(quitMenu);
//			
//			MenuBar menuBar = new MenuBar();
//			menuBar.add(file);
//			this.setMenuBar(menuBar);
//			
//			add(scene, BorderLayout.CENTER);
//			
//			drawButton.addActionListener((ae) -> {
//				scene.repaint();
//			});
//			
//			Panel buttonPanel = new Panel();
//			
//			Choice chooseShape = new Choice();
//			chooseShape.add("Heart");
//			chooseShape.add("Circle");
//			
//			chooseShape.addItemListener((ie) -> {
//				String name = chooseShape.getSelectedItem();
//				if(name.equals("Heart")) {
//					scene.setShape(new Heart());
//				}else if(name.equals("Circle")) {
//					scene.setShape(new Circle(15));
//				}
//			});
//			
//			List chooseColor = new List(2);
//			chooseColor.add("Black");
//			chooseColor.add("Red");
//			chooseColor.add("Green");
//			
//			chooseColor.select(0);
//			
//			chooseColor.addItemListener((ie) -> {
//				String item = chooseColor.getSelectedItem();
//				if(item.equals("Black")) {
//					scene.setColor(Color.black);
//				}else if(item.equals("Red")) {
//					scene.setColor(Color.red);
//				}else if(item.equals("Green")) {
//					scene.setColor(Color.green);
//				}
//			});
//			
//			buttonPanel.add(new Label ("Shape: "));
//			buttonPanel.add(chooseShape);
//			buttonPanel.add(new Label ("color: "));
//			buttonPanel.add(chooseColor);
//			buttonPanel.add(drawButton);
//			
//			add(buttonPanel, BorderLayout.SOUTH);
//			
//		}
		
		//////////////////////////////////////////////////
		
		dodaj.addActionListener((ae)-> {
			
			
			
			Proizvodjac proiz = new Hidroelektrana(b, plac);
			proizvodjaci.add(proiz);
			plac.dodaj(proiz);
			proiz.pokreni();
			plac.revalidate();
			//System.out.println(b.puna());
		});
		
		
		add(dodaj, BorderLayout.NORTH);
		//add(panel, BorderLayout.CENTER);
		add(plac, BorderLayout.CENTER);
		
	}
	
	
	
	public EnergetskiSistem(int red, int kolona,int kapacitet) {
		
		this.plac = new Plac(red, kolona);
		this.b = new Baterija(kapacitet);
		
		setBounds(800, 400, 500, 500);
		setResizable(false);
		setTitle("");

		populateWindow();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				for(Proizvodjac p:proizvodjaci) {
					p.stop();
				}
				dispose();
			}
			
		});
		setVisible(true);
	}

	
	public static void main(String[] args) {
		new EnergetskiSistem(5,5,10);
	}
	
}

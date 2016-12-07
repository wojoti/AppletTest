import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MyAppletZdarzenia2 extends Applet implements ItemListener {

	private static final long serialVersionUID = 1L;
	// Deklaracje obiektow - zmiennych reprezentujacych przyciski i okno tekstowe
	Button przycisk1, przycisk2, przycisk3;
	Checkbox c1,c2,c3;

	TextField oknoTekstowe;

	public void init() {
		
		c1 = new Checkbox("1"); //deklaracja checkboxów
		add(c1);
		c1.addItemListener(this); //dodanie listenera do danego checkboxa 

		c2 = new Checkbox("2");
		add(c2);
		c2.addItemListener(this);
		
		c3 = new Checkbox("2");
		add(c3);
		c3.addItemListener(this);

	}	// koniec funkcji init

	boolean bokA = false, bokB = false, bokC = false; //deklaracja boolean do wskazania czy bok A,B lub C ma byc wyswietlany

	public void paint(Graphics g) { //funkcja zajmujaca sie grafika
		setSize(500,500); //zmiana rozmiaru okna programu
		if (bokA == true) { //jezeli program ustawi ze A ma byc wyswietlany
			g.setColor(this.getForeground()); //zmien kolor na kolor czarny - "jest narysowany"
			g.drawLine(50, 50, 80, 190); //rysuj linie od takiego x,y do takiego
		} else {
			g.setColor(this.getBackground()); //kolor tla - "nie jest wyswietlany"
			g.drawLine(50, 50, 80, 190);
		}

		if (bokB == true) {
			g.setColor(Color.BLACK); //tutaj kolory sa po prostu okreslone na czarny i bialy a nie na background i foreground
			g.drawLine(80, 190, 190, 50);
		} else {
			g.setColor(Color.WHITE); //
			g.drawLine(80, 190, 190, 50);		}

		if (bokC == true) {
			g.setColor(Color.BLACK);
			g.drawLine(190, 50, 50, 50);
		} else {
			g.setColor(Color.WHITE);
			g.drawLine(190, 50, 50, 50);
		}
	}

	public void itemStateChanged(ItemEvent evt) {

		if (evt.getItemSelectable() == c1) { //jezeli checkbox zostanie zaznaczony to zmieni sie wartosc boolean bokA na odwrotna
			bokA = !bokA;
		}

		if (evt.getItemSelectable() == c2) {
			bokB = !bokB;
		}

		if (evt.getItemSelectable() == c3) {
			bokC = !bokC;
		}

		repaint(); 	// WAZNE, zeby funkcja paint wywolywala sie ponownie 
	}	// koniec funkcji actionPerformed

}		// koniec klasy Appletu

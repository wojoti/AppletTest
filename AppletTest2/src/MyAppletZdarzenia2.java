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
		
		c1 = new Checkbox("1");
		add(c1);
		c1.addItemListener(this);

		c2 = new Checkbox("2");
		add(c2);
		c2.addItemListener(this);
		
		c3 = new Checkbox("2");
		add(c3);
		c3.addItemListener(this);

	}	// koniec funkcji init

	boolean bokA = false, bokB = false, bokC = false;

	public void paint(Graphics g) {
		setSize(500,500);
		if (bokA == true) {
			g.setColor(this.getForeground());
			g.drawLine(50, 50, 80, 190);
		} else {
			g.setColor(this.getBackground());
			g.drawLine(50, 50, 80, 190);
		}

		if (bokB == true) {
			g.setColor(Color.BLACK);
			g.drawLine(80, 190, 190, 50);
		} else {
			g.setColor(Color.WHITE);
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

		if (evt.getItemSelectable() == c1) {
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

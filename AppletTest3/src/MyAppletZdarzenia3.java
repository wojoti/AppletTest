import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MyAppletZdarzenia3 extends Applet implements ItemListener, ActionListener {

	private static final long serialVersionUID = 1L;
	// Deklaracje obiektow - zmiennych reprezentujacych przyciski i okno tekstowe
	CheckboxGroup cbg1;
	Checkbox c1,c2,c3;

	TextField oknoTekstowe;
	Button przycisk1,przycisk2,przycisk3;
	
	Choice choice1;
	TextField wybor;

	public void init() {
		
		wybor = new TextField(20);
		add(wybor);
		choice1 = new Choice();
		choice1.add("Black");
		choice1.add("Red");
		choice1.add("Blue");
		add(choice1);
		choice1.addItemListener(this);
		
		c1 = new Checkbox("1");
		add(c1);
		c1.addItemListener(this);

		c2 = new Checkbox("2");
		add(c2);
		c2.addItemListener(this);
		
		c3 = new Checkbox("3");
		add(c3);
		c3.addItemListener(this);
		
		przycisk1 = new Button("WLACZ A");	// inicjalizacja przycisku
		add(przycisk1);						// wyswietla przycisk w oknie appletu
		przycisk1.addActionListener(this);	// przypisuje przyciskowi dzialanie opisane w actionPerformed
		
		przycisk2 = new Button("WLACZ B");	
		add(przycisk2);						
		przycisk2.addActionListener(this);	

		przycisk3 = new Button("WLACZ C");	
		add(przycisk3);						
		przycisk3.addActionListener(this);

	}	// koniec funkcji init

	boolean bokA = false, bokB = false, bokC = false;
	String color = "Red";
	public void paint(Graphics g) {
		setSize(500,500);
		color = (String)(wybor.getText());
		if (bokA == true) {
			g.setColor(this.getForeground()); 
			g.drawLine(50,50, 80, 190);
			przycisk1.setLabel("wylacz bokA");
		}
		else {
			g.setColor(this.getBackground()); 
			g.drawLine(50,50, 80, 190);
			przycisk1.setLabel("WLACZ bokA");
		}
		
		if (bokB == true) {
			g.setColor(this.getForeground());
			g.drawLine(80, 190, 190, 50);
			przycisk2.setLabel("wylacz bokA");
		}
		else {
			g.setColor(this.getBackground()); 
			g.drawLine(80, 190, 190, 50);
			przycisk2.setLabel("WLACZ bokB");
		}
		
		if (bokC == true) {
			g.setColor(this.getForeground());
			g.drawLine(190, 50, 50, 50);
				przycisk3.setLabel("wylacz bokC");
		}
		else {
			g.setColor(this.getBackground());
			g.drawLine(190, 50, 50, 50);
				przycisk3.setLabel("WLACZ bokC");
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
		if(evt.getItemSelectable() == choice1){
			wybor.setText(((Choice)evt.getItemSelectable()).getSelectedItem());
		}

		repaint(); 	// WAZNE, zeby funkcja paint wywolywala sie ponownie 
	}
	// koniec funkcji actionPerformed

	public void actionPerformed(ActionEvent evt) {
		
		if (evt.getSource() == przycisk1) {
			bokA = !bokA; 
			c1.setState(!c1.getState()); //tutaj funkcja actionperformed dodatkowo oprocz odwrocenia boolean odwraca status checkboxa - odpal program to wszystko sie wyjasni :D 
		}
		
		if (evt.getSource() == przycisk2){
			bokB = !bokB; 
			c2.setState(!c2.getState());
		}
		
		if (evt.getSource() == przycisk3){
			bokC = !bokC;
			c3.setState(!c3.getState());
		}
		
		repaint(); 	// WAZNE, zeby funkcja paint wywolywala sie ponownie 
	}

}// koniec klasy Appletu

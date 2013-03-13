package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Event extends JPanel{
	
	private int startH, startM,endH,endM;
	private String desc,place;
	private JLabel text;
		
	public Event(){		
		startH = 15;
		startM = 30;
		endH = 16;
		endM = 30;
		desc = "Viktig";
		place = "p15";
		text = new JLabel();
		text.setText(startH + ":" + startM + "\n"+ desc + "\n" + place);
		
		setSize(new Dimension(100,100));
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
			
		add(text);
	}
}

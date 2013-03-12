package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
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
		
		setLayout(new BorderLayout());
		
		//setBackground(Color.GRAY);
	}
	
	public void paint(Graphics g){
		g.drawRect(0, startH + startM, 100, endH + endM);
		add(text);
	}
}

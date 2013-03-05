package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Calender extends JPanel implements ActionListener{
	
	public Calender(){
		setPreferredSize(new Dimension(800,400));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		add(new DayView("Mandag"));
		add(new DayView("Tirsdag"));
		add(new DayView("Onsdag"));
		add(new DayView("Torsdag"));
		add(new DayView("Fredag"));
		add(new DayView("Lørdag"));
		add(new DayView("Søndag"));
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand().toString());
	}
	
}

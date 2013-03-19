package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class Calendar extends JPanel implements ActionListener {

	protected DayView mon, tue, wed, thu, fri, sat, sun;

	public Calendar() {
		setPreferredSize(new Dimension(800, 400));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));

		mon = new DayView("Mandag");
		tue = new DayView("Tirsdag");
		wed = new DayView("Onsdag");
		thu = new DayView("Torsdag");
		fri = new DayView("Fredag");
		sat = new DayView("Lørdag");
		sun = new DayView("Søndag");

		add(mon);
		add(tue);
		add(wed);
		add(thu);
		add(fri);
		add(sat);
		add(sun);

		mon.addEvents();

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand().toString());
	}

}

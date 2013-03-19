package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import common.EventI;
import common.EventListI;

class Calendar extends JPanel implements ActionListener {

	protected DayView mon, tue, wed, thu, fri, sat, sun;
	protected EventListI eventList;

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

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand().toString());
	}

	public void addEvents() throws RemoteException {
		EventI[] eList = (EventI[]) eventList.getList().toArray();
		for (int i = 0; i < eList.length; i++) {
			int day = eList[i].getStart().getDayOfWeek();

			if (day == 1) {
				mon.model.addElement(eList[i]);
			} else if (day == 2) {
				tue.model.addElement(eList[i]);
			} else if (day == 3) {
				wed.model.addElement(eList[i]);
			} else if (day == 4) {
				thu.model.addElement(eList[i]);
			} else if (day == 5) {
				fri.model.addElement(eList[i]);
			} else if (day == 6) {
				sat.model.addElement(eList[i]);
			} else if (day == 7) {
				sun.model.addElement(eList[i]);
			}
		}
	}
}

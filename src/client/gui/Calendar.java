package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.joda.time.DateTime;

import week.Week;

import common.EventI;
import common.EventListI;
import common.GroupI;
import common.UserI;

class Calendar extends JPanel implements ActionListener {

	protected DayView mon, tue, wed, thu, fri, sat, sun;
	protected EventListI eventList;
	protected ArrayList<EventI> eventListByDay;
	protected ArrayList<UserI> users;
	protected ArrayList<GroupI> groups;
	protected Week week;
	protected DateTime day = MainClass.now;

	public Calendar() {

		week = new Week(day);

		users = new ArrayList<UserI>();
		users.add(MainClass.getCurrentUser());

		groups = new ArrayList<GroupI>();

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

		addEvent(week.getFromDate());
		addEvent(week.getFromDate().plusDays(1));
		addEvent(week.getFromDate().plusDays(2));
		addEvent(week.getFromDate().plusDays(3));
		addEvent(week.getFromDate().plusDays(4));
		addEvent(week.getFromDate().plusDays(5));
		addEvent(week.getFromDate().plusDays(6));

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand().toString());
	}

	public void addEvent(DateTime date) {
		try {
			eventList = MainClass.sServer.eventStorage.getEventList(users,
					groups, date);
			eventListByDay = eventList.getList();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getMonthOfYear());
		System.out.println(date.getYear());
		for (int i = 0; i < eventListByDay.size(); i++) {
			if (date.getDayOfWeek() == 1) {
				mon.model.addElement(eventListByDay.get(i));
			} else if (date.getDayOfWeek() == 2) {
				tue.model.addElement(eventListByDay.get(i));
			} else if (date.getDayOfWeek() == 3) {
				wed.model.addElement(eventListByDay.get(i));
			} else if (date.getDayOfWeek() == 4) {
				thu.model.addElement(eventListByDay.get(i));
			} else if (date.getDayOfWeek() == 5) {
				fri.model.addElement(eventListByDay.get(i));
			} else if (date.getDayOfWeek() == 6) {
				sat.model.addElement(eventListByDay.get(i));
			} else if (date.getDayOfWeek() == 7) {
				sun.model.addElement(eventListByDay.get(i));
			}
		}
	}
}

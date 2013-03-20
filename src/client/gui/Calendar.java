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

import common.EventI;
import common.EventListI;
import common.GroupI;
import common.UserI;
import common.WeekI;

class Calendar extends JPanel implements ActionListener {

	protected DayView mon, tue, wed, thu, fri, sat, sun;
	protected EventListI eventList;
	protected ArrayList<EventI> eventListByDay;
	protected ArrayList<UserI> users;
	protected ArrayList<GroupI> groups;
	protected WeekI week;
	protected DateTime date = new DateTime(2013,3,18,15,30);

	public Calendar() {

		users = new ArrayList<UserI>();
		users.add(MainClass.getCurrentUser());

		groups = new ArrayList<GroupI>();

		try {
			eventList = MainClass.sServer.eventStorage.getEventList(users,
					groups, date);
			eventListByDay = eventList.getList();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}

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

		addEvent();

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand().toString());
	}

	public void addEvent() {
		for (int i = 0; i < eventListByDay.size(); i++) {
			mon.model.addElement(eventListByDay.get(i));
		}

		// week.setWeek(year, weeknr)
		// date = new DateTime(week.getYear(),week.getFromDate(),5,5,6);
	}
}

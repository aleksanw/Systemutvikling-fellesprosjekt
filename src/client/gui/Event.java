package client.gui;

import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

public class Event {

	private String desc, place, text, name;
	private DateTime time;

	public Event(String desc, String place, String name, int startH,
			int startM, int endH, int eM, int date, boolean isMeeting,
			boolean isWholeDay) throws SQLException {
		

	}

	public String toString() {
		return text;
	}
}

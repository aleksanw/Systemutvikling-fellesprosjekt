package common;

import org.joda.time.DateTime;



public interface WeekI {
	public void setWeek(int year, int weeknr);

	public String getWeek();

	public int getYear();

	public int getWeeknr();

	public DateTime getFromDate();

	public DateTime getToDate();

	public String toString();

	//public WeekI getNextWeek();

	//public WeekI getPreviousWeek();
}

package common;

public interface WeekI {
	public void setWeek(int year, int weeknr);

	public String getWeek();

	public int getYear();

	public int getWeeknr();

	public int getFromDate();

	public int getToDate();

	public void setDate(int date);

	public String toString();

	public WeekI getNextWeek();

	public WeekI getPreviousWeek();
}

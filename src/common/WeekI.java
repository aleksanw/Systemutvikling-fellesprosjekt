package common;

public interface WeekI {
	//public void WeekI(int year, int weeknr);
	public void setWeek(int year, int weeknr);
	public String getWeek();
	public int getYear();
	public int getWeeknr();
	public String toString();
	public WeekI getNextWeek();
	public WeekI getPreviousWeek();
}

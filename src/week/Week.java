package week;

import common.WeekI;

public class Week implements WeekI {

	int year;
	int weeknr;

	public Week(int year, int weeknr) {
		this.year = year;
		this.weeknr = weeknr;

	}

	@Override
	public void setWeek(int year, int weeknr) {

		this.year = year;
		this.weeknr = weeknr;
	}

	@Override
	public String getWeek() {
		String result = this.year + "W: " + this.weeknr;
		return result;
	}

	@Override
	public int getYear() {
		return year;
	}

	@Override
	public int getWeeknr() {
		return weeknr;
	}

	@Override
	public common.WeekI getNextWeek() {
		if (weeknr < 51) {
			return new Week(weeknr + 1, year);

		} else
			return new Week(1, year + 1);
	}

	@Override
	public common.WeekI getPreviousWeek() {
		if (weeknr > 1) {
			return new Week(weeknr - 1, year);
		} else
			return new Week(52, year - 1);
	}
}

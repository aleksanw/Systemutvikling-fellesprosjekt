package week;

import common.WeekI;

public class Week implements WeekI {

	int year;
	int weeknr;
	int date;

	public Week(int year, int weeknr, int date) {
		this.year = year;
		this.weeknr = weeknr;
		this.date = date;

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
	public int getFromDate() {
		return date;
	}

	@Override
	public int getToDate() {
		return date;
	}

	@Override
	public common.WeekI getNextWeek() {
		if (weeknr < 51) {
			return new Week(weeknr + 1, year, date);

		} else
			return new Week(1, year + 1, date);
	}

	@Override
	public common.WeekI getPreviousWeek() {
		if (weeknr > 1) {
			return new Week(weeknr - 1, year, date);
		} else
			return new Week(52, year - 1, date);
	}

	@Override
	public void setDate(int date) {
		this.date = date;
	}

}

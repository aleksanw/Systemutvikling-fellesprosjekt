package week;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;

import common.WeekI;

public class Week implements WeekI {

	int year;
	int weeknr;
	private MutableDateTime date;

	public Week(DateTime date) {
		this.year = date.getYear();
		this.weeknr = date.getWeekOfWeekyear();
	}

	@Override
	public void setWeek(int year, int weeknr) {
		this.year = year;
		this.weeknr = weeknr;
	}

	@Override
	public String getWeek() {
		return this.year + "W" + this.weeknr;
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
	public DateTime getFromDate() {
		DateTime res = new DateTime(date);
		while(res.getDayOfWeek() > 1){
			res.plusDays(-1);
		}
		return res;
	}

	@Override
	public DateTime getToDate() {
		DateTime res = new DateTime(date);
		while(res.getDayOfWeek() > 1){
			res.plusDays(1);
		}
		return res;
	}

	/*@Override
	public common.WeekI getNextWeek() {
		return new Week((common.WeekI)date.addDays(7));
	}

	@Override
	public common.WeekI getPreviousWeek() {
		if (weeknr > 1) {
			return new Week(weeknr - 1, year, date);
		} else
			return new Week(52, year - 1, date);
	}*/
}

package client.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.joda.time.DateTime;

import common.WeekI;

class Buttons extends JPanel implements ActionListener {

	private JButton event, meating, groups, logout, rArrow, lArrow, toCurWeek;
	private JLabel curWeek;
	protected DateTime date;
	protected int weekNr, year;
	protected WeekI w;

	GridBagConstraints gbc = new GridBagConstraints();

	public Buttons() {
		date = MainClass.now;

		weekNr = date.getWeekOfWeekyear();
		year = date.getYear();

		event = new JButton("Legg Til Avtale");
		event.addActionListener(this);

		meating = new JButton("Opprett Møte");
		meating.addActionListener(this);

		groups = new JButton("Gruppeinnstillinger");
		groups.addActionListener(this);

		curWeek = new JLabel();
		toCurrentWeek();

		rArrow = new JButton(">");
		rArrow.addActionListener(this);

		lArrow = new JButton("<");
		lArrow.addActionListener(this);

		toCurWeek = new JButton("Denne uken");
		toCurWeek.addActionListener(this);

		logout = new JButton("Logg Ut");
		logout.addActionListener(this);

		setLayout(new GridBagLayout());
		gbc.gridy = 0;
		add(event, gbc);
		add(meating, gbc);
		add(groups, gbc);
		add(curWeek, gbc);
		add(lArrow, gbc);
		add(rArrow, gbc);
		add(toCurWeek, gbc);
		add(logout, gbc);
	}

	private void toCurrentWeek() {
		weekNr = date.getWeekOfWeekyear();
		year = date.getYear();
		curWeek.setText("Uke " + weekNr + ", " + date.getYear());
	}

	public void nextWeek() {
		weekNr += 1;
		curWeek.setText("Uke " + weekNr + ", " + year);
	}

	public void prevWeek() {
		weekNr -= 1;
		curWeek.setText("Uke " + weekNr + ", " + year);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().toString().equals("Legg Til Avtale")) {
			MainClass.runAddEvent();
		} else if (e.getActionCommand().toString().equals("Logg Ut")) {
			MainClass.setCurrentUser(null);
			MainClass.logout();
		} else if (e.getActionCommand().toString().equals("<")) {
			if (validWeek(weekNr - 1)) {
				MainClass.now = MainClass.now.minusDays(7);
				prevWeek();
			} else {
				prevYear();
			}
			MainClass.loginOK();
		} else if (e.getActionCommand().toString().equals(">")) {
			if (validWeek(weekNr + 1)) {
				MainClass.now = MainClass.now.plusDays(7);
				nextWeek();
			} else {
				nextYear();
			}
			MainClass.loginOK();
		} else if (e.getActionCommand().toString().equals("Opprett Møte")) {
			MainClass.runAddMeeting();
		} else if (e.getActionCommand().toString()
				.equals("Gruppeinnstillinger")) {
			MainClass.runGroupSettings();
		} else if (e.getActionCommand().toString().equals("Denne uken")) {
			MainClass.now = DateTime.now();
			date = MainClass.now;
			toCurrentWeek();
		MainClass.loginOK();
		}
	}

	public boolean validWeek(int wNr) {
		if (wNr > 52) {
			return false;
		} else if (wNr < 1) {
			return false;
		}
		return true;
	}

	public void prevYear() {
		year -= 1;
		weekNr = 52;
		curWeek.setText("Uke " + weekNr + ", " + year);
	}

	public void nextYear() {
		year += 1;
		weekNr = 1;
		curWeek.setText("Uke " + weekNr + ", " + year);
	}

	public WeekI getWeek() {
		w.setWeek(year, weekNr);
		return w;
	}
}

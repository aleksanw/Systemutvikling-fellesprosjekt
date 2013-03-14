package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.joda.time.DateTime;

import server.storage.EventStorage;

@SuppressWarnings("serial")
public class AddEvent extends JPanel implements ActionListener {

	protected JLabel title, lAlarm, start, end, lAllDay, lDesc, visible, lName;
	protected JTextField name;
	protected JTextArea desc;
	protected JComboBox<String> hour, min, hourE, minE, alarm, group, vis, day,
			month, dayE, monthE;
	protected JRadioButton allDay;
	protected JButton save, delete, cancel;
	protected JTabbedPane tabs;
	protected Place place = new Place();
	protected Booking booking = new Booking();
	private DateTime StartTime;

	GridBagConstraints g = new GridBagConstraints();

	public AddEvent() {
		g.fill = GridBagConstraints.BOTH;

		String[] hours = addNum(0, 24);
		String[] minutes = { "00", "15", "30", "45" };
		String[] minForAlarm = { "Ingen alarm", "10 min", "15 min", "20 min",
				"30 min", "1 time", "2 timer", "24 timer" };
		String[] days = addNum(1, 32);
		String[] months = { "Mars 2013", "April 2013" };

		title = new JLabel();
		title.setText("Legg til/endre avtale");

		lName = new JLabel();
		lName.setText("Navn:");

		name = new JTextField(30);

		tabs = new JTabbedPane();
		tabs.setPreferredSize(new Dimension(250, 200));
		tabs.addTab("Sted", place);
		tabs.addTab("Book møterom", booking);
		tabs.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		start = new JLabel();
		start.setText("Start:");
		hour = new JComboBox<String>(hours);
		hour.addActionListener(new timeBoxActionListener());
		min = new JComboBox<String>(minutes);
		min.addActionListener(new timeBoxActionListener());

		end = new JLabel();
		end.setText("Slutt:");
		hourE = new JComboBox<String>(hours);
		minE = new JComboBox<String>(minutes);

		lAllDay = new JLabel();
		lAllDay.setText("Hele dagen:");
		allDay = new JRadioButton();
		allDay.addActionListener(this);

		lDesc = new JLabel();
		lDesc.setText("Beskrivelse:");
		desc = new JTextArea(5, 20);

		lAlarm = new JLabel();
		lAlarm.setText("Legg Til Alarm:");
		alarm = new JComboBox<String>(minForAlarm);

		day = new JComboBox<String>(days);
		day.addActionListener(new timeBoxActionListener());

		dayE = new JComboBox<String>(days);

		month = new JComboBox<String>(months);
		month.addActionListener(new timeBoxActionListener());

		monthE = new JComboBox<String>(months);

		save = new JButton();
		save.setText("Lagre");
		save.addActionListener(this);

		delete = new JButton();
		delete.setText("Slett");
		delete.addActionListener(this);

		cancel = new JButton();
		cancel.setText("Avbryt");
		cancel.addActionListener(this);

		visible = new JLabel();
		visible.setText("Synlig for:");
		vis = new JComboBox<String>();

		booking.date.setText("klokken " + hour.getSelectedItem().toString()
				+ ":" + min.getSelectedItem().toString() + " den "
				+ day.getSelectedItem().toString() + ". "
				+ month.getSelectedItem().toString());

		buildPanel();

	}

	public void buildPanel() {
		setLayout(new GridBagLayout());

		g.gridwidth = 4;
		g.gridy = 0;
		g.gridx = 1;
		add(title, g);

		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		add(lName, g);
		g.gridx = 1;
		g.gridwidth = 4;
		add(name, g);

		g.gridwidth = 1;
		g.gridx = 0;
		g.gridy = 2;
		add(start, g);
		g.gridx = 1;
		add(hour, g);
		g.gridx = 2;
		add(min, g);
		g.gridx = 3;
		add(day, g);
		g.gridx = 4;
		add(month, g);

		g.gridx = 0;
		g.gridy = 3;
		add(end, g);
		g.gridx = 1;
		add(hourE, g);
		g.gridx = 2;
		add(minE, g);
		g.gridx = 3;
		add(dayE, g);
		g.gridx = 4;
		add(monthE, g);

		g.gridx = 0;
		g.gridy = 4;
		add(lAllDay, g);
		g.gridx = 1;
		add(allDay, g);

		g.gridx = 0;
		g.gridy = 5;
		add(lDesc, g);
		g.gridx = 1;
		g.gridwidth = 4;
		add(desc, g);

		g.gridwidth = 1;
		g.gridy = 6;
		g.gridx = 0;
		add(lAlarm, g);
		g.gridx = 1;
		g.gridwidth = 3;
		add(alarm, g);

		g.gridy = 7;
		g.gridx = 0;
		g.gridwidth = 8;
		add(tabs, g);

		g.gridwidth = 1;
		g.gridy = 8;
		g.gridx = 0;
		add(visible, g);
		g.gridx = 1;
		add(vis, g);

		g.gridx = 5;
		add(save, g);
		g.gridx = 6;
		add(delete, g);
		g.gridx = 7;
		add(cancel, g);

	}

	private class timeBoxActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			booking.date.setText("klokken " + hour.getSelectedItem().toString()
					+ ":" + min.getSelectedItem().toString() + " den "
					+ day.getSelectedItem().toString() + ". "
					+ month.getSelectedItem().toString());
		}
	}

	public String[] addNum(int k, int i) {
		String[] resList = new String[i];
		for (int j = k; j < i; j++) {
			resList[j - k] = Integer.toString(j);
		}
		return resList;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().toString().equals("Lagre")) {
			MainClass.loginOK();
			clearFields();
			// lagre
		} else if (e.getActionCommand().toString().equals("Slett")) {
			MainClass.loginOK();
			clearFields();
			// delete
		} else if (e.getActionCommand().toString().equals("Avbryt")) {
			MainClass.loginOK();
			clearFields();
		} else if (allDay.isSelected()) {
			hourE.setEnabled(false);
			minE.setEnabled(false);
			dayE.setEnabled(false);
			monthE.setEnabled(false);
		} else if (!allDay.isSelected()) {
			hourE.setEnabled(true);
			minE.setEnabled(true);
			dayE.setEnabled(true);
			monthE.setEnabled(true);
		}
	}

	private void clearFields() {
		name.setText("");
		hour.setSelectedIndex(0);
		min.setSelectedIndex(0);
		month.setSelectedIndex(0);
		hourE.setSelectedIndex(0);
		minE.setSelectedIndex(0);
		monthE.setSelectedIndex(0);
		day.setSelectedIndex(0);
		dayE.setSelectedIndex(0);
		if (allDay.isSelected()) {
			allDay.setSelected(false);
			hourE.setEnabled(true);
			minE.setEnabled(true);
			dayE.setEnabled(true);
			monthE.setEnabled(true);
		}
		desc.setText("");
		alarm.setSelectedIndex(0);
		place.text.setText("");
	}

	private void saveEvent() {
		
	}

	private int findYear() {
		String[] y = month.getSelectedItem().toString().split(" ");
		return Integer.parseInt(y[1]);
	}
}

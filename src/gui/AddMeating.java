package gui;

import java.awt.GridBagConstraints;

public class AddMeating extends AddEvent {

	private Participants part;

	public AddMeating() {
		super();
		remove(allDay);
		remove(alarm);
		remove(lAlarm);
		remove(lAllDay);
		remove(vis);
		remove(visible);

		part = new Participants();
		
		g.fill = GridBagConstraints.EAST;

		g.gridx = 9;
		g.gridy = 1;
		g.gridheight = 8;
		add(part, g);
	}
}

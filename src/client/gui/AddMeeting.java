package client.gui;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class AddMeeting extends AddEvent {

	private Participants part;

	public AddMeeting() {
		super();
		remove(allDay);
		remove(setAlarm);
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

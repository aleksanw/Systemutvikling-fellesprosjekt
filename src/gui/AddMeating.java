package gui;

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

		g.gridx = 2;
		g.gridy = 1;
		g.gridheight = 7;

		add(part, g);
	}
}

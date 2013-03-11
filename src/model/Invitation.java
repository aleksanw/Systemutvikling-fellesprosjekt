package model;

import org.joda.time.DateTime;

public class Invitation extends Model {
	
	private boolean isAttending;
	private DateTime timeDateOfInvitation;
	private Event invitedTo;
}

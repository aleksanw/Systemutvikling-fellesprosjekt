package server.model;

import java.sql.Time;
import java.util.ArrayList;

import org.joda.time.DateTime;

import server.system.StorageServer;
import client.gui.MainClass;
import client.system.StorageServerConnection;

import common.AlarmI;
import common.EventI;
import common.InvitationI;

public class EventTest {
	public void testSimple() throws Exception {
		
		// Ting som er kommentert ut er ting som enda ikke fungerer.
		
		// Run server
		new StorageServer();
		
		// Set up client
		StorageServerConnection client = new StorageServerConnection();
		
		// Create a new Event
		EventI event = client.eventStorage.create();	
		
		// Update fields (this is instantly sent to database)
		event.setEventName("KTN forelesning");
		event.setMeeting(true);
		event.setStart(new DateTime("2013-03-15 12:15:00"));
		event.setEnd(new DateTime("2013-03-15 15:00:00"));
		event.setLocation("R1");
		
		// Delete
		//TODO: This don't work of some reason
		//client.eventStorage.delete(event);
	}
	
	public void testWithRelations() throws Exception {
		
		// Run server
		new StorageServer();
		
		// Set up client
		StorageServerConnection client = new StorageServerConnection();
		
		// Create a new Event
		EventI event = client.eventStorage.create();	
		
		// Update fields (this is instantly sent to database)
		event.setEventName("KTN forelesning");
		event.setCreatedByUser(MainClass.getCurrentUser());
		event.setMeeting(true);
		event.setStart(new DateTime("2013-03-15 12:15:00"));
		event.setEnd(new DateTime("2013-03-15 15:00:00"));
		
		// Set up Alarm
		AlarmI alarm = client.alarmStorage.create();
		alarm.setUser(MainClass.getCurrentUser());
		alarm.setEvent(event);
		alarm.setNumberOfHoursBeforeMeeting(new Time(1,0,0));
		
		// Specify that this is a meeting
		event.setMeeting(true);
		
		// Send invitations
		InvitationI invitation = client.invitationStorage.create();
		invitation.setEvent(event);
		AlarmI alarm = client.alarmStorage.create();
		invitation.setUser(user);
		
		// Set location
		//event.setLocation("Auditorie R1");
		
		// OR book a Room
		ArrayList rooms = client.roomStorage.getAll();
		event.setRoomBooked(rooms[0]);
		
		// Delete
		client.eventStorage.delete(event);
	}
}

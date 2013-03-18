package server.model;

import java.sql.Time;
import java.util.ArrayList;

import junit.extensions.jfcunit.JFCTestCase;

import org.joda.time.DateTime;
import exceptions.ObjectNotFoundException;

import server.system.StorageServer;
import client.gui.MainClass;
import client.system.StorageServerConnection;


import common.AlarmI;
import common.EventI;
import common.GroupI;
import common.InvitationI;
import common.RoomI;
import common.UserI;

public class EventTest extends JFCTestCase {
	public void testWithoutDB() throws Exception {
		
		// Ting som er kommentert ut er ting som enda ikke fungerer.
		
		// Run server
		StorageServer server = new StorageServer();
		
		// Set up client
		StorageServerConnection client = new StorageServerConnection();
		
		// Create a new Event
		EventI event = client.eventStorage.create();
		GroupI myGroup = client.groupStorage.create();
		
		// Update fields (this is instantly sent to database)
		event.setEventName("KTN forelesning");
		//event.setCreatedByGroup(myGroup);
		event.setMeeting(false);
		event.setStart(new DateTime("2013-03-15T12:15:00"));
		event.setEnd(new DateTime("2013-03-15T15:00:00"));
		event.setLocation("R1");
		
		// Get and check if correct
		//assertEquals(myGroup.getGroupID(), eventFromDB.getCreatedByUser().getGroupID());
		assertEquals("KTN forelesning", event.getEventName());
		assertEquals(new DateTime("2013-03-15T12:15:00").toString(), event.getStart().toString());
		assertEquals(new DateTime("2013-03-15T15:00:00").toString(), event.getEnd().toString());
		assertEquals("R1", event.getLocation());
		
		// Delete
		client.eventStorage.delete(event);
		
		
		server.killServer();
	}
	
	public void testSimpleGroupAvtale() throws Exception {
		
		// Ting som er kommentert ut er ting som enda ikke fungerer.
		
		// Run server
		StorageServer server = new StorageServer();
		
		// Set up client
		StorageServerConnection client = new StorageServerConnection();
		
		// Create a new Event
		EventI event = client.eventStorage.create();
		GroupI myGroup = client.groupStorage.create();
		
		// Update fields (this is instantly sent to database)
		event.setEventName("KTN forelesning");
		event.setCreatedByGroup(myGroup);
		event.setMeeting(false);
		event.setStart(new DateTime("2013-03-15T12:15:00"));
		event.setEnd(new DateTime("2013-03-15T15:00:00"));
		event.setLocation("R1");
		
		// Get and check if correct
		int eventID = event.getEventID();
		EventI eventFromDB = client.eventStorage.get(eventID);
		
		assertEquals(event.getEventID(), eventFromDB.getEventID());
		assertEquals(myGroup.getGroupID(), eventFromDB.getCreatedByUser().getGroupID());
		assertEquals("KTN forelesning", eventFromDB.getEventName());
		assertEquals(new DateTime("2013-03-15T12:15:00").toString(), eventFromDB.getStart().toString());
		assertEquals(new DateTime("2013-03-15T15:00:00").toString(), eventFromDB.getEnd().toString());
		assertEquals("R1", eventFromDB.getLocation());
		
		
		// Delete
		client.eventStorage.delete(event);
		
		
		server.killServer();
	}
	
	public void testMeeting() throws Exception {
		
		// Run server
		StorageServer server = new StorageServer();
		
		// Set up client
		StorageServerConnection client = new StorageServerConnection();
		
		// Create a new Event
		EventI event = client.eventStorage.create();
		UserI currentUser = client.userStorage.create();
		
		// Update fields (this is instantly sent to database)
		event.setEventName("KTN forelesning");
		event.setCreatedByUser(currentUser);
		event.setStart(new DateTime("2013-03-15 12:15:00"));
		event.setEnd(new DateTime("2013-03-15 15:00:00"));
		
		// Set up Alarm
		AlarmI alarm = client.alarmStorage.create();
		alarm.setUser(currentUser);
		alarm.setEvent(event);
		alarm.setNumberOfHoursBeforeMeeting(new Time(1,0,0));
		
		// Specify that this is a meeting
		event.setMeeting(true);
		
		// Send invitations
		InvitationI invitation = client.invitationStorage.create();
		invitation.setEvent(event);
		ArrayList<UserI> users = client.alarmStorage.getAll();
		invitation.setUser(user);
		
		// Book a Room
		ArrayList<RoomI> rooms = client.roomStorage.getAll();
		event.setRoomBooked(rooms[0]);
		
		// Get and check if correct
		int eventID = event.getEventID();
		int invitationID = invitation.getInvitationID();
		int alarmID = alarm.getAlarmID();
		int roomID = rooms[0].getRoomID();
		EventI eventFromDB = client.eventStorage.get(eventID);
	
		assertEquals(event.getEventID(), eventFromDB.getEventID());
		assertEquals("KTN forelesning", eventFromDB.getEventName());
		assertEquals(new DateTime("2013-03-15T12:15:00").toString(), eventFromDB.getStart().toString());
		assertEquals(new DateTime("2013-03-15T15:00:00").toString(), eventFromDB.getEnd().toString());
		
		assertEquals(currentUser.getUserID(), eventFromDB.getCreatedByUser().getUserID());
		assertEquals(roomID, eventFromDB.getRoomBooked().getRoomID());
		assertEquals(1, eventFromDB.getInvitationList().size());
		assertEquals(invitationID, eventFromDB.getInvitationList().get(0).getInvitationID());
		assertEquals(alarmID, client.alarmStorage.get(event, currentUser));
		
		// Delete
		client.eventStorage.delete(event);
		
		// This should result in an Exception
		try {
			client.eventStorage.get(eventID);
		    fail("Event wasn't deleted");
		} catch (ObjectNotFoundException e) {
		}
		try {
			client.alarmStorage.get(alarmID);
		    fail("Alarm wasn't deleted");
		} catch (ObjectNotFoundException e) {
		}
		try {
			client.invitationStorage.get(invitationID);
		    fail("Invitation wasn't deleted");
		} catch (ObjectNotFoundException e) {
		}
		
		server.killServer();
	}
	
	public void testPropertyChangeListner() {
		fail("Not implemented yet");
	}
}
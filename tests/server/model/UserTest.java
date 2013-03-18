package server.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import org.joda.time.DateTime;
import server.system.StorageServer;
import client.gui.MainClass;
import client.system.StorageServerConnection;
import common.AlarmI;
import common.EventI;
import common.UserI;

public class UserTest {
		
	public void test() throws Exception{
		
		new StorageServer();
		
		StorageServerConnection client = new StorageServerConnection();
		
		
		UserI user = client.userStorage.create();
		
		//Updating fields
		user.setEmail("ntnu@gmail.com");
		user.setName("Ole Brumm");
		user.setDateOfBirth(new Date(1991-06-02));
		
		//creating test Event
		
		EventI event = client.eventStorage.create();
		event.setEventName("KTN forelesning");
		//event.setCreatedByUser(MainClass.getCurrentUser());
		event.setMeeting(false);
		event.setStart(new DateTime("2013-03-15T12:15:00"));
		event.setEnd(new DateTime("2013-03-15T15:00:00"));
		user.delete();
	}
}
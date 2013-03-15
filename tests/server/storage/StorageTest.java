package server.storage;

import java.rmi.RemoteException;
import java.sql.SQLException;

import server.model.Event;
import server.system.StorageServer;
import client.system.StorageServerConnection;
import junit.extensions.jfcunit.JFCTestCase;

public class StorageTest  extends JFCTestCase {
	public void testSimple() throws Exception { // THIS IS JUST FOR DEBUGGING
		
		// Set up different client
		StorageServer server = new StorageServer();

		StorageServerConnection client1 = new StorageServerConnection();
		StorageServerConnection client2 = new StorageServerConnection();

		// NB: BØR DET VÆRE EventI(nterface) her?
		Event eventClient1 = client1.eventStorage.create();	
		int eventID = eventClient1.getEventID();
		
		// Test om oppdatering av navn fungerer
		eventClient1.setEventName("Test123");
		assertEquals("Test123", eventClient1.getEventName());
		
		// Test om også oppdatert på serveren
		Event eventServer = server.eventStorage.get(eventID);
		assertEquals("Test123", eventServer.getEventName());
		
		// Test om også oppdatert på klient2
		Event eventClient2 = client2.eventStorage.get(eventID);
		assertEquals("Test123", eventClient2.getEventName());
		
	}
}

package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import junit.extensions.jfcunit.JFCTestCase;

import server.system.RMIServer;
import storage.EventStorage;
import client.system.RMIClient;

public class RMITest extends JFCTestCase {
	public interface TestI extends Remote {
		public String getValue() throws RemoteException;
		public void setValue(String value) throws RemoteException;
	}
	
	public class Test extends UnicastRemoteObject implements TestI {
		private String value;
		
		public Test() throws RemoteException {
		}
		
		public String getValue() throws RemoteException {
			return this.value;
		}
		
		public void setValue(String value) throws RemoteException {
			this.value = value;
		}
	}
	
	public void testSimpleConnection() throws RemoteException {
		RMIServer server = new RMIServer();
		Test testServer = new Test();
		testServer.setValue("Test123");
		server.addObject("Test", testServer);
		
		RMIClient client = new RMIClient();
		TestI test = (TestI)client.getRMIObjectFromServer("Test");
		
		
		assertEquals("Test123", test.getValue());
	}
}

package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import junit.extensions.jfcunit.JFCTestCase;

import server.system.RMIServer;
import storage.EventStorage;
import client.system.RMIClient;

/**
 * TODO: Will not allow you to open more than one connection. Therefor you can not run more than one test at once.
 * @author jont
 *
 */

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
	/*
	public void testSimpleConnection() throws RemoteException {
		RMIServer server = new RMIServer();
		Test testServer = new Test();
		testServer.setValue("Test123");
		server.addObject("Test", testServer);
		
		RMIClient client = new RMIClient();
		TestI testClient = (TestI)client.getRMIObjectFromServer("Test");
		
		
		assertEquals("Test123", testClient.getValue());
	}
	*/
	
	public void testTwoClients() throws RemoteException {
		RMIServer server = new RMIServer();
		Test testServer = new Test();
		server.addObject("Test", testServer);
		
		RMIClient client1 = new RMIClient();
		TestI testClient1 = (TestI)client1.getRMIObjectFromServer("Test");
		
		RMIClient client2 = new RMIClient();
		TestI testClient2 = (TestI)client2.getRMIObjectFromServer("Test");
		
		testServer.setValue("Test1");
		assertEquals("Test1", testServer.getValue());
		assertEquals("Test1", testClient1.getValue());
		assertEquals("Test1", testClient2.getValue());
		
		testClient1.setValue("Test2");
		assertEquals("Test2", testServer.getValue());
		assertEquals("Test2", testClient1.getValue());
		assertEquals("Test2", testClient2.getValue());
		
		testServer.setValue("Test3");
		assertEquals("Test3", testServer.getValue());
		assertEquals("Test3", testClient1.getValue());
		assertEquals("Test3", testClient2.getValue());
	}
}

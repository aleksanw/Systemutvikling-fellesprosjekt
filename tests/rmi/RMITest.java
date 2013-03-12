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
		public String getInitValue() throws RemoteException;
	}
	
	public class Test extends UnicastRemoteObject implements TestI {
		private String initvalue;
		
		public Test(String initvalue) throws RemoteException {
			this.initvalue = initvalue;
		}
		
		public String getInitValue() throws RemoteException {
			return this.initvalue;
		}
	}
	
	public void testRMIConnection() throws RemoteException {
		RMIServer rmiServer = new RMIServer();
		rmiServer.addObject("Test", new Test("Test123"));
		
		RMIClient server = new RMIClient();
		TestI test = (TestI)server.getRMIObjectFromServer("Test");
		
		
		assertEquals("Test123", test.getInitValue());
	}
}

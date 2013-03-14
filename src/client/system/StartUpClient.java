package client.system;

import java.rmi.RemoteException;


public class StartUpClient {
	public static void main(String[] args) throws RemoteException {
		StorageServerConnection server = new StorageServerConnection();
	}
}
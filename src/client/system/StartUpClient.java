package client.system;

import java.rmi.RemoteException;


public class StartUpClient {
	public static void main(String[] args) throws Exception {
		StorageServerConnection server = new StorageServerConnection();
	}
}
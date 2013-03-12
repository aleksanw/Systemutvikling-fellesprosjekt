package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StorageI extends Remote {
	public String getValue()  throws RemoteException;
}

package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.Invitation;

public interface InvitationStorageI extends Remote {
	public Invitation create() throws RemoteException;
	public Invitation get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(Invitation model) throws RemoteException;
}

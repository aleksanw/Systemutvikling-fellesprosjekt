package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.Invitation;

public interface InvitationStorageI extends Remote {
	public InvitationI create() throws RemoteException;
	public InvitationI get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(Invitation model) throws RemoteException;
}

package server.storage;

import java.rmi.RemoteException;
import server.model.Invitation;
import common.InvitationStorageI;

public class InvitationStorage extends Storage implements InvitationStorageI {
	
	public InvitationStorage() throws RemoteException {
		super(Invitation.class);
	}
	
	public Invitation create() throws RemoteException {
		return (Invitation) super.create();
	}
	
	public Invitation get(int ID) throws RemoteException {
		return (Invitation) super.get(ID);
	}
	
	public void delete(int ID) throws RemoteException {
		super.delete(ID);
	}
	
	public void delete(Invitation model) throws RemoteException {
		super.delete(model);
	}
}
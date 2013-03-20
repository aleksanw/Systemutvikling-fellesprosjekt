package server.storage;

import java.rmi.RemoteException;

import server.listModel.EventsInvitedTo;
import server.model.Invitation;
import server.model.User;

import common.InvitationI;
import common.InvitationListI;
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

	public void delete(InvitationI model) throws RemoteException {
		super.delete(model);
	}

	public InvitationListI getInvitationList(User user) throws RemoteException {
		return (InvitationListI) new EventsInvitedTo(user);
	}
}
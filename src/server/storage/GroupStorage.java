package server.storage;

import java.rmi.RemoteException;
import server.model.Group;
import common.GroupStorageI;

public class GroupStorage extends Storage implements GroupStorageI {
	
	public GroupStorage() throws RemoteException {
		super(Group.class);
	}
	
	public Group create() throws RemoteException {
		return (Group) super.create();
	}
	
	public Group get(int ID) throws RemoteException {
		return (Group) super.get(ID);
	}
	
	public void delete(int ID) throws RemoteException {
		super.delete(ID);
	}
	
	public void delete(Group model) throws RemoteException {
		super.delete(model);
	}
}
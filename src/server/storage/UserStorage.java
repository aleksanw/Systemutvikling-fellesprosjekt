package server.storage;

import java.rmi.RemoteException;
import server.model.User;
import common.UserI;
import common.UserStorageI;

public class UserStorage extends Storage implements UserStorageI {
	
	public UserStorage() throws RemoteException {
		super(User.class);
	}
	
	public User create() throws RemoteException {
		return (User) super.create();
	}
	
	public User get(int ID) throws RemoteException {
		return (User) super.get(ID);
	}
	
	public void delete(int ID) throws RemoteException {
		super.delete(ID);
	}
	
	public void delete(UserI model) throws RemoteException {
		super.delete(model);
	}
}
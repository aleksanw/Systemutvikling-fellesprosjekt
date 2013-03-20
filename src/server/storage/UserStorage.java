package server.storage;

import java.rmi.RemoteException;

import server.listModel.UserList;
import server.model.Group;
import server.model.User;

import common.GroupI;
import common.UserI;
import common.UserListI;
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

	public UserListI getUserList(Group group) throws RemoteException {
		return (UserListI) new UserList(group);
	}

	@Override
	public UserListI getUserList(GroupI group) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserI login(String username, String password) throws RemoteException {
		UserI user = new User(username, password);
		Integer userID = user.getUserID();
		if (userID == 0) {
			return null;
		}
		return this.get(user.getUserID());
	}
}
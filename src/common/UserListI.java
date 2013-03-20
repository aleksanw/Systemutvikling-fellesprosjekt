package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UserListI extends ListModelI {
	public ArrayList<UserI> getList() throws RemoteException;

}
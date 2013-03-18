package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GroupI extends Remote {

	public abstract int getGroupID() throws RemoteException;

	public abstract String getGroupName() throws RemoteException;

	public abstract int getParentGroupID() throws RemoteException;

	public abstract void setParentGroupID(int parentGroupID) throws RemoteException;

	public abstract void setGroupName(String groupName) throws RemoteException;

	public abstract void delete() throws RemoteException;

}
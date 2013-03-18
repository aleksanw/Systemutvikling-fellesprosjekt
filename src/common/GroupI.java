package common;

import java.rmi.RemoteException;

public interface GroupI extends ModelI {

	public abstract int getGroupID() throws RemoteException;

	public abstract String getGroupName() throws RemoteException;

	public abstract GroupI getParentGroup() throws RemoteException;

	public abstract void setParentGroup(GroupI parentGroup) throws RemoteException;

	public abstract void setGroupName(String groupName) throws RemoteException;

	public abstract void delete() throws RemoteException;

}